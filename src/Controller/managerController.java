package Controller;

import java.time.*;
import Model.*;

public class managerController {
	public static String serPath = "src\\Model\\files\\manager.ser";
	private static Manager clinicManager;
	String typeNeed = "Manager";
	
	public managerController(){
		
	}
	
	public Manager getDetails(long token) {
		
		if(Authentication.validateUser(token, typeNeed))
			return clinicManager;
		
			return null;
	}
	
	public managerController(String id, int phone, String name, String email, String password,String user_type) { //needs to include manger view object
		
		clinicManager = new Manager(id, phone, name, email,password, user_type);
	}
		
	public void setClinicManager (Manager clinicM) {
		
		clinicManager = clinicM;
	}
	
	public void viewManagerInfo() { // implement when creating view in UI
		
	
	}
	
	public Doctor getDoctor(long token, String doctorId) {
		
		if(Authentication.validateUser(token, typeNeed))
			return clinicManager.getItem(doctorId);
		return null;
	}
	
	public boolean addNewDoctor(long token, String id, long phone, String name, String email, String special, String password,String user_type, long managerToken) {
		if(Authentication.validateUser(token, typeNeed))
		{
			Doctor newDoctor = new Doctor(id, phone, name, email, special, password, user_type);
			if(clinicManager.add(newDoctor))
			{
				authenticationController.register(newDoctor.getId(), newDoctor);
				return true;
			
			}
		}
		return false;
	}
	
	
//	public boolean registerManager() {
//		
//		if(authenticationController.register(this.clinicManager.getID(), this.clinicManager) > 0)
//			return true;
//		return false;
//	}
	
	public boolean deleteDoctor(long token, String docID) {
		if(Authentication.validateUser(token, typeNeed))
		{
			if(clinicManager.remove(docID))
				return true;
		}
		return false;
	}
	
	public void updateStats(long token) {
		if(Authentication.validateUser(token, typeNeed)) {
			if (clinicManager.getStatsFlag() == null || clinicManager.getStatsFlag().isBefore(LocalDateTime.now().minusHours(6))) 
			{
			clinicManager.setStatsFlag(LocalDateTime.now());
			clinicManager.calcStats();
			}		
		}
	}
	
	public Manager getManager() {
		
		return clinicManager;
	}
	
	public StatisitcalData getStats(long token) {
		if(Authentication.validateUser(token, typeNeed))
			return clinicManager.getStats();
		
		return null;
	}
	
	public void serialize() {
		
		serHandlerController.serialize(clinicManager, serPath);
	}
	
	public void deserialize() {
		
		clinicManager = (Manager)serHandlerController.deserialize(serPath);
	}
}