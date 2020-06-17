package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.*;

public class ManagerTest{
	
	@Test
	public void CheckAdd()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("123456789", 5200000, "Name", "Email", "password","Manager");
		Assert.assertTrue(manager.add(doctor));
		Assert.assertFalse(manager.add(doctor));
	}
	
	@Test
	public void CheckRemove()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("123456789", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Assert.assertTrue(manager.remove(doctor.getDoctorID()));
		Assert.assertFalse(manager.remove(doctor.getDoctorID()));
	}
	
//	@Test
//	public void CheckCalcStat()
//	{
//		Doctor doctor1 = new Doctor("123456789", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
//		Doctor doctor2 = new Doctor("123456781", 5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
//		Doctor doctor3 = new Doctor("123456782", 5200000, "Name3", "Email3", "Spetialty3","password", "Doctor");
//		Doctor doctor4 = new Doctor("123456783", 5200000, "Name4", "Email4", "Spetialty4","password", "Doctor");
//		Manager manager = new Manager("123456788", 5200000, "Name", "Email", "password","Manager");
//		Assert.assertTrue(manager.getAvgDailylabs() == 0 && manager.getAvgDailyPatients() == 0 && manager.getAvgDailySubs() == 0 && manager.getAvgVisitTime() == 0);
//		manager.add(doctor1);
//		manager.add(doctor2);
//		manager.add(doctor3);
//		manager.add(doctor4);
//		//Assert.assertFalse(manager.remove(doctor.getDoctorID()));
//	}
	
}
