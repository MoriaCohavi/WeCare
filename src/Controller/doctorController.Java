package Controller;

import java.time.LocalTime;
import java.util.HashMap;

import Model.*;

public class doctorController {
	public static String serPathPatients = "src\\Model\\files\\patients.ser";
	public static String serPathRecords = "src\\Model\\files\\records.ser";
	private Doctor currentModelDoctor;
	private final String typeNeed = "Doctor";
	
	public Doctor getDetails() {
		
		return currentModelDoctor;
		
	}
	
	public doctorController(Doctor doctor) {
		currentModelDoctor = doctor;
		deserializePatients();
		deserializeRecords();
	}
	
	public doctorController(String doctorId, String manaegerId, int phone, String name, String email, String special,String password,String user_type) { // needs to include doctorview obj
		
		currentModelDoctor = new Doctor(doctorId, manaegerId, phone, name, email, special, password, user_type);
	}
	
	public boolean addNewPatient (long token, String id,int age, long phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases) {
		if(Authentication.validateUser(token, typeNeed))
		{
			Patient newPatient = new Patient(id, age, phone, name, email, weight, height, gender, allergies, subscriptions, chronic_diseases, currentModelDoctor.getDoctorID());
			if (currentModelDoctor.add(newPatient))
				return true;
		}
		return false;	
	}
	
	public boolean deletePatient(long token, String patientId) {
		if(Authentication.validateUser(token, typeNeed))
		{
			if (currentModelDoctor.remove(patientId))
			return true;
		}
		return false;	
	}
	
	public Patient getPatient(long token, String patientId) {
		if(Authentication.validateUser(token, typeNeed))
			return currentModelDoctor.getItem(patientId);
		return null;
	}
	
	
	public  HashMap <String, Patient>  getPatientList( long token) {
		if(Authentication.validateUser(token, typeNeed))
			return currentModelDoctor.getPatients();
		return null;
	}
	
	
	public MedicalRecord viewMedicalRecord(long token, String patientId, int recordId) {
		if(Authentication.validateUser(token, typeNeed))
			return currentModelDoctor.getItem(patientId).getMedicalRecord(recordId, patientId);
		return null;
	}
	
	public Patient openPatientFile(long token, String patientId) {
		if(Authentication.validateUser(token, typeNeed))
			return currentModelDoctor.getItem(patientId);
		
		return null;
	}
	
	public boolean openNewMedicalRecord(long token, String patientId, int days, String purpose, String description, String summary,	String sub, String diagnose, int w, int h, int hr, int t, int sysBP, int diaBP) {
		
		if(Authentication.validateUser(token, typeNeed))
		{
			if (currentModelDoctor.search(patientId))
			{
				Patient currPatient = currentModelDoctor.getItem(patientId);
				int record = currPatient.getRecordCounter() + 1;
			
				MedicalRecord newRecord = new MedicalRecord(currPatient.getId(), currentModelDoctor.getDoctorID(), days, record, purpose,description, summary, sub,diagnose, w, h, hr, t, sysBP, diaBP) ;
				if (currentModelDoctor.createMedicalRecord(patientId, newRecord))
				{
					return true;
				}
			}
		}
		
		return false;
	}
 
	public void serializeRecords() {
		HashMap<Integer,MedicalRecord> tempRecords = Patient.getMedicalRecords();
		serHandlerController.serialize(tempRecords, serPathRecords);
	}
	
	public void serializePatients() {
		HashMap<String,Patient> tempPatients = currentModelDoctor.getPatients();
		serHandlerController.serialize(tempPatients, serPathPatients);
	}
	
	
	public boolean deserializePatients() {
		HashMap<String,Patient> tempPatients = (HashMap<String,Patient>)serHandlerController.deserialize(serPathPatients);
		if (tempPatients == null)
			return false;
		this.currentModelDoctor.setPatients(tempPatients);
		return true;
	}
	
	public boolean deserializeRecords() {
		HashMap<Integer,MedicalRecord> tempRecords = (HashMap<Integer,MedicalRecord>)serHandlerController.deserialize(serPathRecords);
		if (tempRecords == null)
			return false;
		Patient.setMedicalRecords(tempRecords);
		Patient.setRecordsCounter(tempRecords.size());
		return true;
	}
	
	public void updateDoctor(String id, String name, String email, long phone)
	{
		managerController mgmtCtrl = new managerController();
		Doctor doc = mgmtCtrl.getDoctorItem(id);
	}

	public HashMap <String, Patient> getPatientsList(long token) {
		if(Authentication.validateUser(token, typeNeed))
			return this.currentModelDoctor.getPatients();
		return null;
	}
	
	public String getDoctorID()
	{
		return currentModelDoctor.getDoctorID();
	}
	
	public String getDoctorName()
	{
		return currentModelDoctor.getDoctorName();
	}
	public String getDoctorEmail()
	{
		return currentModelDoctor.getDoctorEmail();
	}
	public long getDoctorPhone()
	{
		return currentModelDoctor.getDoctorPhone();
	}
	public double getDoctorAveragePatients()
	{
		return currentModelDoctor.getAvgRecords().getTotalDailyPatients();
	}
	public double getDoctorAverageSubscriptions()
	{
		return currentModelDoctor.getAvgRecords().getTotalDailySubs();
	}
	public double getDoctorAverageLabs()
	{
		return currentModelDoctor.getAvgRecords().getTotalDailylabs();
	}

	
	public String getDoctorSpecialization()
	{
		return currentModelDoctor.getDoctorSpecialization();
	}
	
	public String getPatientName(String patientId)
	{
		return currentModelDoctor.getPatientName(patientId);
	}
	
	public String getPatientEmail(String patientId)
	{
		return currentModelDoctor.getPatientEmail(patientId);
	}
	
	public long getPatientPhone(String patientId)
	{
		return currentModelDoctor.getPatientPhone(patientId);
	}
	
	public int getPatientAge(String patientId)
	{
		return currentModelDoctor.getPatientAge(patientId);
	}
	
	public int getPatientHeight(String patientId)
	{
		return currentModelDoctor.getPatientHeight(patientId);
	}
	
	public int getPatientWeight(String patientId)
	{
		return currentModelDoctor.getPatientWeight(patientId);
	}
	
	public String getPatientAllergic(String patientId)
	{
		return currentModelDoctor.getPatientAllergic(patientId);
	}
	
	public String getPatientChronicDiseases(String patientId)
	{
		return currentModelDoctor.getPatientChronicDiseases(patientId);
	}
	
	public String getPatientSubscription(String patientId)
	{
		return currentModelDoctor.getPatientSubscription(patientId);
	}
	
	public boolean updatePatientInfo(long token, String patientId, String email, long phone, String allergies, String chronic_diseases, String subscriptions)
	{
		if(Authentication.validateUser(token, typeNeed))
		{
			currentModelDoctor.updatePatientInfo(patientId, email, phone, allergies, chronic_diseases, subscriptions);
				return true;
		}
		return false;
	}
	
//	public boolean createMedicalRecord(String visitPurpose, String visitDesc, String visitDiagnostic, String visitSummary, String visitSubscription)
//	{
//		return true;
//	}
}
