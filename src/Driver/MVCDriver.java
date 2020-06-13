package Driver;

import View.*;
import Controller.*;
import Model.*;

public class MVCDriver {
	
	public static void main(String[] args) {
		clinicController clinic_controller = new clinicController("", 0, "111111111", 548798888, "Moshe Bar Siman Tov", "moshe@maccabi.org", "admin", "Manager");
		//clinic_controller.deserialize(handler);
		
		authenticationController auth_controller = new authenticationController();
		auth_controller.deserialize();
		
		
		auth_controller.register(clinic_controller.getClinicManager().getID(),clinic_controller.getClinicManager());
		auth_controller.openLoginForm();
		
		if (true)//manager logged in){
		{
			managerController manager_controller = new managerController();
			manager_controller.setClinicManager(clinic_controller.getClinicManager());
			
			
		}
		
				
		
		
		
		
		
	}
}


//authenticationController auth_controller = new authenticationController();


/* Before finish, do serialize to manager */
//managerController manager_controller = new managerController();
//manager_controller.deserialize(handler); // Id = 111111111, password = admin
