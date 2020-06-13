package View;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.authenticationController;

import javax.swing.JButton;

public class AddDoctorView {

	private long token;
	private JFrame frmAddDoctor;
	private JTextField txtf_name;
	private JTextField txtf_id;
	private JTextField txtf_email;
	private JTextField txtf_address;
	private JTextField txtf_phone;
	private JTextField txtf_dailyPatients;
	private JTextField txtf_dailySubs;
	private JTextField txtf_specialization;
	private JTextField txtf_visitTime;
	private JTextField txtf_uname;
	private JTextField txtf_passwd;
	private JTextField txtf_userType;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddDoctorView window = new AddDoctorView();
//					window.frmAddDoctor.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AddDoctorView(long token) {
		initialize(token);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long token) {
		frmAddDoctor = new JFrame();
		frmAddDoctor.setTitle("Add doctor");
		frmAddDoctor.setBounds(100, 100, 450, 730);
		frmAddDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddDoctor.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 10);
		frmAddDoctor.getContentPane().add(panel);
		
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(34, 43, 45, 13);
		frmAddDoctor.getContentPane().add(lbl_name);
		
		JLabel lbl_id = new JLabel("Id:");
		lbl_id.setBounds(34, 88, 45, 13);
		frmAddDoctor.getContentPane().add(lbl_id);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setBounds(34, 140, 45, 13);
		frmAddDoctor.getContentPane().add(lbl_email);
		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setBounds(34, 185, 45, 13);
		frmAddDoctor.getContentPane().add(lbl_address);
		
		JLabel lbl_phone = new JLabel("Phone:");
		lbl_phone.setBounds(34, 229, 45, 13);
		frmAddDoctor.getContentPane().add(lbl_phone);
		
		JLabel lbl_dailyPatients = new JLabel("Daily patients:");
		lbl_dailyPatients.setBounds(34, 276, 65, 13);
		frmAddDoctor.getContentPane().add(lbl_dailyPatients);
		
		JLabel lbl_dailySubs = new JLabel("Daily subscriptions:");
		lbl_dailySubs.setBounds(34, 326, 101, 13);
		frmAddDoctor.getContentPane().add(lbl_dailySubs);
		
		JLabel lbl_specs = new JLabel("Specialization:");
		lbl_specs.setBounds(34, 379, 101, 13);
		frmAddDoctor.getContentPane().add(lbl_specs);
		
		JLabel lbl_dailyVisit = new JLabel("Daily visit time:");
		lbl_dailyVisit.setBounds(34, 431, 101, 13);
		frmAddDoctor.getContentPane().add(lbl_dailyVisit);
		
		JLabel lbl_uname = new JLabel("Username:");
		lbl_uname.setBounds(34, 486, 78, 13);
		frmAddDoctor.getContentPane().add(lbl_uname);
		
		JLabel lbl_passwd = new JLabel("Password:");
		lbl_passwd.setBounds(34, 539, 101, 13);
		frmAddDoctor.getContentPane().add(lbl_passwd);
		
		JLabel lbl_type = new JLabel("User type:");
		lbl_type.setBounds(34, 596, 65, 13);
		frmAddDoctor.getContentPane().add(lbl_type);
		
		txtf_name = new JTextField();
		txtf_name.setBounds(157, 40, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_name);
		txtf_name.setColumns(10);
		
		txtf_id = new JTextField();
		txtf_id.setColumns(10);
		txtf_id.setBounds(157, 85, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_id);
		
		txtf_email = new JTextField();
		txtf_email.setColumns(10);
		txtf_email.setBounds(157, 137, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_email);
		
		txtf_address = new JTextField();
		txtf_address.setColumns(10);
		txtf_address.setBounds(157, 182, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_address);
		
		txtf_phone = new JTextField();
		txtf_phone.setColumns(10);
		txtf_phone.setBounds(157, 226, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_phone);
		
		txtf_dailyPatients = new JTextField();
		txtf_dailyPatients.setColumns(10);
		txtf_dailyPatients.setBounds(157, 273, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_dailyPatients);
		
		txtf_dailySubs = new JTextField();
		txtf_dailySubs.setColumns(10);
		txtf_dailySubs.setBounds(157, 323, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_dailySubs);
		
		txtf_specialization = new JTextField();
		txtf_specialization.setColumns(10);
		txtf_specialization.setBounds(157, 376, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_specialization);
		
		txtf_visitTime = new JTextField();
		txtf_visitTime.setColumns(10);
		txtf_visitTime.setBounds(157, 425, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_visitTime);
		
		txtf_uname = new JTextField();
		txtf_uname.setColumns(10);
		txtf_uname.setBounds(157, 483, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_uname);
		
		txtf_passwd = new JTextField();
		txtf_passwd.setColumns(10);
		txtf_passwd.setBounds(157, 536, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_passwd);
		
		txtf_userType = new JTextField();
		txtf_userType.setColumns(10);
		txtf_userType.setBounds(157, 593, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_userType);
		
		JButton btn_addDoctor = new JButton("Add Doctor");
		btn_addDoctor.setBounds(157, 651, 109, 21);
		frmAddDoctor.getContentPane().add(btn_addDoctor);
		frmAddDoctor.setVisible(true);
		
		btn_addDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

}
