package Controller;

import java.time.LocalTime;
import java.util.HashMap;

import Model.*;

public class doctorController {
	public static String serPath = "src\\Model\\files\\doctor.ser";
	private Doctor currentModelDoctor;
	
	public Doctor getDetails() {
		
		return currentModelDoctor;
	}
	
	public doctorController(Doctor doctor) {
		
		currentModelDoctor = doctor;
	}
	
	public doctorController(String id, int phone, String name, String email, String special,String password,String user_type) { // needs to include doctorview obj
		
		currentModelDoctor = new Doctor (id, phone, name, email, special,password,user_type);
	}
	
	public boolean addNewPatient (String id,int age, long phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases) {
		
		Patient newPatient = new Patient(id, age, phone, name, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
		if (currentModelDoctor.add(newPatient))
			return true;

		return false;	
	}
	
	public boolean deletePatient(String patientId) {
		
		if (currentModelDoctor.remove(patientId))
			return true;
		
		return false;	
	}
	
	/*public String viewPatientInfo (String patientId) {
		
		return currentModelDoctor.getPatient(patientId).getPatientInfo();
	}*/
	
	public Patient getPatient(String patientId) {
		
		return currentModelDoctor.getItem(patientId);
	}
	
	public MedicalRecord viewMedicalRecord(String patientId, int recordId) {
		
		return currentModelDoctor.getItem(patientId).getMedicalRecord(recordId);
	}
	
	public Patient openPatientFile(String patientId) {
		
		return currentModelDoctor.getItem(patientId);
	}
	
	public boolean openNewMedicalRecord(String patientId, int days, String purpose, String description, String summary,
			String sub, String diagnose, LocalTime sT, LocalTime eT, int w, int h, int hr, int t, int sysBP, int diaBP) {
		
		if (currentModelDoctor.search(patientId))
		{
			
			int record = currentModelDoctor.getItem(patientId).getRecordCounter() + 1;
			
			MedicalRecord newRecord = new MedicalRecord(currentModelDoctor.getDoctorID(), days, record, purpose,description, summary, sub,diagnose, sT, eT, w, h, hr, t, sysBP, diaBP) ;
			
			currentModelDoctor.getItem(patientId).addMedicalRecord(newRecord);
			return true;
		}
		
		else return false;
	}
 
	public void serialize() {
		
		serHandlerController.serialize(currentModelDoctor, serPath);
	}
	
	public void updateDoctor()
	{
		
	}
	
	public void deserialize() {
		
		currentModelDoctor = (Doctor)serHandlerController.deserialize(serPath);
	}

	public HashMap <String, Patient> getPatientsList() {
		
		return this.currentModelDoctor.getPatients();
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
	public double getDoctorAverageVisitTime()
	{
		return currentModelDoctor.getAvgRecords().getTotalVisitTime();
	}
	
	public String getDoctorSpecialization()
	{
		return currentModelDoctor.getDoctorSpecialization();
	}
}