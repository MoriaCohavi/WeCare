package View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PatientDetailsView {

	private JFrame frmPatient;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JTextField txtDailyHeight;
	private JTextField txtWeight;
	private JTextField txtAllergies;
	private JTextField txtCronicDiseases;
	private JTextField txtSubsriptions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientDetailsView window = new PatientDetailsView();
					window.frmPatient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientDetailsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(40, 150, 160, 15);
		frmPatient.getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(40, 185, 160, 15);
		frmPatient.getContentPane().add(lblPhone);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(40, 225, 160, 15);
		frmPatient.getContentPane().add(lblAge);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(40, 260, 160, 15);
		frmPatient.getContentPane().add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(40, 295, 160, 15);
		frmPatient.getContentPane().add(lblWeight);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(40, 330, 160, 15);
		frmPatient.getContentPane().add(lblAllergies);
		
		JLabel lblCronicDiseases = new JLabel("Cronic Diseases");
		lblCronicDiseases.setBounds(40, 361, 160, 15);
		frmPatient.getContentPane().add(lblCronicDiseases);
		
		JLabel lblSubsriptions = new JLabel("Subsriptions");
		lblSubsriptions.setBounds(40, 392, 160, 15);
		frmPatient.getContentPane().add(lblSubsriptions);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(40, 418, 160, 15);
		frmPatient.getContentPane().add(lblGender);
		
		txtName = new JTextField();
		txtName.setBounds(250, 45, 160, 15);
		frmPatient.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(250, 80, 160, 15);
		frmPatient.getContentPane().add(txtID);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(250, 115, 160, 15);
		frmPatient.getContentPane().add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(250, 150, 160, 15);
		frmPatient.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(250, 185, 160, 15);
		frmPatient.getContentPane().add(txtPhone);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(250, 220, 160, 15);
		frmPatient.getContentPane().add(txtAge);
		
		txtDailyHeight = new JTextField();
		txtDailyHeight.setColumns(10);
		txtDailyHeight.setBounds(250, 255, 160, 15);
		frmPatient.getContentPane().add(txtDailyHeight);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(250, 290, 160, 15);
		frmPatient.getContentPane().add(txtWeight);
		
		txtAllergies = new JTextField();
		txtAllergies.setColumns(10);
		txtAllergies.setBounds(250, 325, 160, 15);
		frmPatient.getContentPane().add(txtAllergies);
			
		txtCronicDiseases = new JTextField();
		txtCronicDiseases.setColumns(10);
		txtCronicDiseases.setBounds(250, 356, 160, 15);
		frmPatient.getContentPane().add(txtCronicDiseases);
		
		txtSubsriptions = new JTextField();
		txtSubsriptions.setColumns(10);
		txtSubsriptions.setBounds(250, 386, 160, 15);
		frmPatient.getContentPane().add(txtSubsriptions);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(40, 500, 85, 21);
		frmPatient.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(140, 500, 85, 21);
		frmPatient.getContentPane().add(btnDelete);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(250, 413, 91, 29);
		frmPatient.getContentPane().add(rdbtnFemale);
		
		JRadioButton radioMale = new JRadioButton("Male");
		radioMale.setBounds(342, 413, 91, 29);
		frmPatient.getContentPane().add(radioMale);
	}
}
