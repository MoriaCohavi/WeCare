package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Lab implements java.io.Serializable {
	
	private String labType;
	private String patientId;
	private String result;
	private boolean attentionRequired = false;
	
	
	private void setLabType(String lab){
		this.labType = lab;
		
	}
	
	private void setPatientId(String ID){
		this.patientId = ID;
		
	}
	
	private void setResult(String resultUpdate){
		this.result = resultUpdate;
		
	}
	
	private void setAttentionRequired(boolean attention){
		this.attentionRequired = attention;
	}
	
	public String getLabType(){
		return this.labType;
		
	}
	
	public String getPatientId(){
		return this.patientId;
		
	}
	
	public String getResult(String resultUpdate){
		return this.result;
		
	}
	
	public boolean getAttentionRequired(){
		return this.attentionRequired;
	}
	
	
	
	public void updateResults(String lab, String id, String result2, boolean attention) {
		this.setLabType(lab);
		this.setPatientId(id);
		this.setResult(result);
		this.setAttentionRequired(attention);
		if (this.attentionRequired)
			this.sendAttentionAlert();
	}
	
	//we need to change this based on what we implement in the UI for attention alerts/table.
	private void sendAttentionAlert() {
		System.out.println("attention!");
	}
	
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("/files/lab.ser");
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
	          FileInputStream fileIn = new FileInputStream("/files/lab.ser");
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