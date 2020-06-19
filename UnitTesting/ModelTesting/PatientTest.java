package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.*;

public class PatientTest {

	@Test
	public void CheckUpdatePatient()
	{
		
		Patient patient = new Patient("123456789",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","");
		int age = 27;
		int height = 166;
		int weight = 160;
		int phone = 0521234567;
		String email = "test@test.com";
		String gender = "male";
		String subscriptions = "test";
		String allergies = "alertest";
		String chronic_diseases = "shahemet";

		patient.updatePatientInfo(phone, age, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
	    Assert.assertTrue(patient.getAge() == age && patient.getAllergies() == allergies && patient.getEmail() == email && patient.getGender() == gender && patient.getHeight() == height && patient.getPhone() == phone && patient.getSubscriptions() == subscriptions && patient.getWeight() == weight && patient.getChronic_diseases() == chronic_diseases);
	}
	
	@Test
	public void CheckAddLabs()
	{
		
		Patient patient = new Patient("123456789",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","");
		
		String type = "test";
		String result = "Dead";
		boolean attentionRequired = true;
		Lab lab = new Lab(type, result, attentionRequired);
		
		Assert.assertTrue(patient.addLab(lab));
	   
	}
	
	@Test
	public void CheckAddMedicalRecord()
	{
		
		Patient patient = new Patient("123456789",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","");
		String doctor = "Moshe Test";
		int numDays = 10;
		int record = 15;
		String purpose = "testing";
		String description = "test description";
		String summary = "summary test";
		String sub = "sub test";
		String diagnose = "dianose test";
		LocalTime sT = LocalTime.now();
		LocalTime eT = LocalTime.now();
		int w = 10;
		int h = 5;
		int hr = 3;
		int t = 6;
		int sysBP = 36;
		int diaBP = 40;
		MedicalRecord med = new MedicalRecord("123456789", doctor, numDays, record, purpose, description, summary, sub, diagnose, sT, eT, w, h, hr, t, sysBP, diaBP);
		Assert.assertTrue(patient.addMedicalRecord(med)); 
	}
}
