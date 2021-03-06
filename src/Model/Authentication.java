package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;

public class Authentication implements java.io.Serializable {
	private static HashMap<String,User> users = new HashMap<String,User>();
	private static HashMap<Long,User> loggedinusers = new HashMap<Long,User>();
	
	public Authentication() {	
	}
	
	/**getters and setters**/
	
	public static String getType(long token) {
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
	
	/**methods**/
	
	public static int signUp(String id, User user) {
		if  (users.containsKey(id))
			return -1;
		users.put(id, user);
		return 1;
	}
	
	public static long signIn(String id, String password) {
		if (!users.isEmpty()) {
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
	
	public static String SHA1(String password) { // this function take a clear password and change it to SHA1 hash.
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
	
	public static boolean deleteSignUp(String id) {
		if 	(users.containsKey(id)) {
			users.remove(id);
			return true;
		}
		
		return false;
	}
	
	public static boolean signOut(long token) {
		if(loggedinusers.containsKey(token)) {
			loggedinusers.get(token).revokeToken();
			loggedinusers.remove(token, loggedinusers.get(token));
			return true;
		}
		
		return false;
	}
	
	public static boolean validateUser(long token,String typeNeed) {
		if(!(loggedinusers.containsKey(token)) || !(typeNeed.equals(loggedinusers.get(token).getUser_type())))
			return false;
		else
			return true;
	}
	
	public static long generateToken(String id)  {
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
	
	private static boolean checkToken(long token) {
		for(Long key:loggedinusers.keySet()) {
			if(loggedinusers.get(key).getToken() == token)
				return false;
		}
		
		return true;
	}
	
	private boolean search(String userId) {
		if(users.containsKey(userId)) 
			return true;
		return false;
	}
	
	public User getItem(String userId) {
		if (search(userId))
			return users.get(userId);
			
		else 
			return null;
	}
	
	public boolean remove(String userId) {	
		if (search(userId)) {
			users.remove(userId);
			return true;
		}
		
		return false;		
	}
	
	public static boolean updateDoctorInfo(String docId,  String email, long phone) {
		if (users.containsKey(docId)) {
			users.get(docId).setEmail(email);
			users.get(docId).setPhone(phone);
			return true;
		}
		
		return false;
	}
}
	