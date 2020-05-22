package weCare;

public class medicalIndices {
	private int weight, height, heartRate, temperature, systolicBP,diastolicBP;
	private double BMI;
	
	
	public void setWeight(int wParmeter) {
		this.weight = wParmeter;
			
	}
		
	public void setHeight(int hrParmeter) {
		this.height = hrParmeter;
	}
	
	public void setHeartRate(int hParmeter) {
		this.heartRate = hParmeter;
	}
		
	public void setTemperature (int tParmeter) {
		this.temperature = tParmeter;
	}
	
	public void setSystolicBP (int sbpParmeter) {
		this.systolicBP = sbpParmeter;
	}
	
	public void setDiastolicBP (int dbpParmeter) {
		this.diastolicBP = dbpParmeter;
	}
	
	public void setBMI() {
		this.BMI = weight / (height*height);
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
	
	public double getBMI() {
		return this.BMI;
	}
	

}
