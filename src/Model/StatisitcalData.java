package Model;

public class StatisitcalData implements java.io.Serializable {
	
	private double totalVisitTime;
	private double totalDailyPatients;
	private double totalDailylabs;
	private double totalDailySubs;
	
	
	public StatisitcalData() {
		this.totalVisitTime = 0.0;
		this.totalDailyPatients = 0.0;
		this.totalDailylabs = 0.0;
		this.totalDailySubs = 0.0;
	}
	
	
	public void addtotalVisitTime(double num) {
		this.totalVisitTime +=num;
	}
	
	public void addtotalDailyPatients(double num) {
		this.totalDailyPatients +=num;
	}
	
		public void addtotalDailylabs(double num) {
		this.totalDailylabs +=num;
	}
	
	public void addtotalDailySubs(double num) {
		this.totalDailySubs +=num;
	}
	


	public double getTotalVisitTime() {
		return totalVisitTime;
	}


	public void setTotalVisitTime(double totalVisitTime) {
		this.totalVisitTime = totalVisitTime;
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
