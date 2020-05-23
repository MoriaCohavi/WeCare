package Model;

public class Patient extends Person{

	private int age;
	private int weight;
	private int height;
	private String gender;
	private String allergies;
	private String Chronic_diseases;
	private String subscriptions;
	//medical_records[]
	//lab[]
	
	public Patient(String id, int phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions /*,medical records, lab*/) {
		super(id, phone, name, email);
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.allergies = allergies;
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
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}


	public String getAllergies() {
		return allergies;
	}


	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}


	public String getChronic_diseases() {
		return Chronic_diseases;
	}


	public void setChronic_diseases(String chronic_diseases) {
		Chronic_diseases = chronic_diseases;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSubscriptions() {
		return subscriptions;
	}


	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
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
		
	
}
