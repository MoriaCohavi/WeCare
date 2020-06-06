package Controller;
import Model.*;

public class clinicController {
	Clinic clinic;
	
	public clinicController(String city, long cId, String mId, int phone, String name, String email,String password,String user_type) {
		clinic  = Clinic.getInstance(city, cId, mId, phone, name, email, password, user_type);
	}
	
	public static boolean clinicControllerCheck()
	{
		Clinic clinic = Clinic.deserialize();
		if (clinic == null)
			return false;
		return true;
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
