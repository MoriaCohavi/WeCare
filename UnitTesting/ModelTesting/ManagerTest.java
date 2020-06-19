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
		Doctor doctor = new Doctor("100000000", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		Assert.assertTrue(manager.add(doctor));
		Assert.assertFalse(manager.add(doctor));
		manager.remove("100000000");
		
	}
	
	@Test
	public void CheckRemove()
	{
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Assert.assertTrue(manager.remove(doctor.getDoctorID()));
		Assert.assertFalse(manager.remove(doctor.getDoctorID()));
		
		Manager manager1 = new Manager("000000002", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Assert.assertFalse(manager1.remove(doctor.getDoctorID()));
		
		manager.remove("000000001");
	}
	
	@Test
	public void CheckCalcDailyStats() {
		
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("000000001","000000003", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("000000004","000000003", 5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
				
		Patient patient1 = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		Patient patient2 = new Patient("000000005", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		Patient patient3 = new Patient("000000006", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000004");
		Patient patient4 = new Patient("000000007", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000004");
		
		MedicalRecord Record1 = new MedicalRecord("000000002", "000000001", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("000000002", "000000001", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 60, 180, 90, 37, 60, 100);
		MedicalRecord Record3 = new MedicalRecord("000000005", "000000001", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 75, 190, 90, 37, 60, 100);
		MedicalRecord Record4 = new MedicalRecord("000000005", "000000001", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 75, 190, 90, 37, 60, 100);
		MedicalRecord Record5 = new MedicalRecord("000000006", "000000004", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 90, 180, 90, 37, 60, 100);
		MedicalRecord Record6 = new MedicalRecord("000000006", "000000004", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 55, 165, 90, 37, 60, 100);
		MedicalRecord Record7 = new MedicalRecord("000000007", "000000004", 3, patient4.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test", 55, 165, 90, 37, 60, 100);
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailylabs(LocalDate.now())== 0 &&
				manager.getAvgDailyPatients(LocalDate.now()) == 0 &&
				manager.getAvgDailySubs(LocalDate.now()) == 0);
		
		Assert.assertFalse(manager.getAvgDailylabs(LocalDate.now()) != 0 ||
				manager.getAvgDailyPatients(LocalDate.now()) != 0 ||
				manager.getAvgDailySubs(LocalDate.now()) != 0);
		
		manager.add(doctor1);
		manager.add(doctor2);
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailylabs(LocalDate.now())== 0 &&
				manager.getAvgDailyPatients(LocalDate.now()) == 0 &&
				manager.getAvgDailySubs(LocalDate.now()) == 0);
		
		Assert.assertFalse(manager.getAvgDailylabs(LocalDate.now()) != 0 ||
				manager.getAvgDailyPatients(LocalDate.now()) != 0 ||
				manager.getAvgDailySubs(LocalDate.now()) != 0);
		
		doctor1.add(patient1);
		doctor1.add(patient2);
		doctor2.add(patient3);
		doctor2.add(patient4);
				
		doctor1.createMedicalRecord("000000002", Record1);
		doctor1.createMedicalRecord("000000002", Record2);
		doctor1.createMedicalRecord("000000005", Record3);
		doctor1.createMedicalRecord("000000005", Record4);
		doctor2.createMedicalRecord("000000006", Record5);
		doctor2.createMedicalRecord("000000006", Record6);
		doctor2.createMedicalRecord("000000007", Record7);
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailyPatients(LocalDate.now()) == 3.5 && manager.getAvgDailylabs(LocalDate.now()) ==0 &&
							manager.getAvgDailySubs(LocalDate.now()) == 3.5);
							
		Assert.assertFalse(manager.getAvgDailyPatients(LocalDate.now()) != 3.5 || manager.getAvgDailylabs(LocalDate.now()) !=0 ||
				manager.getAvgDailySubs(LocalDate.now()) != 3.5);
		
		doctor1.addLabToPatient("000000002", "Blood");
		doctor1.addLabToPatient("000000002", "Urine");
		doctor1.addLabToPatient("000000005", "Blood");
		doctor2.addLabToPatient("000000006", "Blood");
		
		manager.calcDailyStats();
		Assert.assertTrue(manager.getAvgDailyPatients(LocalDate.now()) == 3.5 && manager.getAvgDailylabs(LocalDate.now()) ==2 &&
							manager.getAvgDailySubs(LocalDate.now()) == 3.5);
							
		Assert.assertFalse(manager.getAvgDailyPatients(LocalDate.now()) != 3.5 || manager.getAvgDailylabs(LocalDate.now()) !=2 ||
				manager.getAvgDailySubs(LocalDate.now()) != 3.5 );
		
		doctor1.remove(patient1.getId());
		doctor1.remove(patient2.getId());
		doctor2.remove(patient3.getId());
		doctor2.remove(patient4.getId());
		
		manager.remove("000000001");
		manager.remove("000000004");
		
	}
	
	@Test
	public void CheckGetItem() {
		
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		Manager manager1 = new Manager("000000002", 5200000, "Name", "Email", "password","Manager");
		
		Doctor doctor1 = new Doctor("100000000", "000000003", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("400000000", "000000003",  5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
		
		manager.add(doctor1);
		manager.add(doctor2);		
		
		Assert.assertTrue(doctor1 == manager.getItem(doctor1.getId()));
		Assert.assertTrue(doctor2 == manager.getItem(doctor2.getId()));
		
		Assert.assertFalse(manager1.getItem(doctor1.getId())!=null);
		
		manager.remove("100000000");
		manager.remove("400000000");
		
		Assert.assertFalse(manager.getItem("100000000") != null);

	}
	
	@Test
	public void CheckSearch() {
		
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		Manager manager1 = new Manager("000000002", 5200000, "Name", "Email", "password","Manager");
		
		Doctor doctor1 = new Doctor("000000001", "000000003", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		manager.add(doctor1);		
		
		Assert.assertTrue(manager.search(doctor1.getId()));
		Assert.assertFalse(manager1.search(doctor1.getId()));
		
		manager.remove("000000001");
		
	}
	
	@Test
	public void CheckUpdateDoctorInfo() {
		
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		Manager manager1 = new Manager("000000002", 5200000, "Name", "Email", "password","Manager");
		
		Doctor doctor1 = new Doctor("000000001", "000000003", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		
		Authentication.signUp(doctor1.getId(), doctor1);
		manager.add(doctor1);
		
		Assert.assertTrue(manager.updateDoctorInfo(doctor1.getId(), "Testing123", 1234));
		Assert.assertFalse(manager1.updateDoctorInfo(doctor1.getId(), "Testing123", 1234));
		
		Authentication.deleteSignUp(doctor1.getId());
		manager.remove("000000001");
		
	}
}
