package Controller;


import Model.Doctor;
import Model.Manager;

public class managerController {
	
	private Manager clinicManager;
	//private manager view implementation
	
	
	public managerController(String id, int phone, String name, String email, String password,String user_type) { //needs to include manger view object
		
		clinicManager = new Manager(id, phone, name, email,password, user_type);
		
	}
	
	public void viewManagerInfo() { // implement when creating view in UI
		
	
	}
	
	public boolean addNewDoctor(Doctor newDoctor) {
		
		if(clinicManager.addDoctor(newDoctor))
			return true;
		
		return false;
	}
	
	public boolean deleteDoctor(String docID) {
		
		if(clinicManager.removeDoctor(docID))
			return true;
		
		return false;
	}
}