package Model;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;


public class Authentication {
	
	private static HashMap<String,User> users = new HashMap<String,User>(); // we need to understand how we create this list. 
	private static HashMap<Long,User> loggedinusers = new HashMap<Long,User>();
	
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
	
	public static String getType(long token)
	{
		return loggedinusers.get(token).getUser_type();
	}
	
	public static long signIn(String id, String password)
	{
	
		if (!users.isEmpty())
		{
			User user = users.get(id);
			if(user == null)
				return -1;
			else
			{
				if(user.getPassword() == SHA1(password))
					{
						long token = generateToken(id);
						loggedinusers.put(token, user);
						return token;
						
					}
			}
		}
		
		return -1;
	}
	
	public static boolean signOut(long token)
	{
		if(loggedinusers.get(token) != null)
		{
			loggedinusers.get(token).revokeToken();
			return true;
		}
		return false;
	}
	
	public static boolean validateUser(long token,String typeNeed)
	{
		if(!(loggedinusers.get(token) == null || typeNeed != loggedinusers.get(token).getUser_type())) // type need has to come from authentication controller.
			return false;
		else
			return true;
	}
	
	public static boolean resetPassword(long token, String cPassword, String newPassword)
	{
		if(SHA1(cPassword) != loggedinusers.get(token).getPassword())
			return false;
		
		loggedinusers.get(token).setPassword(newPassword);
		return true;
	}
	
	public static long generateToken(String id) 
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
	
	private static boolean checkToken(long token)
	{
		for(Long key:loggedinusers.keySet())
		{
			if(loggedinusers.get(key).getToken() == token)
				return false;
		}
		
		return true;
	}
	
	
	
}
