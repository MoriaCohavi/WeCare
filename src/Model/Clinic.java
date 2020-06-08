package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clinic implements java.io.Serializable {
	private static Clinic instance;
	
	private String city;
	private long id;
		
	private Clinic(String city, long cId) {
		this.city = city;
		this.id = cId;		
	}
	
	public String getCity() {
		return city;
	}
	
	public long getId() {
		return id;
	}

	public static Clinic getInstance(String city, long cId) {
		if(instance == null)
		{
			instance = new Clinic(city, cId);
		}
		return instance;
	}
}
