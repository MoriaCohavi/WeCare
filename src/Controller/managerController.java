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
	
	public managerController()
	{
		
	}
	
	public managerController(String id, int phone, String name, String email, String password,String user_type) { //needs to include manger view object
		
		clinicManager = new Manager(id, phone, name, email,password, user_type);
		statsFlag = null;
		
	}
	
	public void viewManagerInfo() { // implement when creating view in UI
		
	
	}
	
	public boolean addNewDoctor(String id, int phone, String name, String email, String special, String password,String user_type) 
	{
		
		Doctor newDoctor = new Doctor(id, phone, name, email, special, password, user_type);
		if(clinicManager.add(newDoctor))
			return true;
		
		return false;
	}
	
//	public boolean registerManager() {
//		
//		if(authenticationController.register(this.clinicManager.getID(), this.clinicManager) > 0)
//			return true;
//		return false;
//	}
	
	public boolean deleteDoctor(String docID) {
		
		if(clinicManager.remove(docID))
			return true;
		
		return false;
	}
	
	
	public void updateStats() {
		if (statsFlag == null || statsFlag.isBefore(LocalDateTime.now().minusHours(6))) {
			statsFlag = LocalDateTime.now();
			clinicManager.calcStats();
		}
			
	}
	
	public Manager getManager()
	{
		return clinicManager;
	}
	
	public void serialize(serHandlerController handler)
	{
		handler.serialize(clinicManager, serPath);
	}
	
	public void deserialize(serHandlerController handler)
	{
		clinicManager = (Manager)handler.deserialize(serPath);
	}
}