package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitializeClinicView {

	private JFrame frmCreateClinic;
	private JTextField txtf_id;
	private JTextField txtf_city;
	private JTextField txtf_managerName;
	private JTextField txtf_managerId;
	private JTextField txtf_phone;
	private JTextField txtf_email;
	private JTextField txtf_uname;
	private JTextField txtf_passwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitializeClinicView window = new InitializeClinicView();
					window.frmCreateClinic.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitializeClinicView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateClinic = new JFrame();
		frmCreateClinic.setTitle("Create clinic");
		frmCreateClinic.setBounds(100, 100, 369, 527);
		frmCreateClinic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateClinic.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 10);
		frmCreateClinic.getContentPane().add(panel);
		
		JLabel lbl_id = new JLabel("Clinic id:");
		lbl_id.setBounds(38, 57, 45, 13);
		frmCreateClinic.getContentPane().add(lbl_id);
		
		JLabel lbl_city = new JLabel("City:");
		lbl_city.setBounds(38, 110, 45, 13);
		frmCreateClinic.getContentPane().add(lbl_city);
		
		txtf_id = new JTextField();
		txtf_id.setBounds(145, 54, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_id);
		txtf_id.setColumns(10);
		
		txtf_city = new JTextField();
		txtf_city.setColumns(10);
		txtf_city.setBounds(145, 107, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_city);
		
		JButton btn_create = new JButton("Create clinic");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_create.setBounds(38, 446, 117, 21);
		frmCreateClinic.getContentPane().add(btn_create);
		
		JLabel lbl_name = new JLabel("Manager name:");
		lbl_name.setBounds(38, 156, 78, 13);
		frmCreateClinic.getContentPane().add(lbl_name);
		
		txtf_managerName = new JTextField();
		txtf_managerName.setBounds(145, 153, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_managerName);
		txtf_managerName.setColumns(10);
		
		JLabel lbl_managerId = new JLabel("Manager Id:");
		lbl_managerId.setBounds(38, 204, 78, 13);
		frmCreateClinic.getContentPane().add(lbl_managerId);
		
		txtf_managerId = new JTextField();
		txtf_managerId.setColumns(10);
		txtf_managerId.setBounds(145, 201, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_managerId);
		
		JLabel lbl_phone = new JLabel("Phone number:");
		lbl_phone.setBounds(38, 258, 96, 13);
		frmCreateClinic.getContentPane().add(lbl_phone);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setBounds(38, 308, 45, 13);
		frmCreateClinic.getContentPane().add(lbl_email);
		
		JLabel lbl_uname = new JLabel("Username:");
		lbl_uname.setBounds(38, 355, 96, 13);
		frmCreateClinic.getContentPane().add(lbl_uname);
		
		JLabel lbl_passwd = new JLabel("Password:");
		lbl_passwd.setBounds(38, 400, 78, 13);
		frmCreateClinic.getContentPane().add(lbl_passwd);
		
		txtf_phone = new JTextField();
		txtf_phone.setColumns(10);
		txtf_phone.setBounds(145, 255, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_phone);
		
		txtf_email = new JTextField();
		txtf_email.setColumns(10);
		txtf_email.setBounds(145, 305, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_email);
		
		txtf_uname = new JTextField();
		txtf_uname.setColumns(10);
		txtf_uname.setBounds(145, 352, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_uname);
		
		txtf_passwd = new JTextField();
		txtf_passwd.setColumns(10);
		txtf_passwd.setBounds(145, 397, 96, 19);
		frmCreateClinic.getContentPane().add(txtf_passwd);
	}
}
