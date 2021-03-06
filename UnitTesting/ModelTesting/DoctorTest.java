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
	public void CheckAdd() {
		Doctor doctor = new Doctor("000000000", "000000002", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000003", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000000");
		Assert.assertTrue(doctor.add(patient));
		Assert.assertFalse(doctor.add(patient));
		
		doctor.remove("000000003");
	}
	
	@Test
	public void CheckRemove() {
		Doctor doctor1 = new Doctor("000000004", "000000005", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000006", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000004");
		doctor1.add(patient);
		Assert.assertTrue(doctor1.remove(patient.getId()));
		Assert.assertFalse(doctor1.remove(patient.getId()));
		
		doctor1.add(patient);
		Doctor doctor3 = new Doctor("000000007", "000000008", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.remove(patient.getId()));
		
		doctor1.remove("000000006");
	}
	
	@Test
	public void CheckSearch() {
		Doctor doctor = new Doctor("000000009","000000010", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000011", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000009");
		doctor.add(patient);
		Assert.assertTrue(doctor.search(patient.getId()));
		Assert.assertFalse(doctor.search("123456781"));
		
		Doctor doctor3 = new Doctor("000000012", "000000010", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.search("000000011"));
		
		doctor.remove("000000011");
	}
	
	@Test
	public void CheckAddSpecialization() {
		Doctor doctor = new Doctor("000000013", "000000014", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		doctor.addSpecialization("testing");
		Assert.assertTrue(doctor.getDoctorSpecialization().equals("Spetialty and testing"));
	}
	
	@Test
	public void CheckGetItem() {
		Doctor doctor = new Doctor("000000015", "000000016", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000017", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000015");
		doctor.add(patient);
		MedicalRecord Record = new MedicalRecord("000000017", "000000015", 3, patient.getRecordCounter()+1, "purp_testing", "desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		patient.addMedicalRecord(Record);
		Patient patient2 = doctor.getItem("000000017");
		Assert.assertTrue(patient.getAllergies().equals(patient2.getAllergies())&&
							patient.getAge() == patient2.getAge() &&
							patient.getChronic_diseases().equals(patient2.getChronic_diseases()) &&
							patient.getEmail().equals(patient2.getEmail()) &&
							patient.getGender().equals(patient2.getGender()) &&
							patient.getHeight() == patient2.getHeight() &&
							patient.getId().equals(patient2.getId()) &&
							patient.getMedicalRecord(1, "000000017","000000015") == (patient2.getMedicalRecord(1, "000000017","000000015")) &&
							patient.getName().equals(patient2.getName()) &&
							patient.getPhone() == patient2.getPhone() &&
							patient.getRecordCounter() == patient2.getRecordCounter() &&
							patient.getSubscriptions().equals(patient2.getSubscriptions()) &&
							patient.getWeight() == patient2.getWeight()	);	
		
		doctor.remove("000000017");
	}
	
	@Test
	public void CheckUpdatePatient() {
		Doctor doctor = new Doctor("000000018", "000000019", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000020", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000018");
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
		doctor.updatePatientInfo("000000020", phone, age, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
		
		Assert.assertTrue(patient.getAllergies().equals("alertest")&&
				patient.getAge() == 27 && 
				patient.getChronic_diseases().equals("shahemet") &&
				patient.getEmail().equals("test@test.com") && 
				patient.getGender().equals("male") &&
				patient.getHeight() == 166 && 
				patient.getId().equals("000000020") &&
				patient.getPhone() == phone && 	
				patient.getSubscriptions().equals("test") &&
				patient.getWeight() == 160	);	
	
		doctor.remove("000000020");
	}
	
	@Test
	public void CheckCreateMedicalRecord() {
		Doctor doctor = new Doctor("000000021", "000000022", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000023", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000021");
		doctor.add(patient);
		
		MedicalRecord Record = new MedicalRecord("000000023", "000000021", 3, patient.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		doctor.createMedicalRecord(patient.getId(), Record);
		
		MedicalRecord checkRecord = patient.getMedicalRecord(Record.get_RecordId(), "000000023", "000000021");
		Assert.assertTrue(checkRecord.get_DiagnoseDiscription().equals("diag_test") &&
							checkRecord.get_DaysOfIllnessApproval() == 3 &&
							checkRecord.get_DoctorId() == "000000021" &&
							checkRecord.get_pateintIndices().getDiastolicBP() == 100 &&
							checkRecord.get_pateintIndices().getHeartRate() == 90 &&
							checkRecord.get_pateintIndices().getHeight() == 180 &&
							checkRecord.get_pateintIndices().getSystolicBP() == 60 &&
							checkRecord.get_pateintIndices().getTemperature() == 37 &&
							checkRecord.get_pateintIndices().getWeight() == 60 &&
							checkRecord.get_RecordId() == Record.get_RecordId() &&
							checkRecord.get_subscriptions().equals("sub_test") &&
							checkRecord.get_VisitDescription().equals("desc_testing") &&
							checkRecord.get_VisitPurpose().equals("purp_testing"));
		
		Doctor doctor3 = new Doctor("000000024", "000000025", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Assert.assertFalse(doctor3.createMedicalRecord("000000023", Record));
		
		doctor.remove("000000023");
	}
	
	@Test
	public void CheckGetFirstRecord() {
		Doctor doctor = new Doctor("000000010","000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000010");
		doctor.add(patient);
		
		MedicalRecord Record = new MedicalRecord("000000002", "000000010", 3, patient.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub, test", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("000000002", "000000010", 3, patient.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		
		doctor.createMedicalRecord("000000002", Record);
		StatisitcalData check = new StatisitcalData("000000010");
		check.setTotalDailylabs(0);
		check.setTotalDailyPatients(1);
		check.setTotalDailySubs(2);
		
		StatisitcalData returned = doctor.getFirstRecord();
		Assert.assertTrue(check.getTotalDailylabs() == returned.getTotalDailylabs() &&
							check.getTotalDailyPatients() == returned.getTotalDailyPatients() &&
							check.getTotalDailySubs() == returned.getTotalDailySubs()); 
		doctor.createMedicalRecord("000000002", Record2);
		
		Assert.assertFalse(check.getTotalDailylabs() != returned.getTotalDailylabs() &&
				check.getTotalDailyPatients() != returned.getTotalDailyPatients() &&
				check.getTotalDailySubs() != returned.getTotalDailySubs());
		
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
	
	@Test
	public void CheckGetDailyAvgRecords() {
		Doctor doctor = new Doctor("000000011","000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Patient patient = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000011");
		doctor.add(patient);
		
		MedicalRecord Record = new MedicalRecord("000000002", "000000011", 3, patient.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub, test", "diag_test", 60, 180, 90, 37, 60, 100);
		
		doctor.createMedicalRecord("000000002", Record);
		StatisitcalData check = new StatisitcalData("000000011");
		check.setTotalDailylabs(0);
		check.setTotalDailyPatients(1);
		check.setTotalDailySubs(2);
		
		StatisitcalData returned = doctor.getDailyAvgRecords(LocalDate.now(), "000000011");
		Assert.assertTrue(check.getTotalDailylabs() == returned.getTotalDailylabs() &&
							check.getTotalDailyPatients() == returned.getTotalDailyPatients() &&
							check.getTotalDailySubs() == returned.getTotalDailySubs()); 
		
		Assert.assertFalse(check.getTotalDailylabs() != returned.getTotalDailylabs() &&
				check.getTotalDailyPatients() != returned.getTotalDailyPatients() &&
				check.getTotalDailySubs() != returned.getTotalDailySubs());
		
	}
}
