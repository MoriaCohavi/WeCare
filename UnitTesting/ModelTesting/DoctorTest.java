package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.*;

public class DoctorTest {
	
	@Test
	public void CheckAdd()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("123456788", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		Assert.assertTrue(doctor.add(patient));
		Assert.assertFalse(doctor.add(patient));
	}
	
	@Test
	public void CheckRemove()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("123456788", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		doctor.add(patient);
		Assert.assertTrue(doctor.remove(patient.getId()));
		Assert.assertFalse(doctor.remove(patient.getId()));
	}
	
	@Test
	public void CheckSearch()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("123456788", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		doctor.add(patient);
		Assert.assertTrue(doctor.search(patient.getId()));
		Assert.assertFalse(doctor.search("123456781"));
	}
	
	@Test
	public void CheckUpdatePatient()
	{
//		Patient patient = new Patient("123456789",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","");
//		Doctor doctor = new Doctor("123456789", 5200000, "Name", "Email", "Spetialty",
//									"password", "Doctor");
//		String id = "123456789";
//		int age = 27;
//		int height = 166;
//		int weight = 160;
//		int phone = 0521234567;
//		String email = "test@test.com";
//		String gender = "male";
//		String subscriptions = "test";
//		String allergies = "alertest";
//		String chronic_diseases = "shahemet";
//
//		doctor.updatePatientInfo(id, phone, age, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
//	    Assert.assertTrue(doctor.getAge() == age && doctor.getAllergies() == allergies && 
//	    		doctor.getEmail() == email && doctor.getGender() == gender && 
//	    		doctor.getHeight() == height && doctor.getPhone() == phone && 
//	    		doctor.getSubscriptions() == subscriptions && doctor.getWeight() == weight && 
//	    		doctor.getChronic_diseases() == chronic_diseases);
	}
	
	@Test
	public void CheckAddMedicalRecord()
	{
		Doctor doctor = new Doctor("123456789", 5200000, "test", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("123456788", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		MedicalRecord med - new MedicalRecord("123456789", 5, 1, "test", "test2", "summary test", "sub test", "diagnose", "10:10:10", "11:11:11", 3, 2, 1, 4, 43, 44);
		doctor.add(patient);
		Assert.assertTrue(doctor.remove(patient.getId()));
		Assert.assertFalse(doctor.remove(patient.getId()));
	}

}
