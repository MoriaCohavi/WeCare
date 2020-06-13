package Model;

public class StatisitcalData {
	
	private double totalVisitTime;
	private int totalDailyPatients;
	private int totalDailylabs;
	private int totalDailySubs;
	
	
	public StatisitcalData() {
		this.totalVisitTime = 0;
		this.totalDailyPatients = 0;
		this.totalDailylabs = 0;
		this.totalDailySubs = 0;
	}
	
	
	public void addtotalVisitTime(double num) {
		this.totalVisitTime +=num;
	}
	
	public void addtotalDailyPatients(int num) {
		this.totalDailyPatients +=num;
	}
	
		public void addtotalDailylabs(int num) {
		this.totalDailylabs +=num;
	}
	
	public void addtotalDailySubs(int num) {
		this.totalDailySubs +=num;
	}
	


	public double getTotalVisitTime() {
		return totalVisitTime;
	}


	public void setTotalVisitTime(double totalVisitTime) {
		this.totalVisitTime = totalVisitTime;
	}


	public int getTotalDailyPatients() {
		return totalDailyPatients;
	}


	public void setTotalDailyPatients(int totalDailyPatients) {
		this.totalDailyPatients = totalDailyPatients;
	}


	public int getTotalDailylabs() {
		return totalDailylabs;
	}


	public void setTotalDailylabs(int totalDailylabs) {
		this.totalDailylabs = totalDailylabs;
	}


	public int getTotalDailySubs() {
		return totalDailySubs;
	}


	public void setTotalDailySubs(int totalDailySubs) {
		this.totalDailySubs = totalDailySubs;
	}


	

	

}
