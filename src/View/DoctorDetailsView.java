package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DoctorDetailsView {

	private JFrame frmDoctorDetails;
	private JTextField txtf_name;
	private JTextField txtf_id;
	private JTextField txtf_email;
	private JTextField txtf_address;
	private JTextField txtf_phone;
	private JTextField txtf_dailyPatients;
	private JTextField txtf_dailySubscriptions;
	private JTextField txtf_specialization;
	private JTextField txtf_visitTime;

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
	public DoctorDetailsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDoctorDetails = new JFrame();
		frmDoctorDetails.setTitle("Doctor details");
		frmDoctorDetails.setBounds(100, 100, 408, 665);
		frmDoctorDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorDetails.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 528, 10);
		frmDoctorDetails.getContentPane().add(panel);
		
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(37, 45, 45, 13);
		frmDoctorDetails.getContentPane().add(lbl_name);
		
		JLabel lbl_id = new JLabel("Id:");
		lbl_id.setBounds(37, 93, 45, 13);
		frmDoctorDetails.getContentPane().add(lbl_id);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setBounds(37, 142, 45, 13);
		frmDoctorDetails.getContentPane().add(lbl_email);
		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setBounds(37, 188, 88, 13);
		frmDoctorDetails.getContentPane().add(lbl_address);
		
		JLabel lbl_phone = new JLabel("Phone:");
		lbl_phone.setBounds(37, 237, 45, 13);
		frmDoctorDetails.getContentPane().add(lbl_phone);
		
		JLabel lbl_dailyPatients = new JLabel("Daily patients:");
		lbl_dailyPatients.setBounds(37, 287, 103, 13);
		frmDoctorDetails.getContentPane().add(lbl_dailyPatients);
		
		JLabel lbl_dailySubs = new JLabel("Daily subscriptions:");
		lbl_dailySubs.setBounds(37, 337, 119, 13);
		frmDoctorDetails.getContentPane().add(lbl_dailySubs);
		
		JLabel lbl_specialization = new JLabel("Specialization:");
		lbl_specialization.setBounds(37, 393, 119, 13);
		frmDoctorDetails.getContentPane().add(lbl_specialization);
		
		JLabel lbl_visitTime = new JLabel("Daily visit time:");
		lbl_visitTime.setBounds(37, 444, 88, 13);
		frmDoctorDetails.getContentPane().add(lbl_visitTime);
		
		txtf_name = new JTextField();
		txtf_name.setBounds(179, 42, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_name);
		txtf_name.setColumns(10);
		
		txtf_id = new JTextField();
		txtf_id.setColumns(10);
		txtf_id.setBounds(179, 90, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_id);
		
		txtf_email = new JTextField();
		txtf_email.setColumns(10);
		txtf_email.setBounds(179, 139, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_email);
		
		txtf_address = new JTextField();
		txtf_address.setColumns(10);
		txtf_address.setBounds(179, 185, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_address);
		
		txtf_phone = new JTextField();
		txtf_phone.setColumns(10);
		txtf_phone.setBounds(179, 234, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_phone);
		
		txtf_dailyPatients = new JTextField();
		txtf_dailyPatients.setColumns(10);
		txtf_dailyPatients.setBounds(179, 284, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_dailyPatients);
		
		txtf_dailySubscriptions = new JTextField();
		txtf_dailySubscriptions.setColumns(10);
		txtf_dailySubscriptions.setBounds(179, 334, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_dailySubscriptions);
		
		txtf_specialization = new JTextField();
		txtf_specialization.setColumns(10);
		txtf_specialization.setBounds(179, 390, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_specialization);
		
		txtf_visitTime = new JTextField();
		txtf_visitTime.setColumns(10);
		txtf_visitTime.setBounds(179, 438, 146, 19);
		frmDoctorDetails.getContentPane().add(txtf_visitTime);
		
		JButton btn_edit = new JButton("Edit");
		btn_edit.setBounds(109, 534, 85, 21);
		frmDoctorDetails.getContentPane().add(btn_edit);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setBounds(219, 534, 85, 21);
		frmDoctorDetails.getContentPane().add(btn_delete);
	}

}
