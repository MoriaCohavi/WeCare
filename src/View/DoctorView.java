package View;


import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.*;
import Model.Doctor;
import Model.Patient;

import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorView {

	private JFrame frmDoctor;
	private JTable tbl_Patients;
	private JScrollPane scrollPane;
	private JTextField txtSearch;
	private JButton btnSearchButton;
	private JButton btnAddPatient;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private authenticationController authCtrl;
	private doctorController docCtrl;
	private Doctor details;
	private HashMap <String, Patient> patientsList;
	private JLabel lblID;
	private DefaultTableModel newPatientsTbl;
	
	/**
	 * Create the application.
	 */
	public DoctorView(long doctorToken) {
		initialize(doctorToken);
		docCtrl.deserializeRecords();
		docCtrl.deserializeStatsList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken) {
		authCtrl = new authenticationController();
		details = (Doctor)authCtrl.getLoggedinUser(doctorToken);
		docCtrl = new doctorController(details);
		
		frmDoctor = new JFrame();
		frmDoctor.setTitle("Doctor");
		frmDoctor.setBounds(100, 100, 1058, 571);
		
		
		JPanel panel = new JPanel();
		frmDoctor.getContentPane().add(panel, BorderLayout.CENTER);
		
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\doctorViewImg.jpg"));
			Image dimg = img.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0, 0, 1042, 532);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmDoctor.setIconImage(dimg2);
			
			
			frmDoctor.setVisible(true);
			
			frmDoctor.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					docCtrl.serializeRecords();
					docCtrl.serializeStatsList();
					System.exit(0);
				}
			});
			
			panel.setLayout(null);
			
			JLabel lblWelcome = new JLabel("Welcome");
			lblWelcome.setBounds(435, 56, 282, 20);
			lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(lblWelcome);
			
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(255, 255, 255));
			scrollPane.setBounds(80, 127, 575, 334);
			panel.add(scrollPane);
			
			tbl_Patients = new JTable();
			newPatientsTbl = new DefaultTableModel();
			tbl_Patients.setModel(newPatientsTbl);
			newPatientsTbl.addColumn("Serial Num");
			newPatientsTbl.addColumn("Patient Name");
			newPatientsTbl.addColumn("Patient ID");
			int serialNum = 1;
			
			for(String Key : docCtrl.getPatientList(doctorToken).keySet())
				
				if (docCtrl.getPatientList(doctorToken).get(Key).getDoctorId().equals(docCtrl.getDoctorID())) {
				
					newPatientsTbl.addRow(new Object [] {
						serialNum++,
						docCtrl.getPatient(doctorToken, Key).getName(),
						docCtrl.getPatient(doctorToken, Key).getId(),				
				});
			}
			
			tbl_Patients.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
			tbl_Patients.setBorder(null);
			tbl_Patients.setFont(new Font("Tahoma", Font.PLAIN, 17));
			tbl_Patients.setFocusable(false);
			tbl_Patients.setShowVerticalLines(false);
			tbl_Patients.setSelectionBackground(Color.darkGray);
			tbl_Patients.setRowMargin(0);
			tbl_Patients.setRowHeight(25);
			tbl_Patients.setIntercellSpacing(new Dimension(0, 0));
			
			
			tbl_Patients.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
			tbl_Patients.getTableHeader().setOpaque(false);
			tbl_Patients.getTableHeader().setBackground(Color.darkGray);
			tbl_Patients.getTableHeader().setForeground(Color.white);
			scrollPane.setViewportView(tbl_Patients);
			
			txtSearch = new JTextField();
			txtSearch.setForeground(Color.GRAY);
			txtSearch.setSelectionColor(new Color(192, 192, 192));
			txtSearch.setText("Search Patient...");
			txtSearch.setBounds(80, 477, 311, 26);
			panel.add(txtSearch);
			txtSearch.setColumns(10);
			
			btnSearchButton = new JButton("Search");
			btnSearchButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String searchStr = txtSearch.getText();
					if(searchStr != null)
					{
						Patient patient = docCtrl.getPatient(doctorToken, searchStr);
						if (patient != null)
						{
							//PatientDetailsView patientDetails = new PatientDetailsView(doctorToken, details, searchStr);
							PatientMedicalHistoryView patientDetails = new PatientMedicalHistoryView(doctorToken, details, searchStr);
							frmDoctor.dispose();
						}
						else
						{
							txtSearch.setText("Patient not found !");
						}
					}
				}
			});

			btnSearchButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnSearchButton.setBounds(405, 477, 96, 29);
			panel.add(btnSearchButton);
			
			btnAddPatient = new JButton("Add Patient");
			btnAddPatient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddPatientView patientView = new AddPatientView(doctorToken);
					frmDoctor.dispose();
				}
			});
			btnAddPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnAddPatient.setBounds(516, 477, 139, 29);
			panel.add(btnAddPatient);
			
			lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblName.setBounds(693, 136, 119, 20);
			panel.add(lblName);
			
			lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPhone.setBounds(693, 208, 119, 20);
			panel.add(lblPhone);
			
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblEmail.setBounds(693, 239, 119, 20);
			panel.add(lblEmail);
			
			txtName = new JTextField();
			txtName.setText(docCtrl.getDoctorName());
			txtName.setEnabled(false);
			txtName.setBounds(821, 133, 146, 26);
			panel.add(txtName);
			txtName.setColumns(10);
			
			txtId = new JTextField();
			txtId.setText(docCtrl.getDoctorID());
			txtId.setEnabled(false);
			txtId.setColumns(10);
			txtId.setBounds(821, 170, 146, 26);
			panel.add(txtId);
			
			txtPhone = new JTextField();
			txtPhone.setText(String.valueOf(docCtrl.getDoctorPhone()));
			txtPhone.setEnabled(false);
			txtPhone.setColumns(10);
			txtPhone.setBounds(821, 206, 146, 26);
			panel.add(txtPhone);
			
			txtEmail = new JTextField();
			txtEmail.setText(docCtrl.getDoctorEmail());
			txtEmail.setEnabled(false);
			txtEmail.setColumns(10);
			txtEmail.setBounds(821, 239, 146, 26);
			panel.add(txtEmail);
			
			lblID = new JLabel("ID");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblID.setBounds(693, 172, 119, 20);
			panel.add(lblID);
			
			panel.add(backgroundLabel);
			frmDoctor.setVisible(true);
		
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
