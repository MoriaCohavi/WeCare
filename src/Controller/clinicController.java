package Controller;
import Model.*;

public class clinicController {
	public static String serPath = "src\\Model\\files\\clinic.ser";
	private static Clinic clinic;
	
	public clinicController(String city, long cId, Manager defaultManager ) {
		clinic  = Clinic.getInstance(city, cId, defaultManager.getId(), defaultManager.getPhone(), defaultManager.getName(), defaultManager.getEmail(), defaultManager.getPassword(), defaultManager.getUser_type());
	}
	
	public void serialize()
	{
		serHandlerController.serialize(clinic, serPath);
	}
	
	public void deserialize()
	{
		clinic = (Clinic)serHandlerController.deserialize(serPath);
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public String getClinicCity()
	{
		return clinic.getCity();
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public Manager getClinicManager() {
		return clinic.getManager();
	}
}
