package Model;

public class Person {
	private final String id;
	private int phone;
	private final String name;
	private String email;

	public Person(String id, int phone, String name, String email) {
		
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.email = email;
	}


	public String getId() {
		return this.id;
		
	}
	
	public int getPhone() {
		return this.phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPhone(int phone)
	{
		this.phone = phone;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
