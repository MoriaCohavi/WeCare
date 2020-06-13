package Controller;


import java.time.*;
import Model.*;
import View.*;

public class managerController {
	public static String serPath = "src\\Model\\files\\manager.ser";
	private static Manager clinicManager;
	
	
	public managerController()
	{
		
	}
	
	public Manager getDetails() {
		return this.clinicManager;
	}
	
	public managerController(String id, int phone, String name, String email, String password,String user_type) { //needs to include manger view object
		
		clinicManager = new Manager(id, phone, name, email,password, user_type);
		
	public void setClinicManager (Manager clinicM) {
		this.clinicManager = clinicM;
	}
	
	public void viewManagerInfo() { // implement when creating view in UI
		
	
	}
	
	public boolean addNewDoctor(String id, long phone, String name, String email, String special, String password,String user_type, long managerToken) 
	{
		
		Doctor newDoctor = new Doctor(id, phone, name, email, special, password, user_type);
		if(clinicManager.add(newDoctor))
		{
			authenticationController.register(newDoctor.getId(), newDoctor);
			ManagerPanelView panelView = new ManagerPanelView(managerToken);
			return true;
			
		}
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
		StatisticalReportView statisticalView = new StatisticalReportView();
			
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