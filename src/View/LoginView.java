package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.*;

public class LoginView {

	private JFrame frmLogin;
	private JTextField txtf_uname;
	private JTextField txtf_passwd;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginView window = new LoginView();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public LoginView(authenticationController authController) {
		initialize(authController);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(authenticationController authController) {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 367, 395);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_uname = new JLabel("Username");
		lbl_uname.setBounds(47, 69, 68, 32);
		panel.add(lbl_uname);
		
		JLabel lbl_passwd = new JLabel("Password");
		lbl_passwd.setBounds(47, 144, 68, 13);
		panel.add(lbl_passwd);
		
		txtf_uname = new JTextField();
		txtf_uname.setBounds(149, 76, 96, 19);
		panel.add(txtf_uname);
		txtf_uname.setColumns(10);
		
		txtf_passwd = new JTextField();
		txtf_passwd.setBounds(149, 141, 96, 19);
		panel.add(txtf_passwd);
		txtf_passwd.setColumns(10);
		
		JLabel lbl_message = new JLabel("");
		lbl_message.setBounds(47, 204, 164, 13);
		panel.add(lbl_message);
		
		JButton btn_login = new JButton("Login");

		btn_login.setBounds(47, 232, 85, 21);
		panel.add(btn_login);
		
		JButton btn_forgotpass = new JButton("Forgot Password");
		btn_forgotpass.setBounds(149, 232, 157, 21);
		panel.add(btn_forgotpass);
		frmLogin.setVisible(true);
		
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long returnCode = authController.login(txtf_uname.getText(), txtf_passwd.getText());
				if (returnCode == -1)
					lbl_message.setText("Wrong username or password");
				else if (returnCode == -2)
				{
					lbl_message.setText("Invalid ID");
					
				}
				else
				{
					String type = authController.fetchUserType(returnCode);
					if (type.equals("Manager"))
					{
						ManagerPanelView managerPanel = new ManagerPanelView();
					}
					else if (type.equals("Doctor"))
					{
						DoctorView doctorPanel = new DoctorView();
					}
					frmLogin.dispose(); // destroy the frame object

				}	
			}
		});
	}
}
