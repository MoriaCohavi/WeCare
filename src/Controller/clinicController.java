package Controller;
import Model.*;

public class clinicController {
	Clinic clinic;
	
	public clinicController() {
		clinic  = Clinic.getInstance();
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
