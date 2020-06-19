package Controller;

import java.time.*;
import java.util.HashMap;

import Driver.MVCDriver;
import Model.*;


public class managerController {
	public static String serPathDoctors = "src\\Model\\files\\doctors.ser";
	public static String serPathStatsFlag = "src\\Model\\files\\statsFlags.ser";
	public static String serPathStats = "src\\Model\\files\\stats.ser";
	private static Manager clinicManager;
	private final String typeNeed = "Manager";
	
	public managerController(){
		clinicManager = MVCDriver.defaultManager;
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
	
	public boolean addNewDoctor(String doctorId, String managerId, long phone, String name, String email, String special, String password,String user_type, long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed))
		{
			Doctor newDoctor = new Doctor(doctorId, managerId, phone, name, email, special, password, user_type);
			if (authenticationController.register(newDoctor.getId(), newDoctor) != -1)
			{
				clinicManager.add(newDoctor);
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
	
	public HashMap<String, Doctor> getDoctorList(long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed)) {
			return clinicManager.getDoctors();
		}
		return null;
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

//	private static LocalDateTime statsFlag;
//private static StatisitcalData stats;
	public void serialize() {
		HashMap<String, Doctor> tempDoctors = clinicManager.getDoctors();
		LocalDateTime tempStatsFlags = clinicManager.getStatsFlag();
		StatisitcalData tempStats = clinicManager.getStats();
		serHandlerController.serialize(tempDoctors, serPathDoctors);
		serHandlerController.serialize(tempStatsFlags, serPathStatsFlag);
		serHandlerController.serialize(tempStats, serPathStats);
	}
	
	public boolean deserialize() {
		HashMap<String, Doctor> tempDoctors = (HashMap<String, Doctor>)serHandlerController.deserialize(serPathDoctors);
		LocalDateTime tempStatsFlags = (LocalDateTime)serHandlerController.deserialize(serPathStatsFlag);
		StatisitcalData tempStats = (StatisitcalData)serHandlerController.deserialize(serPathStats);
		if (tempDoctors == null || tempStats == null)
			return false;
		clinicManager.setStats(tempStats);
		clinicManager.setStatsFlag(tempStatsFlags);
		clinicManager.setDoctors(tempDoctors);
		return true;
	}
	
	public boolean updateDoctor(long managerToken, String id, String email, long phone)
	{
		if (Authentication.validateUser(managerToken, typeNeed))
		{
			if(clinicManager.updateDoctorInfo(id,email , phone) && Authentication.updateDoctorInfo(id, email, phone))
			return true;
		}
		return false;
	}
}