package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		
		
		
		JPanel panel = new JPanel();
		frmAddDoctor.getContentPane().add(panel, BorderLayout.CENTER);
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\backgroundImg.jpg"));
			Image dimg = img.getScaledInstance(450, 536, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0,0,434,497);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmAddDoctor.setIconImage(dimg2);
			
			frmAddDoctor.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					ManagerView newManagerView = new ManagerView(token);
					frmAddDoctor.dispose();
				}
			});

			
			JLabel lbl_name = new JLabel("Name:");
			lbl_name.setBounds(34, 43, 45, 13);
			lbl_name.setForeground(Color.black);
			lbl_name.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lbl_id = new JLabel("Id:");
			lbl_id.setBounds(34, 88, 45, 13);
			lbl_id.setForeground(Color.black);
			lbl_id.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lbl_email = new JLabel("Email:");
			lbl_email.setBounds(34, 140, 45, 13);
			lbl_email.setForeground(Color.black);
			lbl_email.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lbl_address = new JLabel("Address:");
			lbl_address.setBounds(34, 185, 45, 13);
			lbl_address.setForeground(Color.black);
			lbl_address.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lbl_phone = new JLabel("Phone:");
			lbl_phone.setBounds(34, 229, 45, 13);
			lbl_phone.setForeground(Color.black);
			lbl_phone.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lbl_specs = new JLabel("Specialization:");
			lbl_specs.setBounds(34, 282, 113, 13);
			lbl_specs.setForeground(Color.black);
			lbl_specs.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lbl_passwd = new JLabel("Password:");
			lbl_passwd.setBounds(34, 339, 101, 13);
			lbl_passwd.setForeground(Color.black);
			lbl_passwd.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			txtf_name = new JTextField();
			txtf_name.setBounds(157, 40, 96, 19);
			txtf_name.setColumns(10);
			
			txtf_id = new JTextField();
			txtf_id.setColumns(10);
			txtf_id.setBounds(157, 85, 96, 19);
			
			txtf_email = new JTextField();
			txtf_email.setColumns(10);
			txtf_email.setBounds(157, 137, 96, 19);
			txtf_email.setText(null);
			
			txtf_address = new JTextField();
			txtf_address.setColumns(10);
			txtf_address.setBounds(157, 182, 96, 19);
			txtf_address.setText(null);
			
			txtf_phone = new JTextField();
			txtf_phone.setColumns(10);
			txtf_phone.setBounds(157, 226, 96, 19);
			txtf_phone.setText("0");
						
			txtf_specialization = new JTextField();
			txtf_specialization.setColumns(10);
			txtf_specialization.setBounds(157, 279, 96, 19);
			txtf_specialization.setText(null);
						
			txtf_passwd = new JTextField();
			txtf_passwd.setColumns(10);
			txtf_passwd.setBounds(157, 336, 96, 19);
			
			
			JButton btn_addDoctor = new JButton("Add Doctor");
			btn_addDoctor.setBounds(157, 425, 109, 21);
			
			
			JLabel lbl_warning = new JLabel("");
			lbl_warning.setBounds(34, 392, 390, 19);
			lbl_warning.setForeground(Color.black);
			lbl_warning.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			panel.setLayout(null);
			panel.add(lbl_name);
			panel.add(lbl_id);
			panel.add(lbl_email);
			panel.add(lbl_address);
			panel.add(lbl_phone);
			panel.add(lbl_specs);
			panel.add(lbl_passwd);
			panel.add(txtf_name);
			panel.add(txtf_id);
			panel.add(txtf_email);
			panel.add(txtf_address);
			panel.add(txtf_phone);
			panel.add(txtf_specialization);
			panel.add(txtf_passwd);
			panel.add(btn_addDoctor);
			panel.add(lbl_warning);
			panel.add(backgroundLabel);
			
			
			
			frmAddDoctor.setVisible(true);
			
			btn_addDoctor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if ((txtf_id.getText() != null && txtf_id.getText().length() != 9) || txtf_name.getText() == null || txtf_passwd.getText() == null)
						lbl_warning.setText("Please! Put valid ID of 9 digits, name and password");
					else
					{
						
						if (!(managerController.addNewDoctor(txtf_id.getText(), authController.getLoggedinUser(token).getId(), Long.parseLong(txtf_phone.getText()), txtf_name.getText(), txtf_email.getText(), txtf_specialization.getText(), txtf_passwd.getText(), "Doctor", token)))
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
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
