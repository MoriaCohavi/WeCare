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
	
	public Lab (String type, String result, boolean attentionRequired) {
		this.labType = type;
		this.result = result;
		this.attentionRequired = false;
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
	
	
	public String getResult(){
		return this.result;
		
	}
	
	public boolean getAttentionRequired(){
		return this.attentionRequired;
	}
	
	
	
	public void updateResults(String result, boolean attention) 
	/*test*/
	{
		this.setResult(result);
		this.setAttentionRequired(attention);
		if (this.attentionRequired)
			this.sendAttentionAlert();
	}
	
	//we need to change this based on what we implement in the UI for attention alerts/table.
	private void sendAttentionAlert() {
		//System.out.println("attention!");
	}
	
	public boolean serialize()
	{
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("src\\Model\\files\\lab.ser");
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
	
	public Lab deserialize()
	{
	      try {
	          FileInputStream fileIn = new FileInputStream("src\\Model\\files\\lab.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          Lab e = (Lab) in.readObject();
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