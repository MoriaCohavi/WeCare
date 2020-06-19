package Model;

public class StatisitcalData implements java.io.Serializable {
	
	private double totalDailyPatients;
	private double totalDailylabs;
	private double totalDailySubs;
	
	
	public StatisitcalData() {
		this.totalDailyPatients = 0.0;
		this.totalDailylabs = 0.0;
		this.totalDailySubs = 0.0;
	}
	
	
	public void addtotalDailyPatients(double num) 
	/*tested*/
	{
		this.totalDailyPatients +=num;
	}
	
	public void addtotalDailylabs(double num) 
	/*tested*/
	{
		this.totalDailylabs +=num;
	}
	
	public void addtotalDailySubs(double num) 
	/*tested*/
	{
		this.totalDailySubs +=num;
	}
	

	public double getTotalDailyPatients() {
		return totalDailyPatients;
	}


	public void setTotalDailyPatients(double totalDailyPatients) {
		this.totalDailyPatients = totalDailyPatients;
	}


	public double getTotalDailylabs() {
		return totalDailylabs;
	}


	public void setTotalDailylabs(double totalDailylabs) {
		this.totalDailylabs = totalDailylabs;
	}


	public double getTotalDailySubs() {
		return totalDailySubs;
	}


	public void setTotalDailySubs(double totalDailySubs) {
		this.totalDailySubs = totalDailySubs;
	}



}
