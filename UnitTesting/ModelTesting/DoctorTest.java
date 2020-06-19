package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import Model.*;
public class DoctorTest {
	
	@Test
	public void CheckAdd()
	{
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000003", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		Assert.assertTrue(doctor.add(patient));
		Assert.assertFalse(doctor.add(patient));
		
		doctor.remove("000000002");
	}
	
	@Test
	public void CheckRemove()
	{
		Doctor doctor1 = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor1.add(patient);
		Assert.assertTrue(doctor1.remove(patient.getId()));
		Assert.assertFalse(doctor1.remove(patient.getId()));
		
		doctor1.add(patient);
		Doctor doctor3 = new Doctor("000000003", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.remove(patient.getId()));
		
		doctor1.remove("000000002");
	}
	
	@Test
	public void CheckSearch()
	{
		Doctor doctor = new Doctor("000000001","000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor.add(patient);
		Assert.assertTrue(doctor.search(patient.getId()));
		Assert.assertFalse(doctor.search("123456781"));
		
		Doctor doctor3 = new Doctor("000000003", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.search("000000002"));
		
		doctor.remove("000000002");
	}
	
	@Test
	public void CheckAddSpecialization()
	{
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		doctor.addSpecialization("testing");
		Assert.assertTrue(doctor.getDoctorSpecialization().equals("Spetialty and testing"));
	}
	
	@Test
	public void CheckGetItem() {
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor.add(patient);
		MedicalRecord Record = new MedicalRecord("000000002", "000000001", 3, patient.getRecordCounter()+1, "purp_testing", "desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		patient.addMedicalRecord(Record);
		Patient patient2 = doctor.getItem("000000002");
		Assert.assertTrue(patient.getAllergies().equals(patient2.getAllergies())&&
							patient.getAge() == patient2.getAge() &&
							patient.getChronic_diseases().equals(patient2.getChronic_diseases()) &&
							patient.getEmail().equals(patient2.getEmail()) &&
							patient.getGender().equals(patient2.getGender()) &&
							patient.getHeight() == patient2.getHeight() &&
							patient.getId().equals(patient2.getId()) &&
							patient.getMedicalRecord(1, "000000002") == (patient2.getMedicalRecord(1, "000000002")) &&
							patient.getName().equals(patient2.getName()) &&
							patient.getPhone() == patient2.getPhone() &&
							patient.getRecordCounter() == patient2.getRecordCounter() &&
							patient.getSubscriptions().equals(patient2.getSubscriptions()) &&
							patient.getWeight() == patient2.getWeight()	);	
		
		doctor.remove("000000002");
	}
	
	
	@Test
	public void CheckUpdatePatient()
	{
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor.add(patient);
		
		int age = 27;
		int height = 166;
		int weight = 160;
		int phone = 0521234567;
		String email = "test@test.com";
		String gender = "male";
		String subscriptions = "test";
		String allergies = "alertest";
		String chronic_diseases = "shahemet";
		doctor.updatePatientInfo("000000002", phone, age, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
		
		Assert.assertTrue(patient.getAllergies().equals("alertest")&&
				patient.getAge() == 27 && 
				patient.getChronic_diseases().equals("shahemet") &&
				patient.getEmail().equals("test@test.com") && 
				patient.getGender().equals("male") &&
				patient.getHeight() == 166 && 
				patient.getId().equals("000000002") &&
				patient.getPhone() == phone && 	
				patient.getSubscriptions().equals("test") &&
				patient.getWeight() == 160	);	
	
		doctor.remove("000000002");
	}
	
	
	
	@Test
	public void CheckCreateMedicalRecord() {
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor.add(patient);
		
		MedicalRecord Record = new MedicalRecord("000000002", "000000001", 3, patient.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		doctor.createMedicalRecord(patient.getId(), Record);
		
		MedicalRecord checkRecord = patient.getMedicalRecord(1, "000000002");
		Assert.assertTrue(checkRecord.get_DiagnoseDiscription().equals("diag_test") &&
							checkRecord.get_DaysOfIllnessApproval() == 3 &&
							checkRecord.get_DoctorId() == "000000001" &&
							checkRecord.get_pateintIndices().getDiastolicBP() == 100 &&
							checkRecord.get_pateintIndices().getHeartRate() == 90 &&
							checkRecord.get_pateintIndices().getHeight() == 180 &&
							checkRecord.get_pateintIndices().getSystolicBP() == 60 &&
							checkRecord.get_pateintIndices().getTemperature() == 37 &&
							checkRecord.get_pateintIndices().getWeight() == 60 &&
							checkRecord.get_RecordId() == 1 &&
							checkRecord.get_subscriptions().equals("sub_test") &&
							checkRecord.get_VisitDescription().equals("desc_testing") &&
							checkRecord.get_VisitPurpose().equals("purp_testing"));
		
		Doctor doctor3 = new Doctor("000000003", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.createMedicalRecord("000000002", Record));
		
		doctor.remove("000000002");
	}
	
	@Test
	public void CheckGetFirstRecord() {
		Doctor doctor = new Doctor("000000001","000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor.add(patient);
		
		MedicalRecord Record = new MedicalRecord("000000002", "000000001", 3, patient.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		doctor.createMedicalRecord("000000002", Record);
		
		LocalDate checkDate = doctor.getFirstRecord();
		Assert.assertTrue(checkDate.equals(Record.get_Date()));
		
		doctor.remove("000000002");
	}
	
	@Test
	public void CheckAddLabToPatient() {
		Doctor doctor = new Doctor("000000001","000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		doctor.add(patient);
		
				
		Assert.assertTrue(doctor.addLabToPatient("000000002", "Blood Labs"));
		Assert.assertTrue(doctor.addLabToPatient("000000002", "Urin Labs"));
		Assert.assertTrue(doctor.addLabToPatient("000000002", "Ultrasound"));
		
		Doctor doctor3 = new Doctor("000000003", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.addLabToPatient("000000002", "Ultrasound"));
		
		doctor.remove("000000002");
	}
	
	@Test
	public void checkUpdateInfo() {
		
		Doctor doctor = new Doctor("000000001","000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		
		doctor.add(patient);
		doctor.updatePatientInfo("000000002", "Test@test", 23, "allergies", "chronic_diseases", "subscriptions");
		
		Assert.assertTrue(doctor.getItem("000000002").getEmail().equals("Test@test") &&
							doctor.getItem("000000002").getPhone() == 23 &&
							doctor.getItem("000000002").getAllergies().equals("allergies") &&
							doctor.getItem("000000002").getChronic_diseases().equals("chronic_diseases") &&
							doctor.getItem("000000002").getSubscriptions().equals("subscriptions"));
		
		Doctor doctor3 = new Doctor("000000003", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		
		Assert.assertFalse(doctor3.updatePatientInfo("000000002", "Test@test", 23, "allergies", "chronic_diseases", "subscriptions"));
		
		
		
	}


}
