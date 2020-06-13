package Controller;


import java.time.LocalDate;
import java.time.LocalDateTime;

import Model.Clinic;
import Model.Doctor;
import Model.Manager;

public class managerController {
	public static String serPath = "src\\Model\\files\\manager.ser";
	private Manager clinicManager;
	private LocalDateTime statsFlag;
	
	
	public managerController(String id, int phone, String name, String email, String password,String user_type) { //needs to include manger view object
		
		clinicManager = new Manager(id, phone, name, email,password, user_type);
		statsFlag = null;
		
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
	
	
	public void updateStats() {
		if (statsFlag == null || statsFlag.isBefore(LocalDateTime.now().minusHours(6))) {
			statsFlag = LocalDateTime.now();
			clinicManager.calcStats();
		}
			
	}
	
	
	public void serialize(serHandlerController handler)
	{
		handler.WriteObjectToFile(clinicManager, serPath);
	}
	
	public void deserialize(serHandlerController handler)
	{
		clinicManager = (Manager)handler.ReadObjectFromFile(serPath);
	}
}