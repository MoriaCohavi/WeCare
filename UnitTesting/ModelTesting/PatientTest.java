package ModelTesting;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.MedicalRecord;
import Model.Patient;
import Model.Lab;

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
		//MedicalRecord med = new MedicalRecord(doctor, numDays, record, purpose, description, summary, sub, diagnose, sT, eT, w, h, hr, t, sysBP, diaBP)
		String type = "test";
		String result = "Dead";
		boolean attentionRequired = true;
		Lab lab = new Lab(type, result, attentionRequired);
		
		Assert.assertTrue(patient.addLab(lab));
	   
	}
}
