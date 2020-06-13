package Model;
import java.io.*;

public class User extends Person implements java.io.Serializable {
	
	private String password;
	private String user_type;
	private long token;
	
	public User(String id, long phone, String name, String email, String password, String user_type) {
		super(id, phone, name, email);
		this.password = Authentication.SHA1(password);
		this.user_type = user_type;
		this.token = 0;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Authentication.SHA1(password);
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	public long getToken() {
		return this.token;
	}
	
	public void SetToken(long token) {
		this.token = token;
	}

	
	public void revokeToken()
	{
		this.token = 0;
	}
	
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("src\\Model\\files\\user.ser");
	          ObjectOutputStream out = new ObjectOutputStream(fileOut);
	          out.writeObject(this);
	          out.close();
	          fileOut.close();
	          return true;
	       } catch (IOException i) {
	          i.printStackTrace();
	          return false;
	       }
	}
	
	public User deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("src\\Model\\files\\user.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          User e = (User) in.readObject();
	          in.close();
	          fileIn.close();
	          return e;
	       } catch (IOException i) {
	          i.printStackTrace();
	          return null;
	       } catch (ClassNotFoundException c) {
	          c.printStackTrace();
	          return null;
	       }
	}
}
