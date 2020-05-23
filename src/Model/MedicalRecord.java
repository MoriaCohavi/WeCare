package Model;
import java.time.*;

public class MedicalRecord {
	
	private LocalDate currentDate;
	private LocalTime sTime, eTime;
	private int recordId, daysOfIllnessApproval;
	private String doctorId, visitPurpose, visitDescription, diagnoseDiscription, visitSummary, subscriptions;
	private MedicalIndices pateintIndices;
	
	//setters
	private void set_Date() {
		this.currentDate = LocalDate.now();
	}
	
	private void set_STime() {
		this.sTime = LocalTime.now();
	}
	
	private void set_ETime() {
		this.eTime = LocalTime.now();
	}
	
	public void set_RecordId(int recordId) {
		this.recordId = recordId;
	}
	
	public void set_DaysOfIllnessApproval(int numDays) {
		this.daysOfIllnessApproval = numDays;
	}
	
	public void set_DoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public void set_VisitPurpose(String purpose) {
		this.visitPurpose = purpose;
	}
	
	public void set_VisitDescription(String description) {
		this.visitDescription = description;
	}
	
	public void set_DiagnoseDiscription(String description) {
		this.diagnoseDiscription = description;
	}
	
	public void set_VisitSummary(String summary) {
		this.visitSummary = summary;
	}
	
	public void set_subscriptions(String sub) {
		this.subscriptions = sub;
	}
	public void set_pateintIndices(int w, int h, int hr, int t, int sysBP, int diaBP) {
		this.pateintIndices.setMedicalIndices(w, h, hr, t, sysBP, diaBP);
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
		
	public void addMedicalRecord(String doctorId,int numDays, int recordId, String purpose, String description, String summary, String sub,
			int w, int h, int hr, int t, int sysBP, int diaBP ) {
		
		this.set_DoctorId(doctorId);
		this.set_RecordId(recordId);
		this.set_Date();
		this.set_STime();
		this.set_pateintIndices(w, h, hr, t, sysBP, diaBP);
		this.set_VisitPurpose(purpose);
		this.set_VisitDescription(description);
		this.set_DiagnoseDiscription(description);
		this.set_VisitSummary(summary);
		this.set_subscriptions(sub);
		this.set_DaysOfIllnessApproval(numDays);
	}
	
	public void saveMedicalRecord() {
		this.set_ETime();
	}
	
	public MedicalRecord get_MedicalRecord(int record) {
		
		if (this.get_RecordId() == record)
			return this;
		else 
			return null;
		
	}
	
	
	public String exportVisitSummary() {
		String export = "";
		export.concat( get_Date() +"\\" +get_VisitSummary() +"\\" + get_DaysOfIllnessApproval());
			
		return export;
	}

}
