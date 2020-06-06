package Controller;
import Model.*;

public class clinicController {
	Clinic clinic;
	
	public clinicController() {
		clinic = new Clinic();
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
