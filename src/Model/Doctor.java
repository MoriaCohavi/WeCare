package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.time.*;
import java.util.HashMap;

public class Doctor extends User implements java.io.Serializable {
	
	//private HashMap <LocalDate, StatisticalData> stats = new HashMap<LocalDate, StatisticalData>();
	private String specialization;
	private HashMap <String, Patient> patients;
	
	//constructor
	public Doctor(String id, long phone, String name, String email, String special,String password,String user_type) {
		super(id, phone, name, email, password, user_type);
		this.specialization = special;
		this.patients = new HashMap <String, Patient>();
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
			return true;
		}
		else
				return false;
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

