package Model;

import java.time.*;

public class MedicalRecord {
	
	private final LocalDate currentDate;
	private final LocalTime sTime, eTime; // when opening page needs to save time & while saving needs to send time 
	private final String doctorId, visitPurpose, visitDescription, diagnoseDiscription, visitSummary;
	private final int recordId;
	private final MedicalIndices pateintIndices;
	private int daysOfIllnessApproval;
	private String subscriptions;
	
	
	public MedicalRecord(String doctor,int numDays, int record, String purpose, String description, String summary, String sub,
			String diagnose, LocalTime sT, LocalTime eT, int w, int h, int hr, int t, int sysBP, int diaBP ) {
		
		this.currentDate = LocalDate.now();
		this.doctorId = doctor;
		this.recordId = record;
		this.sTime = sT;
		this.eTime = eT;
		this.pateintIndices = new MedicalIndices (w,h,hr,t,sysBP, diaBP);
		this.visitDescription = description;
		this.visitPurpose= purpose;
		this.diagnoseDiscription  = diagnose;
		this.subscriptions = sub;
		this.daysOfIllnessApproval = numDays;
		this.visitSummary = summary;
	}
	
	//setters
	
	public void set_DaysOfIllnessApproval(int numDays) {
		this.daysOfIllnessApproval = numDays;
	}
	
	
	public void set_subscriptions(String sub) {
		this.subscriptions = sub;
	}
	
	
	
	//getters
	public LocalDate get_Date() {
		return currentDate;
	}
	
	public LocalTime get_STime() {
		return sTime;
	}
	
	public LocalTime get_ETime() {
		return eTime;
	}
	
	public int get_RecordId() {
		return recordId;
	}
	
	public int get_DaysOfIllnessApproval() {
		return daysOfIllnessApproval;
	}
	
	public String get_DoctorId() {
		return doctorId;
	}
	
	public String get_VisitPurpose() {
		return visitPurpose;
	}
	
	public String get_VisitDescription() {
		return visitDescription;
	}
	
	public String get_DiagnoseDiscription() {
		return diagnoseDiscription;
	}
	
	public String get_VisitSummary() {
		return visitSummary;
	}
	
	public String get_subscriptions() {
		return subscriptions;
	}
	
	public MedicalIndices get_pateintIndices() {
		return pateintIndices.getMedicalIndices();
	}
	
	//other methods
	
	public String exportVisitSummary() {
		String export = "";
		export.concat( get_Date() +"\\" +get_VisitSummary() +"\\" + get_DaysOfIllnessApproval());
			
		return export;
	}

}

