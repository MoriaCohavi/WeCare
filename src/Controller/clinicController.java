package Controller;
import Model.*;

public class clinicController {
	public static String serPath = "src\\Model\\files\\clinic.ser";
	Clinic clinic;
	
	public clinicController(String city, long cId,String mId, long phone, String mName, String email, String password, String user_type) {
		clinic  = Clinic.getInstance(city, cId, mId, phone, mName, email, password, user_type);
	}
	
	public void serialize(serHandlerController handler)
	{
		handler.serialize(clinic, serPath);
	}
	
	public void deserialize(serHandlerController handler)
	{
		clinic = (Clinic)handler.deserialize(serPath);
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public Manager getClinicManager() {
		return clinic.getManager();
	}
}
