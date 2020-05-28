package Model;

public class Lab {
	
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
}