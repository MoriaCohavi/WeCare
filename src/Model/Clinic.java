package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clinic implements java.io.Serializable {
	String city;
	long id;
	Manager manager;
	
	public Clinic() {
	
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
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public User deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("/files/clinic.ser");
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
