package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import Driver.MVCDriver;

public class Manager extends User implements java.io.Serializable, CommandInterface {
	
	private static HashMap<String, Doctor> doctors = new HashMap <String, Doctor>();
	private static LocalDateTime statsFlag = null;
	private static HashMap<LocalDate, StatisitcalData> statsDataDaily = new HashMap<LocalDate, StatisitcalData>();
	private static StatisitcalData monthlyData = new StatisitcalData("111111111");

	public Manager(String id, long phone, String name, String email,String password,String user_type) {
		super(id,phone,name, email, password, user_type);
	}
	
	/**getters and setters**/
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

	
	public LocalDateTime getStatsFlag() {
		return statsFlag;
	}

	public void setStatsFlag(LocalDateTime currnet) {
		statsFlag = currnet;
	
	}
	
	public StatisitcalData getStatsDataDaily(LocalDate date) {
		return statsDataDaily.get(date);
	}

	public HashMap<LocalDate, StatisitcalData> getStatsDataDaily() {
		return statsDataDaily;
	}
	
	public void setStatsDataDaily(HashMap<LocalDate, StatisitcalData> newStats) {
		statsDataDaily = newStats;
	}
	

	public void setDoctors(HashMap<String, Doctor>  newDoctors) {
		doctors = newDoctors;
	}
	
	public static HashMap<String, Doctor>  getDoctors() {
		return doctors;
	}
	

	public static StatisitcalData getMonthlyData() {
		return monthlyData;
	}

	public static void setMonthlyData(StatisitcalData monthlyData) {
		Manager.monthlyData = monthlyData;
	}
	
	
	/**methods**/
	
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
	
	private void deleteOldStats(String docId) 
	
	{
		HashMap<Integer, StatisitcalData> temp = Doctor.getStatsList();
		for (Integer key : temp.keySet()) {
			if (temp.get(key).getDoctorId().equals(docId) && temp.get(key).getDate().isBefore(LocalDate.now().minusMonths(1))) {
				Doctor.getStatsList().remove(key);
			}
				
		}
	}
	
	public void calcDailyStats() 
	/*tested*/
	{
		for(String docKey : doctors.keySet())
			deleteOldStats(docKey);
		
		int doctorsCount=0;
		if (doctors.size() != 0)
		{
			double tSub =0, tPatient = 0, tLabs = 0;
			for(String docKey : doctors.keySet())
				if(doctors.get(docKey).getManagerID().equals(this.getID())) {
					StatisitcalData current = doctors.get(docKey).getDailyAvgRecords(LocalDate.now(), docKey);
					tSub += current.getTotalDailySubs();
					tPatient += current.getTotalDailyPatients();
					tLabs += current.getTotalDailylabs();		
					doctorsCount++;
				}
			if (doctorsCount !=0) {
				if (statsDataDaily.get(LocalDate.now()) == null) 
					statsDataDaily.put(LocalDate.now(), new StatisitcalData(getID()));
				
				statsDataDaily.get(LocalDate.now()).setTotalDailylabs(tLabs/doctorsCount);
				statsDataDaily.get(LocalDate.now()).setTotalDailyPatients(tPatient/doctorsCount);
				statsDataDaily.get(LocalDate.now()).setTotalDailySubs(tSub/doctorsCount);
				
				}
			else
				statsDataDaily.put(LocalDate.now(), new StatisitcalData(getID()));
		}
		else
			statsDataDaily.put(LocalDate.now(), new StatisitcalData(getID()));
		
			
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
	
	
	public double getAvgDailyPatients(LocalDate date)
	/*tested*/
	{
		if (statsDataDaily.get(date)!=null)
			return statsDataDaily.get(date).getTotalDailyPatients();
		return 0;
	}

	public double getAvgDailylabs(LocalDate date)
	/*tested*/
	{
		if (statsDataDaily.get(date)!=null)
			return statsDataDaily.get(date).getTotalDailylabs();
		return 0;
	}


	public double getAvgDailySubs(LocalDate date) 
	/*tested*/
	{
		if (statsDataDaily.get(date)!=null)
			return statsDataDaily.get(date).getTotalDailySubs();
		return 0;
	}
}

