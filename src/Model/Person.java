package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Person implements java.io.Serializable {
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
	
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("/files/person.ser");
	          ObjectOutputStream out = new ObjectOutputStream(fileOut);
	          out.writeObject(this);
	          out.close();
	          fileOut.close();
	          return true;
	       } catch (IOException i) {
	          i.printStackTrace();
	          return false;
	       }
	}
	
	public Person deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("/files/person.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          Person e = (Person) in.readObject();
	          in.close();
	          fileIn.close();
	          return e;
	       } catch (IOException i) {
	          i.printStackTrace();
	          return null;
	       } catch (ClassNotFoundException c) {
	          c.printStackTrace();
	          return null;
	       }
	}
}
