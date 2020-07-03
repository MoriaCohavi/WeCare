package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
//import java.time.*;
import java.util.*;

//import com.sun.javafx.scene.EnteredExitedHandler;


public class Doctor extends User implements java.io.Serializable, CommandInterface {
	
	private static int statsCount = 0;
	private static HashMap <Integer, StatisitcalData> statsList = new HashMap<Integer, StatisitcalData>();
	private String specialization, managerID;
	private static HashMap <String, Patient> patients = new HashMap <String, Patient>();
	
	//constructor
	public Doctor(String id, String managerId, long phone, String name, String email, String special,String password,String user_type) {
		
		super(id, phone, name, email, password, user_type);
		this.specialization = special;
		this.managerID =managerId;
	}
	
	/**getters and setters**/
	
	public void setSpecialization (String newSpecial) {
		
		this.specialization = newSpecial;
	}
	
	public String getSpecialization () {
		
		return specialization;
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
	
	public static HashMap<Integer, StatisitcalData> getStatsList(){
		
		return statsList;
	}
	
	public static void setStatsList(HashMap<Integer, StatisitcalData> newStats){
		
		statsList = newStats;
	}
	
	public void setPatients(HashMap<String, Patient> tempPatients) {
		patients = tempPatients;
	}
	
	
	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public static int getStatsCount() {
		return statsCount;
	}

	public static void setStatsCount(int statsCount) {
		Doctor.statsCount = statsCount;
	}
	
	public String getPatientName(String patientId)
	{
		return this.getItem(patientId).getName();
	}
	
	public String getPatientEmail(String patientId)
	{
		return this.getItem(patientId).getEmail();
	}
	
	public long getPatientPhone(String patientId)
	{
		return this.getItem(patientId).getPhone();
	}
	
	public int getPatientAge(String patientId)
	{
		return this.getItem(patientId).getAge();
	}
	
	public int getPatientHeight(String patientId)
	{
		return this.getItem(patientId).getHeight();
	}
	
	public int getPatientWeight(String patientId)
	{
		return this.getItem(patientId).getWeight();
	}
	
	public String getPatientAllergic(String patientId)
	{
		return this.getItem(patientId).getAllergies();
	}
	
	public String getPatientChronicDiseases(String patientId)
	{
		return this.getItem(patientId).getChronic_diseases();
	}
	
	public String getPatientSubscription(String patientId)
	{
		return this.getItem(patientId).getSubscriptions();
	}
	
	public HashMap<String, Patient> getPatients() {
		return patients;
	}
	
	public HashMap<Integer, MedicalRecord> getPatientsMedicalRecords()
	{
		return Patient.getMedicalRecords();
	}
	
	
	/**methods**/
	
	public void addSpecialization (String newSpecial) { 
		
		this.specialization = this.specialization.concat(" and " + newSpecial);
	}
	
	public boolean add(Object obj) {
		
		Patient newPatient = (Patient)obj;
		if (!search(newPatient.getId()))
		{
			patients.put(newPatient.getId(), newPatient);				
			return true;
		}
		
		return false;	
	}
	
	
	public boolean remove(String id) { 
		
		if (search(id)) 
		{
			patients.remove(id);
			return true;
		}
		
		else
			return false;
	}
	
	public boolean search(String id) { 
		
		if(patients.containsKey(id) && this.getId().equals(patients.get(id).getDoctorId())) 
			return true;
		return false;
	}
	
	public Patient getItem(String patientId) { 

		if (search(patientId))
			return patients.get(patientId);
			
		else 
			return null;
	}
	
	
	public StatisitcalData getFirstRecord() { 
		
		HashMap<Integer, StatisitcalData> entries = statsList;
		if(entries.isEmpty())
			return null;
		for (Integer key : entries.keySet() ) {
				if (entries.get(key).getDoctorId().equals(this.getId()))
					return entries.get(key);
		}

		return null;
	}
	
	public StatisitcalData getDailyAvgRecords(LocalDate date, String docId) { 
		
		StatisitcalData total = new StatisitcalData(this.getManagerID()), current = new StatisitcalData(this.getManagerID());
		if (statsList.size() != 0)
		{
			int size = 0;
			for (Integer Key : statsList.keySet()){
				if (statsList.get(Key).getDoctorId().equals(docId) && date.equals(statsList.get(Key).getDate())) {
					current = statsList.get(Key);
					total.addtotalDailylabs(current.getTotalDailylabs());
					total.addtotalDailyPatients(current.getTotalDailyPatients());
					total.addtotalDailySubs(current.getTotalDailySubs());
					size++;
				}
			}
			if (size!=0) {
				total.setTotalDailylabs(total.getTotalDailylabs()/size);
				total.setTotalDailyPatients(total.getTotalDailyPatients()/size);
				total.setTotalDailySubs(total.getTotalDailySubs()/size);
				return total;
			}
		}
		
		total.setTotalDailylabs(0);
		total.setTotalDailyPatients(0);
		total.setTotalDailySubs(0);
		
		return total;
	}
	
	
	
	public void updatePatientInfo(String patientId, int phone,int age, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases) {
	
		if (search(patientId)) {
			patients.get(patientId).updatePatientInfo(phone, age, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
		}
	}

	 
	public boolean createMedicalRecord(String patientId, MedicalRecord newRecord) {				
		if (search(patientId)) {
			patients.get(patientId).addMedicalRecord(newRecord);
			
			//updating stats
			StatisitcalData editData;
			if (statsList.containsKey(statsCount)) {
				if (statsList.get(statsCount).getDoctorId() == this.getId()) {
					editData = statsList.get(statsCount);
				}
				else {
					editData = new StatisitcalData(this.getDoctorID());
					statsCount++;
				}
			}
			else
				{
				editData = new StatisitcalData(this.getDoctorID());
				statsCount++;
			}
			
			editData.addtotalDailyPatients(1);
			
			if (newRecord.get_subscriptions() != null) { 
				String[] words = newRecord.get_subscriptions().split(",");
				editData.addtotalDailySubs(words.length);				
			}
			statsList.put(statsCount, editData);
			
			return true;
		}
		
		else return false;
	}
		
	public boolean addLabToPatient(String patientId, String labType) {
		if (search(patientId)) {
			
			Lab newLab = new Lab(labType, "null", false, patientId);
			patients.get(patientId).addLab(newLab);
			
			StatisitcalData editData;
			if (statsList.containsKey(statsCount)) {
				if (statsList.get(statsCount).getDoctorId() == this.getId()) {
					editData = statsList.get(statsCount);
				}
				else {
					editData = new StatisitcalData(this.getDoctorID());
					statsCount++;
				}
			}
			else
				{
				editData = new StatisitcalData(this.getDoctorID());
				statsCount++;
			}
				
			
			editData.addtotalDailylabs(1);
			
			statsList.put(statsCount, editData);
			
			return true;
		}
		
		else return false;
	}
	
	
	public boolean updatePatientInfo(String patientId, String email, long phone, String allergies, String chronic_diseases, String subscriptions)
	{
		if(search(patientId))
		{
			patients.get(patientId).setEmail(email);
			patients.get(patientId).setPhone(phone);
			patients.get(patientId).setAllergies(allergies);
			patients.get(patientId).setChronic_diseases(chronic_diseases);
			patients.get(patientId).setSubscriptions(subscriptions);
			return true;
		}
		else return false;
	}


	
}

