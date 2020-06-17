package View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controller.doctorController;
import Model.*;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientDetailsView {

	private doctorController docCtrl;
	private JFrame frmPatient;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtAllergies;
	private JTextField txtCronicDiseases;
	private JTextField txtSubsriptions;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientDetailsView window = new PatientDetailsView();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PatientDetailsView(Doctor doctor, String patientId) {
		initialize(doctor, patientId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Doctor doctor, String patientId) {
		docCtrl = new doctorController(doctor);
		frmPatient = new JFrame();
		frmPatient.setTitle("Patient Details");
		frmPatient.setBounds(100, 100, 570, 600);
		frmPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatient.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(40, 45, 160, 15);
		frmPatient.getContentPane().add(lblName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(40, 80, 160, 15);
		frmPatient.getContentPane().add(lblID);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 115, 160, 15);
		frmPatient.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(38, 149, 160, 15);
		frmPatient.getContentPane().add(lblPhone);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(38, 189, 160, 15);
		frmPatient.getContentPane().add(lblAge);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(38, 224, 160, 15);
		frmPatient.getContentPane().add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(38, 259, 160, 15);
		frmPatient.getContentPane().add(lblWeight);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(38, 294, 160, 15);
		frmPatient.getContentPane().add(lblAllergies);
		
		JLabel lblCronicDiseases = new JLabel("Cronic Diseases");
		lblCronicDiseases.setBounds(38, 325, 160, 15);
		frmPatient.getContentPane().add(lblCronicDiseases);
		
		JLabel lblSubsriptions = new JLabel("Subsriptions");
		lblSubsriptions.setBounds(38, 356, 160, 15);
		frmPatient.getContentPane().add(lblSubsriptions);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(38, 382, 160, 15);
		frmPatient.getContentPane().add(lblGender);
		
		txtName = new JTextField(docCtrl.getPatientName(patientId));
		txtName.setBounds(250, 45, 160, 15);
		frmPatient.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField(patientId);
		txtID.setColumns(10);
		txtID.setBounds(250, 80, 160, 15);
		frmPatient.getContentPane().add(txtID);
		
		txtEmail = new JTextField(docCtrl.getPatientEmail(patientId));
		txtEmail.setColumns(10);
		txtEmail.setBounds(250, 115, 160, 15);
		frmPatient.getContentPane().add(txtEmail);
		
		txtPhone = new JTextField(String.valueOf(docCtrl.getPatientPhone(patientId)));
		txtPhone.setColumns(10);
		txtPhone.setBounds(248, 149, 160, 15);
		frmPatient.getContentPane().add(txtPhone);
		
		txtAge = new JTextField(String.valueOf(docCtrl.getPatientAge(patientId)));
		txtAge.setColumns(10);
		txtAge.setBounds(248, 184, 160, 15);
		frmPatient.getContentPane().add(txtAge);
		
		txtHeight = new JTextField(String.valueOf(docCtrl.getPatientHeight(patientId)));
		txtHeight.setColumns(10);
		txtHeight.setBounds(248, 219, 160, 15);
		frmPatient.getContentPane().add(txtHeight);
		
		txtWeight = new JTextField(String.valueOf(docCtrl.getPatientWeight(patientId)));
		txtWeight.setColumns(10);
		txtWeight.setBounds(248, 254, 160, 15);
		frmPatient.getContentPane().add(txtWeight);
		
		txtAllergies = new JTextField(docCtrl.getPatientAllergic(patientId));
		txtAllergies.setColumns(10);
		txtAllergies.setBounds(248, 289, 160, 15);
		frmPatient.getContentPane().add(txtAllergies);
			
		txtCronicDiseases = new JTextField(docCtrl.getPatientChronicDiseases(patientId));
		txtCronicDiseases.setColumns(10);
		txtCronicDiseases.setBounds(248, 320, 160, 15);
		frmPatient.getContentPane().add(txtCronicDiseases);
		
		txtSubsriptions = new JTextField(docCtrl.getPatientSubscription(patientId));
		txtSubsriptions.setColumns(10);
		txtSubsriptions.setBounds(248, 350, 160, 15);
		frmPatient.getContentPane().add(txtSubsriptions);
		
		JButton btnEdit = new JButton("Save");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// bar
			}
		});
		btnEdit.setBounds(40, 441, 85, 21);
		frmPatient.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(139, 441, 85, 21);
		frmPatient.getContentPane().add(btnDelete);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(248, 377, 91, 29);
		frmPatient.getContentPane().add(rdbtnFemale);
		
		JRadioButton radioMale = new JRadioButton("Male");
		radioMale.setBounds(340, 377, 91, 29);
		frmPatient.getContentPane().add(radioMale);
		frmPatient.setVisible(true);
	}
}
