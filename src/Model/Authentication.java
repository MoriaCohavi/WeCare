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
	
	
	public static String signIn(String id, String password)
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
						return generateToken(id);
						
					}
			}
		}
		
		return "User name and password does not match";
	}
	
	public boolean signOut(String token)
	{
		if(users.get(token) != null)
		{
			users.get(token).revokeToken();
			return true;
		}
		return false;
	}
	
	public static boolean validateUser(String token,String typeNeed)
	{
		if(!(users.get(token) == null || typeNeed != users.get(token).getUser_type()) // type need has to come from authentication controller.
			return false;
		else
			return true;
	}
	
	public static boolean resetPassword(String token, String cPassword, String newPassword)
	{
		if(SHA1(cPassword) != users.get(token).getPassword())
			return false;
		
		users.get(token).setPassword(newPassword);
		return true;
	}
	
	public String generateToken(String id) 
	{
		long leftLimit = 1000000000L;
		long rightLimit = 9999999999L;
		long token = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
			while(!checkToken(token))
			{
				token = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
			}
			users.get(id).SetToken(token);
			return token;
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
