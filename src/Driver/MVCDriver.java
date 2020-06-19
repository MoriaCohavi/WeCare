package Driver;

import View.*;
import Controller.*;
import Model.*;
import ModelTesting.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class MVCDriver {
	
	// Default manager for the application
	public static Manager defaultManager = new Manager("111111111", 548798888, "Moshe Bar Siman Tov", "moshe@maccabi.org", "admin", "Manager");
	
	public static void main(String[] args) {
		/* Init Clinic */
		clinicController clinic_controller = new clinicController("", 0, defaultManager);
		
		/* Init fisrt manager controller */
		managerController manager_controller = new managerController();
		manager_controller.setClinicManager(clinic_controller.getClinicManager());
		
		/* Init first authentication controller */
		authenticationController auth_controller = new authenticationController();
		auth_controller.deserialize();
		
		/* Registe manager to users' list */
		auth_controller.register(defaultManager.getID(),defaultManager);
		
		/* Start - Open login page */
		LoginView StartLogin = new LoginView();
	}
}
