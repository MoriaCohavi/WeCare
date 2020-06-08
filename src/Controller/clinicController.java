package Controller;
import Model.*;

public class clinicController {
	public static String serPath = "src\\Model\\files\\clinic.ser";
	Clinic clinic;
	
	public clinicController(String city, long cId) {
		clinic  = Clinic.getInstance(city, cId);
	}
	
	public void serialize(serHandlerController handler)
	{
		handler.WriteObjectToFile(clinic, serPath);
	}
	
	public void deserialize(serHandlerController handler)
	{
		clinic = (Clinic)handler.ReadObjectFromFile(serPath);
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
