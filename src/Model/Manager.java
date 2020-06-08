package Model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Manager extends User implements java.io.Serializable {
	
	private HashMap<String, Doctor> doctors;

	public Manager(String id, long phone, String name, String email,String password,String user_type) {
		super(id,phone,name, email, password, user_type);
		
		doctors  = new HashMap <String, Doctor>();
	}
	
	public String getID() {
		return this.getId();
		
	}
	
	public long getPhone() {
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
	
	
	
	
	public boolean searchDoctor(String doctorID) {
		
		if(doctors.containsKey(doctorID)) return true;
		
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
}
