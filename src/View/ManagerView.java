package View;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.sun.glass.events.WindowEvent;

import Controller.authenticationController;
import Controller.clinicController;
import Controller.doctorController;
import Controller.managerController;
import Model.Doctor;
import Model.Manager;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerView {

	private doctorController docCtrl;
	private managerController managerCtrl;
	private authenticationController authCtrl;
	private Manager managerDetails;
	private JFrame frmManager;
	private JScrollPane scrollPane;
	private JTable tblDoctors;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnAddDoctor;
	private DefaultTableModel newDocTbl;
	
	/**
	 * Create the application.
	 */
	public ManagerView(long managerToken) {
		initialize(managerToken);
		managerCtrl.deserialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long managerToken) {
		managerCtrl = new managerController();
		authCtrl = new authenticationController();
		managerDetails = (Manager)authCtrl.getLoggedinUser(managerToken);
		managerCtrl.setClinicManager(managerDetails);
		
		frmManager = new JFrame();
		frmManager.setTitle("Manager");
		frmManager.setBounds(100, 100, 1058, 571);
				
		JPanel panel = new JPanel();
		frmManager.getContentPane().add(panel, BorderLayout.CENTER);
		
		try {
							
			BufferedImage img2 = ImageIO.read(new File("src\\view\\managerViewImg.jpg"));
			Image dimg2 = img2.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);
			ImageIcon icon2 = new ImageIcon(dimg2);
			JLabel backgroundLabel = new JLabel(icon2);
			backgroundLabel.setBounds(0, 0, 1042, 532);
			
			BufferedImage img = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmManager.setIconImage(dimg);
			
			frmManager.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					managerCtrl.serialize();
					System.exit(0);
				}
			});
			
			panel.setLayout(null);
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(255, 255, 255));
			scrollPane.setBounds(80, 127, 575, 334);
			panel.add(scrollPane);
			
			JLabel lblWelcome = new JLabel("Welcome");
			lblWelcome.setBounds(493, 41, 282, 20);
			lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(lblWelcome);
			
			tblDoctors = new JTable();
			newDocTbl = new DefaultTableModel();
			tblDoctors.setModel(newDocTbl);
			newDocTbl.addColumn("Doctor Name");
			newDocTbl.addColumn("ID");
			newDocTbl.addColumn("Specialization");
			
			for(String Key : managerCtrl.getDoctorList(managerToken).keySet()) {
				newDocTbl.addRow(new Object [] {
						managerCtrl.getDoctor(managerToken, Key).getName(),
						managerCtrl.getDoctor(managerToken, Key).getDoctorID(),
						managerCtrl.getDoctor(managerToken, Key).getDoctorSpecialization()				
				});
				
			}
			tblDoctors.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
			tblDoctors.setBorder(null);
			tblDoctors.setFont(new Font("Tahoma", Font.PLAIN, 17));
			tblDoctors.setFocusable(false);
			tblDoctors.setShowVerticalLines(false);
			tblDoctors.setSelectionBackground(Color.darkGray);
			tblDoctors.setRowMargin(0);
			tblDoctors.setRowHeight(25);
			tblDoctors.setIntercellSpacing(new Dimension(0, 0));
	
			tblDoctors.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
			tblDoctors.getTableHeader().setOpaque(false);
			tblDoctors.getTableHeader().setBackground(Color.darkGray);
			tblDoctors.getTableHeader().setForeground(Color.white);
			scrollPane.setViewportView(tblDoctors);
			
			txtSearch = new JTextField();
			txtSearch.setText("Search Doctor...");
			txtSearch.setSelectionColor(new Color(192, 192, 192));
			txtSearch.setForeground(Color.GRAY);
			txtSearch.setBounds(80, 477, 311, 26);
			panel.add(txtSearch);
			txtSearch.setColumns(10);
			
			btnSearch = new JButton("Search");
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String searchStr = txtSearch.getText();
					if(searchStr != null)
					{
						Doctor doctor = managerCtrl.getDoctor(managerToken, searchStr);
						if (doctor != null)
						{
							DoctorDetailsView doctorDetailsView = new DoctorDetailsView(managerToken,doctor);
							frmManager.dispose();
						}
						else
						{
							txtSearch.setText("Doctor not found !");
						}
					}
				}
			});
			btnSearch.setBounds(405, 477, 96, 29);
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panel.add(btnSearch);
			
			btnAddDoctor = new JButton("Add Doctor");
			btnAddDoctor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AddDoctorView addDoctorView = new AddDoctorView(managerToken);
					frmManager.dispose();
				}
			});
			btnAddDoctor.setBounds(516, 477, 139, 29);
			btnAddDoctor.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panel.add(btnAddDoctor);
			
			JLabel lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblName.setBounds(693, 136, 119, 20);
			panel.add(lblName);
			
			JLabel lblID = new JLabel("ID");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblID.setBounds(693, 172, 119, 20);
			panel.add(lblID);
			
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPhone.setBounds(693, 208, 119, 20);
			panel.add(lblPhone);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblEmail.setBounds(693, 241, 119, 20);
			panel.add(lblEmail);
			
			JTextPane txtName = new JTextPane();
			txtName.setText(managerCtrl.getManager().getName());
			txtName.setEnabled(false);
			txtName.setForeground(Color.black);
			txtName.setBounds(821, 133, 146, 26);
			panel.add(txtName);
			
			JTextPane txtID = new JTextPane();
			txtID.setText(managerCtrl.getManager().getID());
			txtID.setEnabled(false);
			txtID.setForeground(Color.black);
			txtID.setBounds(821, 170, 146, 26);
			panel.add(txtID);
			
			JTextPane txtPhone = new JTextPane();
			txtPhone.setText(String.valueOf(managerCtrl.getManager().getPhone()));;
			txtPhone.setEnabled(false);
			txtPhone.setForeground(Color.black);
			txtPhone.setBounds(821, 206, 146, 26);
			panel.add(txtPhone);
			
			JTextPane txtEmail = new JTextPane();
			txtEmail.setText(managerCtrl.getManager().getEmail());
			txtEmail.setEnabled(false);
			txtEmail.setForeground(Color.black);
			txtEmail.setBounds(821, 239, 146, 26);
	
			panel.add(txtEmail);
			
			
			JButton btnStats = new JButton("Statistical details");
			btnStats.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnStats.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					managerCtrl.deserializeStats();
					managerCtrl.updateStats(managerToken);
					StatisticalReportView statsView = new StatisticalReportView(managerToken);
					frmManager.dispose();
				}
			});
			btnStats.setBounds(693, 277, 203, 21);
			panel.add(btnStats);
			panel.add(backgroundLabel);
			frmManager.setVisible(true);
		}
	
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}