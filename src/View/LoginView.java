package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Controller.*;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class LoginView {

	authenticationController authController;
	private JFrame frmLogin;
	private JTextField txtf_uname;
	private JPasswordField passwdfield;
	
	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 750, 396);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\loginPageImg.jpg"));
			Image dimg = img.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0,0, 734, 356);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmLogin.setIconImage(dimg2);
					
			JLabel lbl_uname = new JLabel("ID");
			lbl_uname.setBounds(114, 60, 68, 32);
			lbl_uname.setForeground(Color.black);
			lbl_uname.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lbl_passwd = new JLabel("Password");
			lbl_passwd.setBounds(114, 106, 68, 14);
			lbl_passwd.setForeground(Color.black);
			lbl_passwd.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			
			txtf_uname = new JTextField();
			txtf_uname.setBounds(216, 67, 86, 20);
			txtf_uname.setColumns(10);
			
			JLabel lbl_message = new JLabel("");
			lbl_message.setBounds(355, 149, 259, 13);
			
			JButton btn_login = new JButton("Login");
			btn_login.setBounds(163, 207, 85, 23);
			
			JButton btn_forgotpass = new JButton("Forgot Password");
			btn_forgotpass.setBounds(528, 299, 157, 23);
			
			passwdfield = new JPasswordField();
			passwdfield.setBounds(216, 103, 86, 20);
			
			panel.setLayout(null);
			panel.add(lbl_message);
			panel.add(btn_login);
			panel.add(btn_forgotpass);
			panel.add(lbl_uname);
			panel.add(lbl_passwd);
			panel.add(passwdfield);
			panel.add(txtf_uname);
			panel.add(backgroundLabel);
			frmLogin.setVisible(true);
			
			btn_login.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					authController = new authenticationController();
					long returnCode = authController.login(txtf_uname.getText(), passwdfield.getText());
					if (returnCode == -1)
						lbl_message.setText("Wrong username or password");
					else if (returnCode == -2)
					{
						lbl_message.setFont(new Font("Tahoma", Font.BOLD, 11));
						lbl_message.setForeground(Color.white);
						lbl_message.setText("Invalid ID");
					}
					else
					{
						String type = authController.fetchUserType(returnCode);
						if (type.equals("Manager"))
						{
							new ManagerView(returnCode);
						}
						else if (type.equals("Doctor"))
						{
							new DoctorView(returnCode);
						}
						
						frmLogin.dispose();
					}	
				}
			});
			
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
		
		
	}
}
