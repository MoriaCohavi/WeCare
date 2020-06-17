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

public class ManagerTest{
	
	@Test
	public void CheckAdd()	{
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
	public void calcStats() {
		
		Manager manager = new Manager("123456789", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("123456789", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("123456781", 5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
				
		Patient patient1 = new Patient("123456788", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		Patient patient2 = new Patient("123456787", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		Patient patient3 = new Patient("123456786", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		Patient patient4 = new Patient("123456785", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des");
		
		MedicalRecord Record1 = new MedicalRecord("123456788", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(10), 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("123456788", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(5), 60, 180, 90, 37, 60, 100);
		MedicalRecord Record3 = new MedicalRecord("123456787", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(15), 75, 190, 90, 37, 60, 100);
		MedicalRecord Record4 = new MedicalRecord("123456787", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(15), 75, 190, 90, 37, 60, 100);
		MedicalRecord Record5 = new MedicalRecord("123456786", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(10), 90, 180, 90, 37, 60, 100);
		MedicalRecord Record6 = new MedicalRecord("123456786", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(10), 55, 165, 90, 37, 60, 100);
		MedicalRecord Record7 = new MedicalRecord("123456785", 3, patient4.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(5), 55, 165, 90, 37, 60, 100);
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailylabs() == 0 &&
				manager.getAvgDailyPatients() == 0 &&
				manager.getAvgDailySubs() == 0 &&
				manager.getAvgVisitTime() == 0);
		
		Assert.assertFalse(manager.getAvgDailylabs() != 0 ||
				manager.getAvgDailyPatients() != 0 ||
				manager.getAvgDailySubs() != 0 ||
				manager.getAvgVisitTime() != 0);
		
		manager.add(doctor1);
		manager.add(doctor2);
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailylabs() == 0 &&
				manager.getAvgDailyPatients() == 0 &&
				manager.getAvgDailySubs() == 0 &&
				manager.getAvgVisitTime() == 0);
		
		Assert.assertFalse(manager.getAvgDailylabs() != 0 ||
				manager.getAvgDailyPatients() != 0 ||
				manager.getAvgDailySubs() != 0 ||
				manager.getAvgVisitTime() != 0);
		
		doctor1.add(patient1);
		doctor1.add(patient2);
		doctor2.add(patient3);
		doctor2.add(patient4);
				
		doctor1.createMedicalRecord("123456788", Record1);
		doctor1.createMedicalRecord("123456788", Record2);
		doctor1.createMedicalRecord("123456787", Record3);
		doctor1.createMedicalRecord("123456787", Record4);
		doctor2.createMedicalRecord("123456786", Record5);
		doctor2.createMedicalRecord("123456786", Record6);
		doctor2.createMedicalRecord("123456785", Record7);
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailyPatients() == 3.5 && manager.getAvgDailylabs() ==0 &&
							manager.getAvgDailySubs() == 3.5 && manager.getAvgVisitTime() == 10);
							
		Assert.assertFalse(manager.getAvgDailyPatients() != 3.5 || manager.getAvgDailylabs() !=0 ||
				manager.getAvgDailySubs() != 3.5 || manager.getAvgVisitTime() != 10);
		
		doctor1.addLabToPatient("123456788", "Blood");
		doctor1.addLabToPatient("123456788", "Urine");
		doctor1.addLabToPatient("123456787", "Blood");
		doctor2.addLabToPatient("123456786", "Blood");
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailyPatients() == 3.5 && manager.getAvgDailylabs() ==2 &&
							manager.getAvgDailySubs() == 3.5 && manager.getAvgVisitTime() == 10);
							
		Assert.assertFalse(manager.getAvgDailyPatients() != 3.5 || manager.getAvgDailylabs() !=2 ||
				manager.getAvgDailySubs() != 3.5 || manager.getAvgVisitTime() != 10);		
		
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
//		Assert.assertFalse(manager.remove(doctor.getDoctorID()));
//	}
	
}
