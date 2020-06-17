package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Manager extends User implements java.io.Serializable, CommandInterface {
	
	private static HashMap<String, Doctor> doctors;
	private LocalDateTime statsFlag;
	private StatisitcalData stats;

	public Manager(String id, long phone, String name, String email,String password,String user_type) {
		super(id,phone,name, email, password, user_type);
		doctors  = new HashMap <String, Doctor>();
		stats = new StatisitcalData();
		statsFlag = null;
	}
	
	public String getID() {
		return super.getId();
		
	}
	
	public long getPhone() {
		return super.getPhone();
	}
	
	public String getName() {
		return super.getName();
	}
	
	public String getEmail() {
		return super.getEmail();
	}
	
	public void updatePhone(int newPhone){
		this.setPhone(newPhone);
	}

	public void updateEmail(String newEmail){
		this.setEmail(newEmail);
	}
	public double getAvgVisitTime() {
		return stats.getTotalVisitTime();
	}

	public double getAvgDailyPatients() {
		return stats.getTotalDailyPatients();
	}

	public double getAvgDailylabs() {
		return stats.getTotalDailylabs();
	}


	public double getAvgDailySubs() {
		return stats.getTotalDailySubs();
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
	
	public Doctor getItem(String doctorId) {
		
		if (search(doctorId))
			return this.doctors.get(doctorId);
			
		else 
			return null;
	}
	
	public boolean add(Object obj) {
		
		Doctor newDoc = (Doctor)obj;
		if (!search(newDoc.getId()))
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
		int doctorsCount;
		if (doctors.size() == 0)
			doctorsCount =1;
		else doctorsCount =  doctors.size();
		double tTime = 0, tSub =0, tPatient = 0, tLabs = 0;
		StatisitcalData current = new StatisitcalData();
		for (String Key : this.doctors.keySet()) {
			current = doctors.get(Key).getAvgRecords();
			tTime += current.getTotalVisitTime();
			tSub += current.getTotalDailySubs();
			tPatient += current.getTotalDailyPatients();
			tLabs += current.getTotalDailylabs();
		}
		
		this.stats.setTotalDailylabs(tLabs/doctorsCount);
		this.stats.setTotalDailyPatients(tPatient/doctorsCount);
		this.stats.setTotalDailySubs(tSub/doctorsCount);
		this.stats.setTotalVisitTime(tTime / doctorsCount);	
	}
	
	public boolean updateDoctorInfo(String patientId, String email, long phone) {
		/*tested*/
		
		if (this.doctors.containsKey(patientId) && Authentication.updateDoctorInfo(patientId, email, phone)) 
		{
			doctors.get(patientId).setEmail(email);
			doctors.get(patientId).setPhone(phone);
			return true;
		}
		
		return false;
		

		
	}
}
