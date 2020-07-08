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
	public void CheckUpdatePatient() {
		Patient patient = new Patient("000000001",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","", "000000002");
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
	public void CheckAddLabs() {
		Patient patient = new Patient("000000003",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","", "000000004");
		
		String type = "test";
		String result = "Dead";
		boolean attentionRequired = true;
		Lab lab = new Lab(type, result, attentionRequired, patient.getId());
		
		Assert.assertTrue(patient.addLab(lab));
	}
	
	@Test
	public void CheckAddMedicalRecord() {
		Patient patient = new Patient("000000005",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","", "000000006");
		String doctor = "000000005";
		int numDays = 10;
		int record = 15;
		String purpose = "testing";
		String description = "test description";
		String summary = "summary test";
		String sub = "sub test";
		String diagnose = "dianose test";
		int w = 10;
		int h = 5;
		int hr = 3;
		int t = 6;
		int sysBP = 36;
		int diaBP = 40;
		MedicalRecord med = new MedicalRecord("000000005", doctor, numDays, record, purpose, description, summary, sub, diagnose,  w, h, hr, t, sysBP, diaBP);
		Assert.assertTrue(patient.addMedicalRecord(med)); 
	}
	
	@Test
	public void CheckgGetMedicalRecord() {
		Patient patient = new Patient("000000006",26, 0541234567, "moria test", "moria@test.com", 53, 156, "Female", "", "","", "000000007");
		String doctor = "000000007";
		int numDays = 10;
		int record = Patient.getRecordsCounter()+1;
		String purpose = "testing";
		String description = "test description";
		String summary = "summary test";
		String sub = "sub test";
		String diagnose = "dianose test";
		int w = 10;
		int h = 5;
		int hr = 3;
		int t = 6;
		int sysBP = 36;
		int diaBP = 40;
		MedicalRecord med = new MedicalRecord("000000006", doctor, numDays, record, purpose, description, summary, sub, diagnose,  w, h, hr, t, sysBP, diaBP);
		patient.addMedicalRecord(med); 
		
		Assert.assertTrue(patient.getMedicalRecord(med.get_RecordId(), "000000006", "000000007")!=null);
		Assert.assertTrue(patient.getMedicalRecord(med.get_RecordId(), "000000006", "000000008")==null);	
	}
}
