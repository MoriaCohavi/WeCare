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
	private Manager manager;
		
	private Clinic(String city, long cId, String mId, long phone, String mName, String email, String password, String user_type) {
		this.city = city;
		this.id = cId;
		this.setManager(new Manager(mId, phone, mName, email, password, user_type));
	}
	
	/**getters and setters**/
	
	public String getCity() {
		return city;
	}
	
	public long getId() {
		return id;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager clinicManager) {
		this.manager = clinicManager;
	}
	
	/**methods**/
	
	public static Clinic getInstance(String city, long cId, String mId, long phone, String mName, String email, 
										String password, String user_type) {
		if(instance == null) {
			instance = new Clinic(city, cId, mId, phone, mName, email, password, user_type);
		}
		
		return instance;
	}
}
