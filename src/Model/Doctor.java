package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
//import java.time.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Doctor extends User implements java.io.Serializable {
	
	private LinkedHashMap <LocalDate, StatisitcalData> stats = new LinkedHashMap<LocalDate, StatisitcalData>();
	private String specialization;
	private HashMap <String, Patient> patients;
	
	//constructor
	public Doctor(String id, long phone, String name, String email, String special,String password,String user_type) {
		super(id, phone, name, email, password, user_type);
		this.specialization = special;
		this.patients = new HashMap <String, Patient>();
		this.stats = new LinkedHashMap<LocalDate, StatisitcalData>();
	}
	
	//setters and getters
	public void setSpecialization (String newSpecial) {
		this.specialization = newSpecial;
	}
	
	public String getDoctorID() {
		return this.getId();
	}
	
	public String getDoctorName() {
		return this.getName();
	}
	
	public long getDoctorPhone() {
		return this.getPhone();
	}
	
	public String getDoctorEmail() {
		return this.getEmail();
	}
	
	public String getDoctorSpecialization() {
		return this.specialization;
	}
	
	//methods
	
	public void addSpecialization (String newSpecial) {
		this.specialization = this.specialization.concat("and" + newSpecial);
	}
	
	public boolean addPatient(Patient firstTimePatient){
		
		if (!patients.containsKey(firstTimePatient.getId())){
			this.patients.put(firstTimePatient.getId(), firstTimePatient);
			return true;
		}
		return false;
	}
	
	public boolean removePatient (String patientId) {
		
		if (this.patients.containsKey(patientId)) {
			patients.remove(patientId);
			return true;
		}
		else
				return false;
		}
	
	public boolean searchForPatient(String patientId) {
		
		if (this.patients.containsKey(patientId))
			return true;
		return false;
		
	}
	
	public Patient getPatient(String patientId) {
			
			if (searchForPatient(patientId))
				return this.patients.get(patientId);
				
			else return null;
			
		}
	
	
	public void updatePatientInfo(String patientId, int phone, String email, int weight, int height, String gender, String allergies, String subscriptions) {
		if (this.patients.containsKey(patientId)) {
			patients.get(patientId).updatePatientInfo(phone, email, weight, height, gender,allergies,subscriptions);
		}
	
	}
	 
	public boolean createMedicalRecord(String patientId, MedicalRecord newRecord) {		
		if (this.patients.containsKey(patientId)) {
			patients.get(patientId).addMedicalRecord(newRecord);
			
			//updating stats
			if (!this.stats.containsKey(LocalDate.now())) 
				this.stats.put(LocalDate.now(), new StatisitcalData());
			
			StatisitcalData editStats = this.stats.get(LocalDate.now());
			double time = ChronoUnit.MINUTES.between(newRecord.get_ETime(), newRecord.get_STime());
			editStats.setTotalVisitTime(time);
			editStats.setTotalDailyPatients(1);
			
			if (newRecord.get_subscriptions() != null) { 
				String[] words = newRecord.get_subscriptions().split(",");
				editStats.addtotalDailySubs(words.length);
			}
			
			this.stats.put(LocalDate.now(), editStats);
			return true;
		}
		else return false;
	}
	
	public boolean addLabToPatient(String patientId, String labType) {
		
		if (this.patients.containsKey(patientId)) {
			
			Lab newLab = new Lab(labType, null, false);
			patients.get(patientId).addLab(newLab);
			
			//updating stats
			if (!this.stats.containsKey(LocalDate.now())) 
				this.stats.put(LocalDate.now(), new StatisitcalData());
			
			StatisitcalData editStats = this.stats.get(LocalDate.now());
			editStats.addtotalDailylabs(1);
			
			this.stats.put(LocalDate.now(), editStats);
			return true;
		}
		else return false;
	}
	
	public String visitSummary(String patientId, int recordId) {
		
		if (this.patients.containsKey(patientId)) {
			return patients.get(patientId).getMedicalRecord(recordId).get_VisitSummary();
		}
		
		return null;
		
	}
	
	public String PatientMedicalSummary(String patientId) {
		
		if (this.patients.containsKey(patientId)) {
			return patients.get(patientId).medicalSummary();
		}
		
		return null;
	}			
}

