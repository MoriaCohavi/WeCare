package Controller;
import Model.*;

public class clinicController {
	public static String serPath = "src\\Model\\files\\clinic.ser";
	private static Clinic clinic;
	
	public clinicController(String city, long cId,String mId, long phone, String mName, String email, String password, String user_type) {
		clinic  = Clinic.getInstance(city, cId, mId, phone, mName, email, password, user_type);
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
