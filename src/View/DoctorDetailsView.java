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

import Controller.*;
import Model.Doctor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DoctorDetailsView {

	private doctorController docCtrl;
	private managerController manCtrl;
	private authenticationController authCtrl;
	private JFrame frmDoctorDetails;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAvgPatients;
	private JTextField txtAvgSubscriptions;
	private JTextField txtSpecialization;
	private JTextField txtVisitTime;

	/**
	 * Create the application.
	 */
	public DoctorDetailsView(long token, Doctor doctor) {
		initialize(token,doctor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long token, Doctor doctor) {
		docCtrl = new doctorController(doctor);
		manCtrl = new managerController();
		authCtrl = new authenticationController();
		frmDoctorDetails = new JFrame();
		frmDoctorDetails.setTitle("Doctor Details");
		frmDoctorDetails.setBounds(100, 100, 570, 494);
		
		JPanel panel = new JPanel();
		frmDoctorDetails.getContentPane().add(panel, BorderLayout.CENTER);
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\background2Img.jpg"));
			Image dimg = img.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0,0,554,455);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmDoctorDetails.setIconImage(dimg2);
			
			frmDoctorDetails.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					ManagerView newManagerView = new ManagerView(token);
					frmDoctorDetails.dispose();

				}
			});
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(40, 45, 160, 15);
			lblName.setForeground(Color.black);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblID = new JLabel("ID");
			lblID.setBounds(40, 80, 160, 15);
			lblID.setForeground(Color.black);
			lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(40, 115, 160, 15);
			lblEmail.setForeground(Color.black);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setBounds(40, 154, 160, 15);
			lblPhone.setForeground(Color.black);
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblAvgPatients = new JLabel("Average patients");
			lblAvgPatients.setBounds(40, 194, 160, 15);
			lblAvgPatients.setForeground(Color.black);
			lblAvgPatients.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblAvgSubs = new JLabel("Average subscriptions");
			lblAvgSubs.setBounds(40, 229, 160, 15);
			lblAvgSubs.setForeground(Color.black);
			lblAvgSubs.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblSpecialization = new JLabel("Specialization");
			lblSpecialization.setBounds(40, 264, 160, 15);
			lblSpecialization.setForeground(Color.black);
			lblSpecialization.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			txtName = new JTextField(docCtrl.getDoctorName());
			txtName.setBounds(250, 45, 160, 21);
			txtName.setColumns(10);
			
			txtID = new JTextField(docCtrl.getDoctorID());
			txtID.setEditable(false);
			txtID.setColumns(10);
			txtID.setBounds(250, 80, 160, 21);
			
			txtEmail = new JTextField(docCtrl.getDoctorEmail());
			txtEmail.setColumns(10);
			txtEmail.setBounds(250, 115, 160, 21);
			
			
			txtPhone = new JTextField(String.valueOf(docCtrl.getDoctorPhone()));
			txtPhone.setColumns(10);
			txtPhone.setBounds(250, 159, 160, 21);
			
			
			txtAvgPatients = new JTextField(String.valueOf(docCtrl.getDoctorAveragePatients()));
			txtAvgPatients.setEditable(false);
			txtAvgPatients.setColumns(10);
			txtAvgPatients.setBounds(250, 194, 160, 21);
			
			
			txtAvgSubscriptions = new JTextField(String.valueOf(docCtrl.getDoctorAverageSubscriptions()));
			txtAvgSubscriptions.setEditable(false);
			txtAvgSubscriptions.setColumns(10);
			txtAvgSubscriptions.setBounds(250, 229, 160, 21);
			
			
			txtSpecialization = new JTextField(docCtrl.getDoctorSpecialization());
			txtSpecialization.setEditable(false);
			txtSpecialization.setColumns(10);
			txtSpecialization.setBounds(250, 264, 160, 21);
			
			

			
			
			JButton btnEdit = new JButton("Save");
			btnEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { //siralize users again
					manCtrl.updateDoctor(token, txtID.getText(), txtEmail.getText(), Long.parseLong(txtPhone.getText()));
					manCtrl.serialize();
					// modify also in users hashmap and serialize;
					frmDoctorDetails.dispose();
					ManagerView newManagerView = new ManagerView(token);
				}
			});
			btnEdit.setBounds(40, 390, 85, 21);
			panel.add(btnEdit);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					manCtrl.deleteDoctor(token, txtID.getText());
					authCtrl.deleteUser(token, txtID.getText());
					manCtrl.serialize();
					authCtrl.serialize();
					// modify also in users hashmap and serialize;
					frmDoctorDetails.dispose();
					ManagerView newManagerView = new ManagerView(token);
				}
			});
			btnDelete.setBounds(140, 390, 85, 21);
			panel.add(btnDelete);
			
			
			panel.setLayout(null);
			panel.add(lblName);
			panel.add(lblID);
			panel.add(lblEmail);
			panel.add(lblPhone);
			panel.add(lblAvgPatients);
			panel.add(lblAvgSubs);
			panel.add(lblSpecialization);
			panel.add(txtName);
			panel.add(txtID);
			panel.add(txtEmail);
			panel.add(txtPhone);
			panel.add(txtAvgPatients).setEnabled(false);
			panel.add(txtAvgSubscriptions).setEnabled(false);
			panel.add(txtSpecialization);
			panel.add(backgroundLabel);
			
			frmDoctorDetails.setVisible(true);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
