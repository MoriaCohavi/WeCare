package Controller;


import java.time.*;

import Model.*;

public class managerController {
	public static String serPath = "src\\Model\\files\\manager.ser";
	private Manager clinicManager;
	
	
	public managerController()
	{
		
	}
	
	public managerController(String id, int phone, String name, String email, String password,String user_type) { //needs to include manger view object
		
		clinicManager = new Manager(id, phone, name, email,password, user_type);
		
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
		if (clinicManager.getStatsFlag() == null || clinicManager.getStatsFlag().isBefore(LocalDateTime.now().minusHours(6))) {
			clinicManager.setStatsFlag(LocalDateTime.now());
			clinicManager.calcStats();
		}
			
	}
	
	public Manager getManager()
	{
		return clinicManager;
	}
	
	public StatisitcalData getStats() {
		
		return clinicManager.getStats();
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