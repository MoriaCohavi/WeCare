package Model;


import java.util.HashMap;

public class Manager extends Person{
	
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
	

}
