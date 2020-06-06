package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clinic implements java.io.Serializable {
	private static Clinic instance;
	
	private final String city;
	private final long id;
	private Manager manager;
	
	private Clinic(String city, long cId, String mId, int phone, String name, String email,String password,String user_type) {
		this.city = city;
		this.id = cId;
		this.manager = new Manager(mId, phone, name, email, password, user_type);
		
	}
	
	public String getCity() {
		return city;
	}
	
	public long getId() {
		return id;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("/files/clinic.ser");
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
	
	public Clinic deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("/files/clinic.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          Clinic e = (Clinic) in.readObject();
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

	public static Clinic getInstance(String city, long cId, String mId, int phone, String name, String email,String password,String user_type) {
		if(instance == null)
			instance = new Clinic(city, cId, mId, phone, name, email, password, user_type);
		return instance;
	}
}
