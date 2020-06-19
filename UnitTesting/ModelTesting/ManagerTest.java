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
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		Assert.assertTrue(manager.add(doctor));
		Assert.assertFalse(manager.add(doctor));
		
		manager.remove("000000001");
		
	}
	
	@Test
	public void CheckRemove()
	{
		Doctor doctor = new Doctor("000000001", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");
		manager.add(doctor);
		Assert.assertTrue(manager.remove(doctor.getDoctorID()));
		Assert.assertFalse(manager.remove(doctor.getDoctorID()));
		
		manager.remove("000000001");
	}
	
	@Test
	public void CheckCalcStats() {
		
		Manager manager = new Manager("000000003", 5200000, "Name", "Email", "password","Manager");

		Doctor doctor1 = new Doctor("000000001","000000003", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("000000004","000000003", 5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
				
		Patient patient1 = new Patient("000000002", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		Patient patient2 = new Patient("000000005", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000001");
		Patient patient3 = new Patient("000000006", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000004");
		Patient patient4 = new Patient("000000007", 13, 01234567, "Name", "Email", 143, 154, "male","test aller", "test sub", "test des", "000000004");
		
		MedicalRecord Record1 = new MedicalRecord("000000002", "000000001", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(10), 60, 180, 90, 37, 60, 100);
		MedicalRecord Record2 = new MedicalRecord("000000002", "000000001", 3, patient1.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(5), 60, 180, 90, 37, 60, 100);
		MedicalRecord Record3 = new MedicalRecord("000000005", "000000001", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(15), 75, 190, 90, 37, 60, 100);
		MedicalRecord Record4 = new MedicalRecord("000000005", "000000001", 3, patient2.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(15), 75, 190, 90, 37, 60, 100);
		MedicalRecord Record5 = new MedicalRecord("000000006", "000000004", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(10), 90, 180, 90, 37, 60, 100);
		MedicalRecord Record6 = new MedicalRecord("000000006", "000000004", 3, patient3.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(10), 55, 165, 90, 37, 60, 100);
		MedicalRecord Record7 = new MedicalRecord("000000007", "000000004", 3, patient4.getRecordCounter()+1, "purp_testing","desc_testing", "sum_testing", "sub_test", "diag_test",LocalTime.now(),LocalTime.now().plusMinutes(5), 55, 165, 90, 37, 60, 100);
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailylabs() == 0 &&
				manager.getAvgDailyPatients() == 0 &&
				manager.getAvgDailySubs() == 0);
		
		Assert.assertFalse(manager.getAvgDailylabs() != 0 ||
				manager.getAvgDailyPatients() != 0 ||
				manager.getAvgDailySubs() != 0);
		
		manager.add(doctor1);
		manager.add(doctor2);
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailylabs() == 0 &&
				manager.getAvgDailyPatients() == 0 &&
				manager.getAvgDailySubs() == 0);
		
		Assert.assertFalse(manager.getAvgDailylabs() != 0 ||
				manager.getAvgDailyPatients() != 0 ||
				manager.getAvgDailySubs() != 0);
		
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
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailyPatients() == 3.5 && manager.getAvgDailylabs() ==0 &&
							manager.getAvgDailySubs() == 3.5);
							
		Assert.assertFalse(manager.getAvgDailyPatients() != 3.5 || manager.getAvgDailylabs() !=0 ||
				manager.getAvgDailySubs() != 3.5);
		
		doctor1.addLabToPatient("000000002", "Blood");
		doctor1.addLabToPatient("000000002", "Urine");
		doctor1.addLabToPatient("000000005", "Blood");
		doctor2.addLabToPatient("000000006", "Blood");
		
		manager.calcStats();
		Assert.assertTrue(manager.getAvgDailyPatients() == 3.5 && manager.getAvgDailylabs() ==2 &&
							manager.getAvgDailySubs() == 3.5);
							
		Assert.assertFalse(manager.getAvgDailyPatients() != 3.5 || manager.getAvgDailylabs() !=2 ||
				manager.getAvgDailySubs() != 3.5 );
		
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

		Doctor doctor1 = new Doctor("000000001", "000000003", 5200000, "Name1", "Email1", "Spetialty1","password", "Doctor");
		Doctor doctor2 = new Doctor("000000004", "000000003",  5200000, "Name2", "Email2", "Spetialty2","password", "Doctor");
		Doctor doctor3 = new Doctor("000000007", "000000003", 5200000, "Name3", "Email3", "Spetialty3","password", "Doctor");
		
		manager.add(doctor1);
		manager.add(doctor2);
		manager.add(doctor3);		
		
		Assert.assertTrue(doctor1 == manager.getItem("000000001"));
		Assert.assertTrue(doctor2 == manager.getItem("000000004"));
		Assert.assertTrue(doctor3 == manager.getItem("000000007"));
		manager.remove("000000001");
		
		manager.remove("000000001");
		manager.remove("000000004");
		manager.remove("000000007");
		
		Assert.assertFalse(manager.getItem("000000001") != null);

	}
}
