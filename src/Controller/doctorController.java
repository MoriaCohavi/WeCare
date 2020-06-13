package Controller;

import java.time.LocalTime;

import Model.Doctor;
import Model.MedicalRecord;
import Model.Patient;

public class doctorController {
	public static String serPath = "src\\Model\\files\\doctor.ser";
	private Doctor currentModelDoctor;
	//private doctor view implementation
	
	public doctorController(String id, int phone, String name, String email, String special,String password,String user_type) { // needs to include doctorview obj
			this.currentModelDoctor = new Doctor (id, phone, name, email, special,password,user_type);
	}
	
	public boolean addNewPatient (String id, int phone, String name, String email, int weight, int height, String gender, String allergies, String subscriptions) {
		
		Patient newPatient = new Patient(id, phone, name, email, weight, height, gender, allergies, subscriptions);
		if (currentModelDoctor.add(newPatient))
			return true;

		return false;	
	}
	
	public boolean deletePatient (String patientId) {
		
		if (currentModelDoctor.remove(patientId))
			return true;
		
		return false;	
	}
	
	
	
	/*public String viewPatientInfo (String patientId) {
		
		return currentModelDoctor.getPatient(patientId).getPatientInfo();
	}*/
	
	
	public MedicalRecord viewMedicalRecord (String patientId, int recordId) {
		
		return currentModelDoctor.getPatient(patientId).getMedicalRecord(recordId);
		
	}
	
	public Patient openPatientFile (String patientId) {
		
		return currentModelDoctor.getPatient(patientId);
	}
	
	
	
	
	public boolean openNewMedicalRecord (String patientId, int days, String purpose, String description, String summary,
			String sub, String diagnose, LocalTime sT, LocalTime eT, int w, int h, int hr, int t, int sysBP, int diaBP) {
		
		if (currentModelDoctor.search(patientId)){
			
			int record = currentModelDoctor.getPatient(patientId).getRecordCounter() + 1;
			
			MedicalRecord newRecord = new MedicalRecord(currentModelDoctor.getDoctorID(), days, record, purpose,description, summary, sub,diagnose, sT, eT, w, h, hr, t, sysBP, diaBP) ;
			
			currentModelDoctor.getPatient(patientId).addMedicalRecord(newRecord);
			return true;
		}
		
		else return false;
		
	}
 
	public void serialize(serHandlerController handler)
	{
		handler.serialize(currentModelDoctor, serPath);
	}
	
	public void deserialize(serHandlerController handler)
	{
		currentModelDoctor = (Doctor)handler.deserialize(serPath);
	}


}