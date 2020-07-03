package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient extends Person implements java.io.Serializable{

	private static int recordCount = 0;
	private static int labsCount = 0;
	private int age, weight, height;
	private String gender, allergies, chronic_diseases, subscriptions, doctorId;
	private static HashMap<Integer, MedicalRecord> medicalRecords = new HashMap<Integer, MedicalRecord>();
	private static HashMap<Integer, Lab> labs = new HashMap<Integer, Lab>();
	
	public Patient(String id,int age, long phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases, String docId) {
		super(id, phone, name, email);
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.gender = gender;
		this.allergies = allergies;
		this.subscriptions = subscriptions;
		this.chronic_diseases = chronic_diseases;
		this.doctorId = docId;
	}
	
	/**getters and setters**/

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public void setChronic_diseases(String chronic_diseases) {
		this.chronic_diseases = chronic_diseases;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	public static int getRecordsCounter()
	{
		return recordCount;
	}
	
	public static void setRecordsCounter(int counter)
	{
		recordCount = counter;
	}
	
	public static void setLabsCounter(int counter)
	{
		labsCount = counter;
	}

	public int getAge() {
		return this.age;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getHeight() {
		return this.height;
	}


	public String getAllergies() {
		return allergies;
	}
	
	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public static HashMap<Integer, MedicalRecord> getMedicalRecords()
	{
		return medicalRecords;
	}
	
	public static void setMedicalRecords(HashMap<Integer, MedicalRecord> tempRecords)
	{
		medicalRecords = tempRecords;
	}
	
	public int getRecordCounter () {
		return recordCount;
	}

	public String getChronic_diseases() {
		return chronic_diseases;
	}

	public String getGender() {
		return gender;
	}

	public String getSubscriptions() {
		return subscriptions;
	}
	
	/**methods**/

	public MedicalRecord getMedicalRecord(int id, String patientId, String docId) 
	{
		for (Integer key : medicalRecords.keySet()) {
			if (key == id) {
				if (medicalRecords.get(key).get_PatientId().equals(patientId)&& medicalRecords.get(id).get_DoctorId().equals(docId))
					return medicalRecords.get(id);
			} 
		}
		return null;
		
	}
	

	public void updatePatientInfo(int phone,int age, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases)
	{
		if(this.getPhone() != phone)
			this.setPhone(phone);
		
		if(this.getEmail() != email)
			this.setEmail(email);
		
		if(this.weight != weight)
			this.weight=weight;
		
		if(this.height != height)
			this.height=height;
		
		if(this.gender != gender)
			this.gender=gender;
		
		if(this.allergies != allergies)
			this.allergies=allergies;
		
		if(this.subscriptions != subscriptions)
			this.subscriptions=subscriptions;
		
		if(this.age != age)
			this.age = age;
		
		if(this.chronic_diseases != chronic_diseases)
			this.chronic_diseases = chronic_diseases;
				
	}
		

	public boolean addLab(Lab newLab) 
	{
			labs.put(++labsCount ,newLab);				
			return true;
	}
	
	public static boolean setLabs(HashMap<Integer, Lab> labMap) 
	{
			labs = labMap;				
			return true;
	}
	
	public static HashMap<Integer, Lab>  getLabs() 
	{
		return labs;
	}
	
	public boolean addMedicalRecord (MedicalRecord newRecord) 
	{
		
		if (medicalRecords.put(++recordCount, newRecord) == null)
			return true;
		
		return false;
	}



	 
}
