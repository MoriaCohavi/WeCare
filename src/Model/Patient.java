package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient extends Person implements java.io.Serializable{

	private int age, weight, height, recordCount;
	private String gender, allergies, chronic_diseases, subscriptions;
	private HashMap<Integer, MedicalRecord> medicalRecords;
	private ArrayList<Lab> labs;
	
	public Patient(String id,int age, long phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions, String chronic_diseases) {
		super(id, phone, name, email);
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.gender = gender;
		this.allergies = allergies;
		this.subscriptions = subscriptions;
		this.chronic_diseases = chronic_diseases;
		this.recordCount = 0;
		this.medicalRecords = new HashMap<Integer, MedicalRecord>();
		this.labs = new ArrayList<Lab>();
	}
	

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

	public MedicalRecord getMedicalRecord(int id) {
		
		return medicalRecords.get(id);
		
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
		

	public boolean addLab(Lab newLab) {

		return this.labs.add(newLab);
		
	}
	
	public void addMedicalRecord (MedicalRecord newRecord) {
		recordCount++;
		medicalRecords.put(recordCount, newRecord);
	
	}	
	
	public String medicalSummary() { 
		
		return null;
		
	}
}
