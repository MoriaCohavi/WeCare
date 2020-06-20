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

public class ManagerTest{
	
	@Test
	public void CheckAdd()	{
		Doctor doctor = new Doctor("000000001", "000000002", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("000000002", 5200000, "Name", "Email", "password","Manager");
		Assert.assertTrue(manager.add(doctor));
		Assert.assertFalse(manager.add(doctor));
		manager.remove("000000001");
		
	}
	
	@Test
	public void CheckRemove()
	{
		Doctor doctor = new Doctor("000000003", "000000004", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("000000004", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Assert.assertTrue(manager.remove(doctor.getDoctorID()));
		Assert.assertFalse(manager.remove(doctor.getDoctorID()));
		
		Manager manager1 = new Manager("000000005", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Assert.assertFalse(manager1.remove(doctor.getDoctorID()));
		
		manager.remove("000000003");
	}
	
	@Test
	public void CheckCalcDailyStats() {
		
		Manager manager1 = new Manager("000000006", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("000000007","000000006", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("000000008","000000006", 5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
				
		Patient patient1 = new Patient("000000009", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000007");
		Patient patient2 = new Patient("000000010", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000007");
		Patient patient3 = new Patient("000000011", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000008");
		Patient patient4 = new Patient("000000012", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000008");
		
		MedicalRecord Record1 = new MedicalRecord("000000009", "000000007", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("000000009", "000000007", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record3 = new MedicalRecord("000000010", "000000007", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 75, 190, 90, 37, 60, 100);
		MedicalRecord Record4 = new MedicalRecord("000000010", "000000007", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 75, 190, 90, 37, 60, 100);
		MedicalRecord Record5 = new MedicalRecord("000000011", "000000008", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 90, 180, 90, 37, 60, 100);
		MedicalRecord Record6 = new MedicalRecord("000000011", "000000008", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 55, 165, 90, 37, 60, 100);
		MedicalRecord Record7 = new MedicalRecord("000000012", "000000008", 3, patient4.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 55, 165, 90, 37, 60, 100);
		
		manager1.calcDailyStats();
		Assert.assertTrue(manager1.getAvgDailylabs(LocalDate.now())== 0 &&
				manager1.getAvgDailyPatients(LocalDate.now()) == 0 &&
						manager1.getAvgDailySubs(LocalDate.now()) == 0);
		
		Assert.assertFalse(manager1.getAvgDailylabs(LocalDate.now()) != 0 ||
				manager1.getAvgDailyPatients(LocalDate.now()) != 0 ||
						manager1.getAvgDailySubs(LocalDate.now()) != 0);
		
		manager1.add(doctor1);
		manager1.add(doctor2);
		
		manager1.calcDailyStats();
		Assert.assertTrue(manager1.getAvgDailylabs(LocalDate.now())== 0 &&
				manager1.getAvgDailyPatients(LocalDate.now()) == 0 &&
						manager1.getAvgDailySubs(LocalDate.now()) == 0);
		
		Assert.assertFalse(manager1.getAvgDailylabs(LocalDate.now()) != 0 ||
				manager1.getAvgDailyPatients(LocalDate.now()) != 0 ||
				manager1.getAvgDailySubs(LocalDate.now()) != 0);
		
		doctor1.add(patient1);
		doctor1.add(patient2);
		doctor2.add(patient3);
		doctor2.add(patient4);
				
		doctor1.createMedicalRecord("000000009", Record1);
		doctor1.createMedicalRecord("000000009", Record2);
		doctor1.createMedicalRecord("000000010", Record3);
		doctor1.createMedicalRecord("000000010", Record4);
		doctor2.createMedicalRecord("000000011", Record5);
		doctor2.createMedicalRecord("000000011", Record6);
		doctor2.createMedicalRecord("000000012", Record7);
		
		manager1.calcDailyStats();
		Assert.assertTrue(manager1.getAvgDailyPatients(LocalDate.now()) == 3.5 && manager1.getAvgDailylabs(LocalDate.now()) ==0 &&
				manager1.getAvgDailySubs(LocalDate.now()) == 3.5);
							
		Assert.assertFalse(manager1.getAvgDailyPatients(LocalDate.now()) != 3.5 || manager1.getAvgDailylabs(LocalDate.now()) !=0 ||
				manager1.getAvgDailySubs(LocalDate.now()) != 3.5);
		
		doctor1.remove(patient1.getId());
		doctor1.remove(patient2.getId());
		doctor2.remove(patient3.getId());
		doctor2.remove(patient4.getId());
		
		manager1.remove("000000007");
		manager1.remove("000000008");
		
	}
	
	@Test
	public void CheckGetItem() {
		
		Manager manager = new Manager("000000013", 5200000, "Name", "Email", "password","Manager");
		Manager manager1 = new Manager("000000014", 5200000, "Name", "Email", "password","Manager");
		
		Doctor doctor1 = new Doctor("000000015", "000000013", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("000000016", "000000013",  5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
		
		manager.add(doctor1);
		manager.add(doctor2);		
		
		Assert.assertTrue(doctor1 == manager.getItem(doctor1.getId()));
		Assert.assertTrue(doctor2 == manager.getItem(doctor2.getId()));
		
		Assert.assertFalse(manager1.getItem(doctor1.getId())!=null);
		
		manager.remove("000000015");
		manager.remove("000000016");
		
		Assert.assertFalse(manager.getItem("000000015") != null);

	}
	
	@Test
	public void CheckSearch() {
		
		Manager manager = new Manager("000000017", 5200000, "Name", "Email", "password","Manager");
		Manager manager1 = new Manager("000000018", 5200000, "Name", "Email", "password","Manager");
		
		Doctor doctor1 = new Doctor("000000019", "000000017", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		manager.add(doctor1);		
		
		Assert.assertTrue(manager.search(doctor1.getId()));
		Assert.assertFalse(manager1.search(doctor1.getId()));
		
		manager.remove("000000019");
		
	}
	
	@Test
	public void CheckUpdateDoctorInfo() {
		
		Manager manager = new Manager("000000020", 5200000, "Name", "Email", "password","Manager");
		Manager manager1 = new Manager("000000021", 5200000, "Name", "Email", "password","Manager");
		
		Doctor doctor1 = new Doctor("000000022", "000000020", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		Authentication.signUp(doctor1.getId(), doctor1);
		manager.add(doctor1);
		
		Assert.assertTrue(manager.updateDoctorInfo(doctor1.getId(), "Testing123", 1234));
		Assert.assertFalse(manager1.updateDoctorInfo(doctor1.getId(), "Testing123", 1234));
		
		Authentication.deleteSignUp(doctor1.getId());
		manager.remove("000000022");
		
	}
	
	@Test
	public void CheckGetAvgDailyPatients() {
		Manager manager = new Manager("000000023", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("000000024","000000023", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		Patient patient1 = new Patient("000000025", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000024");
		
		MedicalRecord Record1 = new MedicalRecord("000000025", "000000024", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "subtest", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("000000025", "000000024", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		
		manager.add(doctor1);
		doctor1.add(patient1);
		doctor1.createMedicalRecord("000000025", Record1);
		doctor1.createMedicalRecord("000000025", Record2);
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailyPatients(LocalDate.now()) == 2);
		Assert.assertFalse(manager.getAvgDailyPatients(LocalDate.now()) != 2);
		
		
		doctor1.remove(patient1.getId());
		manager.remove("000000024");
		
		
	}
	
	
	@Test
	public void CheckGetAvgDailylabs() {
		
		Manager manager = new Manager("000000026", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("000000027","000000026", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		Patient patient1 = new Patient("000000028", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000027");
		
		manager.add(doctor1);
		doctor1.add(patient1);
		doctor1.addLabToPatient("000000028", "Blood");
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailylabs(LocalDate.now()) == 1);
		Assert.assertFalse(manager.getAvgDailylabs(LocalDate.now()) != 1);
		
	}
	
	@Test
	public void CheckGetAvgDailySub() {
		Manager manager = new Manager("000000029", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("000000030","000000029", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		Patient patient1 = new Patient("000000031", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000030");
		
		MedicalRecord Record1 = new MedicalRecord("000000031", "000000030", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub,test", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("000000031", "000000030", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		
		manager.add(doctor1);
		doctor1.add(patient1);
		doctor1.createMedicalRecord("000000031", Record1);
		doctor1.createMedicalRecord("000000031", Record2);
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailySubs(LocalDate.now()) == 3);
		Assert.assertFalse(manager.getAvgDailySubs(LocalDate.now()) != 3);
		
		doctor1.remove(patient1.getId());
		manager.remove("000000030");
		
	}
	
	
	
}
