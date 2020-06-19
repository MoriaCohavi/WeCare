package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.*;

import javax.swing.JButton;

public class AddDoctorView {

	private managerController managerController;
	private authenticationController authController;
	private JFrame frmAddDoctor;
	private JTextField txtf_name;
	private JTextField txtf_id;
	private JTextField txtf_email;
	private JTextField txtf_address;
	private JTextField txtf_phone;
	private JTextField txtf_specialization;
	private JTextField txtf_passwd;


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
		managerController = new managerController();
		authController = new authenticationController();
		
		frmAddDoctor = new JFrame();
		frmAddDoctor.setTitle("Add doctor");
		frmAddDoctor.setBounds(100, 100, 450, 536);
		//frmAddDoctor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddDoctor.getContentPane().setLayout(null);
		
		frmAddDoctor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ManagerView newManagerView = new ManagerView(token);
				frmAddDoctor.dispose();
			}
		});

		
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
		txtf_email.setText(null);
		frmAddDoctor.getContentPane().add(txtf_email);
		
		
		txtf_address = new JTextField();
		txtf_address.setColumns(10);
		txtf_address.setBounds(157, 182, 96, 19);
		txtf_address.setText(null);
		frmAddDoctor.getContentPane().add(txtf_address);
		
		txtf_phone = new JTextField();
		txtf_phone.setColumns(10);
		txtf_phone.setBounds(157, 226, 96, 19);
		txtf_phone.setText("0");
		frmAddDoctor.getContentPane().add(txtf_phone);
		
		txtf_specialization = new JTextField();
		txtf_specialization.setColumns(10);
		txtf_specialization.setBounds(157, 279, 96, 19);
		txtf_specialization.setText(null);
		frmAddDoctor.getContentPane().add(txtf_specialization);
		
		txtf_passwd = new JTextField();
		txtf_passwd.setColumns(10);
		txtf_passwd.setBounds(157, 336, 96, 19);
		frmAddDoctor.getContentPane().add(txtf_passwd);
		
		JButton btn_addDoctor = new JButton("Add Doctor");
		btn_addDoctor.setBounds(157, 425, 109, 21);
		frmAddDoctor.getContentPane().add(btn_addDoctor);
		
		JLabel lbl_warning = new JLabel("");
		lbl_warning.setBounds(34, 392, 390, 19);
		frmAddDoctor.getContentPane().add(lbl_warning);
		frmAddDoctor.setVisible(true);
		
		btn_addDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((txtf_id.getText() != null && txtf_id.getText().length() != 9) || txtf_name.getText() == null || txtf_passwd.getText() == null)
					lbl_warning.setText("Please! Put valid ID of 9 digits, name and password");
				else
				{
					
					if (!(managerController.addNewDoctor(txtf_id.getText(), Long.parseLong(txtf_phone.getText()), txtf_name.getText(), txtf_email.getText(), txtf_specialization.getText(), txtf_passwd.getText(), "Doctor", token)))
						lbl_warning.setText("User exists");
					else {
						managerController.serialize();
						authController.serialize();
						frmAddDoctor.dispose();
						ManagerView newManagerView = new ManagerView(token);
					}
						
				}
			}
		});
	}
}
