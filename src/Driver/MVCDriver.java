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
		managerController manager_controller = new managerController();
		manager_controller.deserialize(handler);
		
		authenticationController auth_controller = new authenticationController();
	}
}

