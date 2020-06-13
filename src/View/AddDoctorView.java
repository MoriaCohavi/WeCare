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
import Controller.*;

import javax.swing.JButton;

public class AddDoctorView {

	private doctorController doctorController;
	private long token;
	private JFrame frmAddDoctor;
	private JTextField txtf_name;
	private JTextField txtf_id;
	private JTextField txtf_email;
	private JTextField txtf_address;
	private JTextField txtf_phone;
	private JTextField txtf_specialization;
	private JTextField txtf_passwd;

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
		frmAddDoctor.setBounds(100, 100, 450, 536);
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
		
		JLabel lbl_specs = new JLabel("Specialization:");
		lbl_specs.setBounds(34, 282, 113, 13);
		frmAddDoctor.getContentPane().add(lbl_specs);
		
		JLabel lbl_passwd = new JLabel("Password:");
		lbl_passwd.setBounds(34, 339, 101, 13);
		frmAddDoctor.getContentPane().add(lbl_passwd);
		
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
		
		txtf_specialization = new JTextField();
		txtf_specialization.setColumns(10);
		txtf_specialization.setBounds(157, 279, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_specialization);
		
		txtf_passwd = new JTextField();
		txtf_passwd.setColumns(10);
		txtf_passwd.setBounds(157, 336, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_passwd);
		
		JButton btn_addDoctor = new JButton("Add Doctor");
		btn_addDoctor.setBounds(157, 425, 109, 21);
		frmAddDoctor.getContentPane().add(btn_addDoctor);
		frmAddDoctor.setVisible(true);
		
		btn_addDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

}
