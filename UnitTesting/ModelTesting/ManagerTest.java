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
	
	@Test
	public void CheckUpdateDoctorInfo()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("123456789", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Authentication.signUp("123456789", doctor);
		Assert.assertTrue(manager.updateDoctorInfo(doctor.getId(), "Email test", 0541234567));
		Assert.assertFalse(manager.updateDoctorInfo("000000000", "Email test", 0541234567));
	}
}
