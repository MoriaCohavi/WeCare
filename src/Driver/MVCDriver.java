package Driver;

import View.*;
import Controller.*;
import Model.*;

public class MVCDriver {
	public static void main(String[] args) {
		authenticationController auth_cont = new authenticationController();
		clinicController clinic_cont;
		if (clinicController.clinicControllerCheck())
			clinic_cont = new clinicController();
		
		
		
		
		
		LoginView frm_login = new LoginView();
	}
}

