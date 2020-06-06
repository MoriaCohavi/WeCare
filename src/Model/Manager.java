package Model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Manager extends Person implements java.io.Serializable {
	
	private HashMap<String, Doctor> doctors;

	public Manager(String id, int phone, String name, String email) {
		super(id, phone, name, email);
		
		doctors  = new HashMap <String, Doctor>();
	}
	
	public String getID() {
		return this.getId();
		
	}
	
	public int getPhone() {
		return this.getPhone();
	}
	
	public String getName() {
		return this.getName();
	}
	
	public String getEmail() {
		return this.getEmail();
	}
	
	public void updatePhone(int newPhone){
		this.setPhone(newPhone);
	}

	public void updateEmail(String newEmail){
		this.setEmail(newEmail);
	}
	
	
	
	
	public boolean searchDoctor(String doctodID) {
		
		if(doctors.containsKey(doctodID)) return true;
		
		return false;
			
	}
	
	public boolean addDoctor(Doctor newDoc) {
		
		if (!searchDoctor(newDoc.getDoctorID()))
		{
			doctors.put(newDoc.getDoctorID(), newDoc);
			return true;
		}
		return false;
		
	}
	
	public boolean removeDoctor(String docID) {
			
			if (searchDoctor(docID)) {
				doctors.remove(docID);
				return true;
			}
			
			return false;		
			
	}
	
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("/files/manager.ser");
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
	
	public Manager deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("/files/manager.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          Manager e = (Manager) in.readObject();
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
