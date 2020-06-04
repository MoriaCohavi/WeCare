package Model;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;


public class Authentication {
	
	private static HashMap<String,User> users = new HashMap<String,User>(); // we need to understand how we create this list. 
	
	public static String SHA1(String password) // this function take a clear password and change it to SHA1 hash.
	{
		String sha1 = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(password.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
		return sha1;
	}
	
	
	public boolean signIn(String id, String password)
	{
	
		if (!users.isEmpty())
		{
			User user = users.get(id);
			if(user == null)
				return false;
			else
			{
				if(user.getPassword() == SHA1(password))
					{
						generateToken(id);
						return true;
					}
			}
		}
		
		return false;
	}
	
	public void signOut(String id)
	{
		users.get(id).revokeToken();
	}
	
	public boolean validateUser(String id,String typeNeed)
	{
		if(users.get(id).getToken() == 0 || typeNeed != users.get(id).getUser_type()) // type need has to come from authentication controller.
			return false;
		
		return true;
	}
	
	public boolean resetPassword(String id, String cPassword, String newPassword)
	{
		if(SHA1(cPassword) != users.get(id).getPassword())
			return false;
		
		users.get(id).setPassword(newPassword);
		return true;
	}
	
	public void generateToken(String id) 
	{
		long leftLimit = 1000000000L;
		long rightLimit = 9999999999L;
		long token = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
			while(!checkToken(token))
			{
				token = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
			}
			users.get(id).SetToken(token);
	}
	
	private boolean checkToken(long token)
	{
		for(String key:users.keySet())
		{
			if(users.get(key).getToken() == token)
				return false;
		}
		
		return true;
	}
	
}
