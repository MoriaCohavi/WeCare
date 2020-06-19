package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Person implements java.io.Serializable {
	private final String id;
	private long phone;
	private final String name;
	private String email;

	public Person(String id, long phone, String name, String email) {
		
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.email = email;
	}


	public String getId() {
		return this.id;
		
	}
	
	public long getPhone() {
		return this.phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPhone(long phone)
	{
		this.phone = phone;
	}
	
	public void setEmail(String email)
	{
		this.email = email; 
	}
}
