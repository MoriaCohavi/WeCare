package Model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Manager extends User implements java.io.Serializable, CommandInterface {
	
	private HashMap<String, Doctor> doctors;
	private double avgVisitTime;
	private double avgDailyPatients;
	private double avgDailylabs;
	private double avgDailySubs;
	private LocalDateTime statsFlag;
	private StatisitcalData stats;

	public Manager(String id, long phone, String name, String email,String password,String user_type) {
		super(id,phone,name, email, password, user_type);
		doctors  = new HashMap <String, Doctor>();
		setAvgVisitTime(0);
		setAvgDailyPatients(0);
		setAvgDailylabs(0);
		setAvgDailySubs(0);
		stats = new StatisitcalData();
		statsFlag = null;
	}
	
	public String getID() {
		return this.getId();
		
	}
	
	public long getPhone() {
		return this.getPhone();
	}
	
	public String getName() {
		return this.getName();
	}
	
	public String getEmail() {
		return this.getEmail();
	}
	
	public void updatePhone(int newPhone){
		this.setPhone(newPhone);
	}

	public void updateEmail(String newEmail){
		this.setEmail(newEmail);
	}
	public double getAvgVisitTime() {
		return avgVisitTime;
	}

	public void setAvgVisitTime(double avgVisitTime) {
		this.avgVisitTime = avgVisitTime;
	}

	public double getAvgDailyPatients() {
		return avgDailyPatients;
	}

	public void setAvgDailyPatients(double avgDailyPatients) {
		this.avgDailyPatients = avgDailyPatients;
	}

	public double getAvgDailylabs() {
		return avgDailylabs;
	}

	public void setAvgDailylabs(double avgDailylabs) {
		this.avgDailylabs = avgDailylabs;
	}

	public double getAvgDailySubs() {
		return avgDailySubs;
	}

	public void setAvgDailySubs(double avgDailySubs) {
		this.avgDailySubs = avgDailySubs;
	
	}
	
	public LocalDateTime getStatsFlag() {
		return statsFlag;
	}

	public void setStatsFlag(LocalDateTime currnet) {
		this.statsFlag = currnet;
	
	}
	
	public StatisitcalData getStats() {
		return stats;
	}

	public void setStats(StatisitcalData stats) {
		this.stats = stats;
	}
	
	public boolean search(String id) {
		
		if(doctors.containsKey(id)) 
			return true;
		return false;
			
	}
	
	public boolean add(Object obj) {
		
		Doctor newDoc = (Doctor)obj;
		if (!search(newDoc.getName()))
		{
			doctors.put(newDoc.getDoctorID(), newDoc);
			return true;
		}
		return false;
		
	}
	
	public boolean remove(String id) {
			
			if (search(id)) {
				doctors.remove(id);
				return true;
			}
			
			return false;		
			
	}
	
	public void deleteOldStats() {
		for(String Key : this.doctors.keySet()) {
			if( doctors.get(Key).getFirstRecord().isBefore(LocalDate.now().minusMonths(1)))
				doctors.remove(Key);
		}
	
	}
	
	public void calcStats() {
		
		deleteOldStats();
		int doctorsCount = doctors.size();
		double tTime = 0, tSub =0, tPatient = 0, tLabs = 0;
		StatisitcalData current = new StatisitcalData();
		for (String Key : this.doctors.keySet()) {
			current = doctors.get(Key).getAvgRecords();
			tTime += current.getTotalVisitTime();
			tSub += current.getTotalDailySubs();
			tPatient += current.getTotalDailyPatients();
			tLabs += current.getTotalDailylabs();
		}
		
		this.setAvgDailylabs(tLabs/doctorsCount);
		this.setAvgDailyPatients(tPatient/doctorsCount);
		this.setAvgDailySubs(tSub/doctorsCount);
		this.setAvgVisitTime(tTime / doctorsCount);
		
	}
}
