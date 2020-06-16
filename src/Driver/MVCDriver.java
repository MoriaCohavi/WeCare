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
		
		//serHandlerController handler = new serHandlerController();
		clinicController clinic_controller = new clinicController("", 0, "111111111", 548798888, "Moshe Bar Siman Tov", "moshe@maccabi.org", "admin", "Manager");
		//clinic_controller.deserialize(handler);
		
		authenticationController auth_controller = new authenticationController();
		auth_controller.deserialize();
		
		
		auth_controller.register(clinic_controller.getClinicManager().getID(),clinic_controller.getClinicManager());
		LoginView StartLogin = new LoginView();
		
		if (true)//manager logged in){
		{
			managerController manager_controller = new managerController();
			manager_controller.setClinicManager(clinic_controller.getClinicManager());
			
			
		} 
		
						
		Result result = JUnitCore.runClasses(StatisticalDataTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}


//authenticationController auth_controller = new authenticationController();


/* Before finish, do serialize to manager */
//managerController manager_controller = new managerController();
//manager_controller.deserialize(handler); // Id = 111111111, password = admin
