package Controller;

import java.time.*;
import Model.*;

public class managerController {
	public static String serPath = "src\\Model\\files\\manager.ser";
	private static Manager clinicManager;
	private final String typeNeed = "Manager";
	
	public managerController(){
		deserialize();
	}
	
	public Manager getDetails(long managerToken) {
		
		if(Authentication.validateUser(managerToken, typeNeed))
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
	
	public Doctor getDoctor(long managerToken, String doctorId) {
		
		if(Authentication.validateUser(managerToken, typeNeed))
			return clinicManager.getItem(doctorId);
		return null;
	}
	
	public boolean addNewDoctor(String id, long phone, String name, String email, String special, String password,String user_type, long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed))
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
	
	public boolean deleteDoctor(long managerToken, String docID) {
		if(Authentication.validateUser(managerToken, typeNeed))
		{
			if(clinicManager.remove(docID))
				return true;
		}
		return false;
	}
	
	public void updateStats(long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed)) {
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
	
	public StatisitcalData getStats(long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed))
			return clinicManager.getStats();
		
		return null;
	}
	
	public Doctor getDoctorItem(String id)
	{
		return clinicManager.getItem(id);
	}
	
	public void serialize() {
		
		serHandlerController.serialize(clinicManager, serPath);
	}
	
	public void deserialize() {
		
		clinicManager = (Manager)serHandlerController.deserialize(serPath);
	}
	
	public boolean updateDoctor(long managerToken, String id, String email, long phone)
	{
		if (Authentication.validateUser(phone, typeNeed))
		{
			if(clinicManager.updateDoctorInfo(id,email , phone) && Authentication.updateDoctorInfo(id, email, phone))
			return true;
		}
		return false;
	}
}