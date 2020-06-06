package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MedicalIndices implements java.io.Serializable {
	private final int weight, height, heartRate, temperature, systolicBP,diastolicBP;

	
	public MedicalIndices (int w, int h, int hR, int t, int sBP, int dBP) {
		
		this.weight = w;
		this.height = h;
		this.heartRate = hR;
		this.temperature = t;
		this.systolicBP =sBP;
		this.diastolicBP = dBP;
		
	}

	
	public int getWeight() {
		return this.weight;
			
	}
		
	public int getHeight(){
		return this.height;
	}
	
	public int getHeartRate() {
		return this.heartRate;
	}
		
	public int getTemperature () {
		return this.temperature;
	}
	
	public int getSystolicBP() {
		return this.systolicBP;
	}
	
	public int getDiastolicBP () {
		return this.diastolicBP;
	}

	
	public MedicalIndices getMedicalIndices ()
	{
		return this;
	}
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("/files/medicalIndices.ser");
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
	
	public User deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("/files/medicalIndices.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          User e = (User) in.readObject();
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