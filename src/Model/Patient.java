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
	private String gender, allergies, Chronic_diseases, subscriptions;
	private HashMap<Integer, MedicalRecord> medicalRecords;
	private ArrayList<Lab> labs;
	
	public Patient(String id, int phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions) {
		super(id, phone, name, email);
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.allergies = allergies;
		this.subscriptions = subscriptions;
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
		Chronic_diseases = chronic_diseases;
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
		return Chronic_diseases;
	}

	public String getGender() {
		return gender;
	}

	public String getSubscriptions() {
		return subscriptions;
	}

	public void updatePatientInfo(int phone, String email, int weight, int height, String gender, String allergies, String subscriptions)
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
				
	}
		

	public void addLab(Lab newLab) {

		this.labs.add(newLab);
		
	}
	
	public void addMedicalRecord (MedicalRecord newRecord) {
		recordCount++;
		medicalRecords.put(recordCount, newRecord);
	
	}	
	
	public String medicalSummary() { 
		
		return null;
		
	}
	public boolean serialize()
	{
		try {
		FileOutputStream fileOut = new FileOutputStream("src\\Model\\files\\patient.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
		oos.writeObject(this);
		oos.close();
		fileOut.close();
		return true;
		}
		catch (IOException i)
		{
			i.printStackTrace();
			return false;
		}
		
	}
	
	public Patient deserialize()
	{
		try {
			FileInputStream fileIn = new FileInputStream("src\\Model\\files\\patient.ser");
			ObjectInputStream ois = new ObjectInputStream(fileIn);
			Patient patient = (Patient) ois.readObject();
			ois.close();
			fileIn.close();
			return patient;
		}
		catch (IOException i)
		{
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
