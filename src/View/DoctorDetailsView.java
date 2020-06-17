package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Doctor;

import javax.swing.JButton;

public class DoctorDetailsView {

	private JFrame frmDoctorDetails;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtDailyPatients;
	private JTextField txtDailySubscriptions;
	private JTextField txtSpecialization;
	private JTextField txtVisitTime;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorDetailsView window = new DoctorDetailsView();
//					window.frmDoctorDetails.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DoctorDetailsView(Doctor doctor) {
		initialize(doctor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Doctor doctor) {
		frmDoctorDetails = new JFrame();
		frmDoctorDetails.setTitle("Doctor Details");
		frmDoctorDetails.setBounds(100, 100, 570, 494);
		frmDoctorDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorDetails.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(40, 45, 160, 15);
		frmDoctorDetails.getContentPane().add(lblName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(40, 80, 160, 15);
		frmDoctorDetails.getContentPane().add(lblID);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 115, 160, 15);
		frmDoctorDetails.getContentPane().add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(40, 150, 160, 15);
		frmDoctorDetails.getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(40, 185, 160, 15);
		frmDoctorDetails.getContentPane().add(lblPhone);
		
		JLabel lblDailyPatients = new JLabel("Daily patients");
		lblDailyPatients.setBounds(40, 225, 160, 15);
		frmDoctorDetails.getContentPane().add(lblDailyPatients);
		
		JLabel lblDailySubs = new JLabel("Daily subscriptions");
		lblDailySubs.setBounds(40, 260, 160, 15);
		frmDoctorDetails.getContentPane().add(lblDailySubs);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(40, 295, 160, 15);
		frmDoctorDetails.getContentPane().add(lblSpecialization);
		
		JLabel lblVisitTime = new JLabel("Daily visit time");
		lblVisitTime.setBounds(40, 330, 160, 15);
		frmDoctorDetails.getContentPane().add(lblVisitTime);
		
		txtName = new JTextField();
		txtName.setBounds(250, 45, 160, 15);
		frmDoctorDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(250, 80, 160, 15);
		frmDoctorDetails.getContentPane().add(txtID);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(250, 115, 160, 15);
		frmDoctorDetails.getContentPane().add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(250, 150, 160, 15);
		frmDoctorDetails.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(250, 185, 160, 15);
		frmDoctorDetails.getContentPane().add(txtPhone);
		
		txtDailyPatients = new JTextField();
		txtDailyPatients.setColumns(10);
		txtDailyPatients.setBounds(250, 220, 160, 15);
		frmDoctorDetails.getContentPane().add(txtDailyPatients);
		
		txtDailySubscriptions = new JTextField();
		txtDailySubscriptions.setColumns(10);
		txtDailySubscriptions.setBounds(250, 255, 160, 15);
		frmDoctorDetails.getContentPane().add(txtDailySubscriptions);
		
		txtSpecialization = new JTextField();
		txtSpecialization.setColumns(10);
		txtSpecialization.setBounds(250, 290, 160, 15);
		frmDoctorDetails.getContentPane().add(txtSpecialization);
		
		txtVisitTime = new JTextField();
		txtVisitTime.setColumns(10);
		txtVisitTime.setBounds(250, 325, 160, 15);
		frmDoctorDetails.getContentPane().add(txtVisitTime);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(40, 390, 85, 21);
		frmDoctorDetails.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(140, 390, 85, 21);
		frmDoctorDetails.getContentPane().add(btnDelete);
	}

}
