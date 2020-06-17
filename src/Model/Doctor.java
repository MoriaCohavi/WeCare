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
import java.util.*;

public class Doctor extends User implements java.io.Serializable, CommandInterface {
	
	private LinkedHashMap <LocalDate, StatisitcalData> stats = new LinkedHashMap<LocalDate, StatisitcalData>();
	private String specialization;
	private static HashMap <String, Patient> patients = new HashMap <String, Patient>();
	
	//constructor
	public Doctor(String id, long phone, String name, String email, String special,String password,String user_type) {
		
		super(id, phone, name, email, password, user_type);
		this.specialization = special;
		this.stats = new LinkedHashMap<LocalDate, StatisitcalData>();
	}
	
	//setters and getters
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
	
	public LinkedHashMap<LocalDate, StatisitcalData> getStats(){
		
		return this.stats;
	}
	
	//methods
	
	public void addSpecialization (String newSpecial) { 
		/*tested*/
		
		this.specialization = this.specialization.concat(" and " + newSpecial);
	}
	
	public boolean add(Object obj) {
		/*tested*/
		
		Patient newPatient = (Patient)obj;
		if (!search(newPatient.getId()))
		{
			patients.put(newPatient.getId(), newPatient);
			return true;
		}
		
		return false;	
	}
	
	
	public boolean remove(String id) { 
		/*tested*/
		
		if (this.patients.containsKey(id)) 
		{
			patients.remove(id);
			return true;
		}
		
		else
			return false;
	}
	
	public boolean search(String id) { 
		/*tested*/
		
		if(patients.containsKey(id)) 
			return true;
		return false;
	}
	
	public Patient getItem(String patientId) { 
		/*tested*/

		if (search(patientId))
			return this.patients.get(patientId);
			
		else 
			return null;
	}
	
	public LocalDate getFirstRecord() { 
		/*tested*/
		
		Set<Map.Entry<LocalDate, StatisitcalData>> entries = stats.entrySet();
		Iterator<Map.Entry<LocalDate, StatisitcalData>> iterator = entries.iterator();
		if(entries.isEmpty())
			return null;
		return iterator.next().getKey();
	}
	
	
	public StatisitcalData getAvgRecords() { 
		/*tested*/
		
		StatisitcalData total = new StatisitcalData(), current = new StatisitcalData();
		if (stats.size() != 0)
		{
			int size = stats.size();
			for (LocalDate Key : stats.keySet()){
				current = stats.get(Key);
				total.addtotalDailylabs(current.getTotalDailylabs());
				total.addtotalDailyPatients(current.getTotalDailyPatients());
				total.addtotalDailySubs(current.getTotalDailySubs());
				total.addtotalVisitTime(current.getTotalVisitTime());
			}			
			total.setTotalDailylabs(total.getTotalDailylabs()/size);
			total.setTotalDailyPatients(total.getTotalDailyPatients()/size);
			total.setTotalDailySubs(total.getTotalDailySubs()/size);
			total.setTotalVisitTime(total.getTotalVisitTime()/size);
		}
		else
		{
			total.setTotalDailylabs(0);
			total.setTotalDailyPatients(0);
			total.setTotalDailySubs(0);
			total.setTotalVisitTime(0);
		}
		
		return total;
	}
	
	
	
	public void updatePatientInfo(String patientId, int phone,int age, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases) {
		/*tested*/
		
		if (this.patients.containsKey(patientId)) {
			patients.get(patientId).updatePatientInfo(phone, age, email, weight, height, gender, allergies, subscriptions, chronic_diseases);
		}
	}
	 
	public boolean createMedicalRecord(String patientId, MedicalRecord newRecord) {		
		/*tested*/
		
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
	
	public HashMap<String, Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(HashMap<String, Patient> tempPatients) {
		patients = tempPatients;
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
}

