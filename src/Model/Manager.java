package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Manager extends User implements java.io.Serializable, CommandInterface {
	
	private static HashMap<String, Doctor> doctors = new HashMap <String, Doctor>();
	private static LocalDateTime statsFlag = null;
	private static StatisitcalData stats = new StatisitcalData();

	public Manager(String id, long phone, String name, String email,String password,String user_type) {
		super(id,phone,name, email, password, user_type);
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
		statsFlag = currnet;
	
	}
	
	public StatisitcalData getStats() {
		return stats;
	}

	public void setStats(StatisitcalData newStats) {
		stats = newStats;
	}
	

	public void setDoctors(HashMap<String, Doctor>  newDoctors) {
		doctors = newDoctors;
	}
	
	public static HashMap<String, Doctor>  getDoctors() {
		return doctors;
	}
	
	public boolean search(String id) 
	/*tested*/
	{
		
		if(doctors.containsKey(id) && this.getID().equals(doctors.get(id).getManagerID())) 
			return true;
		return false;
	}
	
	public Doctor getItem(String doctorId) 
	/*tested*/
	{
		
		if (search(doctorId))
			return doctors.get(doctorId);
			
		else 
			return null;
	}
	
	public boolean add(Object obj) 
	/*tested*/
	{
		Doctor newDoc = (Doctor)obj;
		if (!search(newDoc.getId()))
		{
			doctors.put(newDoc.getDoctorID(), newDoc);
			return true;
		}
		
		return false;
	}
	
	public boolean remove(String id) 
	/*tested*/
	{
			
		if (search(id)) {
			doctors.remove(id);
			return true;
		}
		
		return false;		
	}
	
	private void deleteOldStats() 
	
	{
		for(String Key : this.doctors.keySet()) {
			if( doctors.get(Key).getFirstRecord()!= null && 
					doctors.get(Key).getFirstRecord().isBefore(LocalDate.now().minusMonths(1)))
				doctors.remove(Key);
		}
	}
	
	public void calcStats() 
	/*tested*/
	{
		
		deleteOldStats();
		int doctorsCount;
		if (doctors.size() == 0)
			doctorsCount =1;
		else doctorsCount =  doctors.size();
		double tSub =0, tPatient = 0, tLabs = 0, tRecords = 0;
		StatisitcalData current = new StatisitcalData();
		for (String doctorKey : doctors.keySet()) {
			if (this.getId().equals(doctors.get(doctorKey).getManagerID())) {
				current = doctors.get(doctorKey).getAvgRecords();
				tSub += current.getTotalDailySubs();
				tPatient += current.getTotalDailyPatients();
				tLabs += current.getTotalDailylabs();
							
			}
		}
		
		this.stats.setTotalDailylabs(tLabs/doctorsCount);
		this.stats.setTotalDailyPatients(tPatient/doctorsCount);
		this.stats.setTotalDailySubs(tSub/doctorsCount);
			
	}
	
	public boolean updateDoctorInfo(String docId, String email, long phone) {
		/*tested*/
		
		if (search(docId) && Authentication.updateDoctorInfo(docId, email, phone)) 
		{
			doctors.get(docId).setEmail(email);
			doctors.get(docId).setPhone(phone);
			return true;
		}
		
		return false;
		

		
	}
}
