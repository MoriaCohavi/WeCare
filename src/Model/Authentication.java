package Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;


public class Authentication implements java.io.Serializable{
	
	private static HashMap<String,User> users = new HashMap<String,User>(); // we need to understand how we create this list. 
	private static HashMap<Long,User> loggedinusers = new HashMap<Long,User>();
	
	public Authentication()
	{
		
	}
	
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
	
	public static int signUp(String id, User user)
	{
		if  (users.containsKey(id))
			return -1;
		users.put(id, user);
		return 1;
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
				if(user.getPassword().equals(SHA1(password)))
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
		if(loggedinusers.containsKey(token))
		{
			loggedinusers.get(token).revokeToken();
			loggedinusers.remove(token, loggedinusers.get(token));
			return true;
		}
		return false;
	}
	
	public static boolean validateUser(long token,String typeNeed)
	{
		if(!(loggedinusers.containsKey(token)) || !(typeNeed.equals(loggedinusers.get(token).getUser_type())))
			return false;
		else
			return true;
	}
	
/*	public static boolean resetPassword(long token, String cPassword, String newPassword)
	{
		if(SHA1(cPassword) != loggedinusers.get(token).getPassword())
			return false;
		
		loggedinusers.get(token).setPassword(newPassword);
		return true;
	} */
	
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
	
	public static String getType(long token)
	{
		return loggedinusers.get(token).getUser_type();
	}
	
	public HashMap<Long, User> getLoggedinusers() {
		return loggedinusers;
	}
	
	public HashMap<String, User> getUsers() {
		return users;
	}
	
	public void setLoggedinusers(HashMap<Long, User> loggedinusers) {
		Authentication.loggedinusers = loggedinusers;
	}
	
	public void setUsers(HashMap<String, User> users) {
		Authentication.users = users;
	}
	
	public static boolean updateDoctorInfo(String patientId,  String email, long phone)
		{
			if (users.containsKey(patientId))
			{
				users.get(patientId).setEmail(email);
				users.get(patientId).setPhone(phone);
				return true;
			}
			return false;
		}
}
		//	public static boolean serialize()
//	{
//		try {
//		FileOutputStream fileOut = new FileOutputStream("src\\Model\\files\\authentication.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
//		oos.writeObject(users);
//		oos.writeObject(loggedinusers);
//		oos.close();
//		fileOut.close();
//		return true;
//		}
//		catch (IOException i)
//		{
//			i.printStackTrace();
//			return false;
//		}
//		
//	}
//	
//	public Authentication deserialize()
//	{
//		try {
//			FileInputStream fileIn = new FileInputStream("src\\Model\\files\\authentication.ser");
//			ObjectInputStream ois = new ObjectInputStream(fileIn);
//			Authentication auth = new Authentication();
//			try {
//					auth.users = (HashMap<String, User>) ois.readObject();
//				}
//			catch (ClassNotFoundException e) {
//				ois.close();
//				fileIn.close();
//				e.printStackTrace();
//				return null;
//			}
//			try {
//				auth.loggedinusers = (HashMap<Long, User>) ois.readObject();
//				}
//			catch (ClassNotFoundException e)
//			{
//				ois.close();
//				fileIn.close();
//				e.printStackTrace();
//				return null;
//			}
//			ois.close();
//			fileIn.close();
//			return auth;
//		}
//		catch (IOException i)
//		{
//			i.printStackTrace();
//			return null;
//		}
//		
//	}

