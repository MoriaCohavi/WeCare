package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Lab implements java.io.Serializable {
	
	private final String labType;
	private String result;
	private boolean attentionRequired = false;
	private final String patientId;
	
	public Lab(String type, String result, boolean attentionRequired, String patId) {
		this.labType = type;
		this.result = result;
		this.attentionRequired = false;
		this.patientId = patId;
	}
	
	/**getters and setters**/
	
	private void setResult(String resultUpdate){
		this.result = resultUpdate;
		
	}
	
	private void setAttentionRequired(boolean attention){
		this.attentionRequired = attention;
	}
	
	public String getLabType(){
		return this.labType;
		
	}
	
	public String getResult(){
		return this.result;
		
	}
	
	public boolean getAttentionRequired(){
		return this.attentionRequired;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	/**methods**/
	
	public void updateResults(String result, boolean attention) 
	{
		this.setResult(result);
		this.setAttentionRequired(attention);
	}


	
}