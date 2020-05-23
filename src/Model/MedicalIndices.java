package Model;

public class MedicalIndices {
	private int weight = 0, height =0, heartRate =0, temperature =37, systolicBP =0,diastolicBP=0;
	
	
	private void setWeight(int wParmeter) {
		this.weight = wParmeter;
			
	}
		
	private void setHeight(int hrParmeter) {
		this.height = hrParmeter;
	}
	
	private void setHeartRate(int hParmeter) {
		this.heartRate = hParmeter;
	}
		
	private void setTemperature (int tParmeter) {
		this.temperature = tParmeter;
	}
	
	private void setSystolicBP (int sbpParmeter) {
		this.systolicBP = sbpParmeter;
	}
	
	private void setDiastolicBP (int dbpParmeter) {
		this.diastolicBP = dbpParmeter;
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
	
	public void setMedicalIndices (int w, int h, int hr, int t, int sysBP, int diaBP)
	{
		this.setWeight(w);
		this.setHeight(h);
		this.setHeartRate(hr);
		this.setTemperature(t);
		this.setSystolicBP(sysBP);
		this.setDiastolicBP(diaBP);
	}
	
	public MedicalIndices getMedicalIndices ()
	{
		return this;
	}

}