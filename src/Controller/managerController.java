package Controller;

import java.time.*;
import java.util.HashMap;

import Driver.MVCDriver;
import Model.*;


public class managerController {
	public static String serPathDoctors = "src\\Model\\files\\doctors.ser";
	public static String serPathStatsFlag = "src\\Model\\files\\statsFlags.ser";
	public static String serPathDaillyStats = "src\\Model\\files\\dailystats.ser";
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
		
	public Doctor getDoctor(long managerToken, String doctorId) {
		
		if(Authentication.validateUser(managerToken, typeNeed))
			return clinicManager.getItem(doctorId);
		return null;
	}
	
	public boolean addNewDoctor(String doctorId, String managerId, long phone, String name, String email, String special, String password,String user_type, long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed))
		{
			Doctor newDoc = new Doctor(doctorId, managerId, phone, name, email, special, password, user_type);
			if (authenticationController.register(newDoc.getId(), newDoc) != -1)
			{
				clinicManager.add(newDoc);
				return true;
			
			}
		}
		return false;
	}
	
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
			clinicManager.calcDailyStats();
		}		
			}		
		}
	
	public Manager getManager() {
		
		return clinicManager;
	}
	
	public HashMap<String, Doctor> getDoctorList(long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed)) {
			return Manager.getDoctors();
		}
		return null;
	}
	
	
	public StatisitcalData getDailyStats(long managerToken) {
		if(Authentication.validateUser(managerToken, typeNeed))
			return clinicManager.getStatsDataDaily(LocalDate.now());
		
		return null;
	}
	
	public Doctor getDoctorItem(String id)
	{
		return clinicManager.getItem(id);
	}

	public void serialize() {
		HashMap<String, Doctor> tempDoctors = Manager.getDoctors();
		LocalDateTime tempStatsFlags = clinicManager.getStatsFlag();
		HashMap <LocalDate, StatisitcalData> tempDailyStats = clinicManager.getStatsDataDaily();
		serHandlerController.serialize(tempDoctors, serPathDoctors);
		serHandlerController.serialize(tempStatsFlags, serPathStatsFlag);
		serHandlerController.serialize(tempDailyStats, serPathDaillyStats);
	}
	
	public boolean deserialize() {
		HashMap<String, Doctor> tempDoctors = (HashMap<String, Doctor>)serHandlerController.deserialize(serPathDoctors);
		LocalDateTime tempStatsFlags = (LocalDateTime)serHandlerController.deserialize(serPathStatsFlag);
		HashMap <LocalDate, StatisitcalData> tempDailyStats = (HashMap <LocalDate, StatisitcalData>)serHandlerController.deserialize(serPathDaillyStats);
		if (tempDoctors == null || tempDailyStats == null)
			return false;
		clinicManager.setStatsDataDaily(tempDailyStats);
		
		clinicManager.setStatsFlag(tempStatsFlags);
		clinicManager.setDoctors(tempDoctors);
		return true;
	}
	
	public boolean deserializeStats()
	{
		if (doctorController.deserializeStatsList())
			return true;
		return false;
		
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