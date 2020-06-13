package Driver;

import View.*;
import Controller.*;
import Model.*;

public class MVCDriver {
	public static void main(String[] args) {
		serHandlerController handler = new serHandlerController();
		//authenticationController auth_controller = new authenticationController();
		clinicController clinic_controller = new clinicController("", 0);
		clinic_controller.deserialize(handler);
		
		/* Before finish, do serialize to manager */
//		managerController manager_controller = new managerController();
//		manager_controller.deserialize(handler); // Id = 111111111, password = admin
		
		managerController manager_controller = new managerController("111111111", 548798888, "Moshe Bar Siman Tov", "moshe@maccabi.org", "admin", "Manager");
		manager_controller.registerManager();
		authenticationController auth_controller = new authenticationController();
		
	}
}
