package Driver;

import View.*;
import Controller.*;
import Model.*;
import ModelTesting.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MVCDriver {
	public static void main(String[] args) {
		/*serHandlerController handler = new serHandlerController();
		//authenticationController auth_controller = new authenticationController();
		clinicController clinic_controller = new clinicController("", 0);
		clinic_controller.deserialize(handler);
		managerController manager_controller = new managerController();
		manager_controller.deserialize(handler); // Id = 111111111, password = admin
		manager_controller.registerManager();
		
		authenticationController auth_controller = new authenticationController(); */
		
		Result result = JUnitCore.runClasses(AuthenticationTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}

