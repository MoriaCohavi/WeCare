package View;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.*;
import Model.Doctor;
import Model.Patient;

import java.awt.Dimension;
import javax.swing.DebugGraphics;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorView {

	private JFrame frmDoctor;
	private JTable tbl_doctors;
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
	private JButton btnNewMedical;
	private JButton btnRecordsHistory;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorView window = new DoctorView();
//					window.frmDoctor.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DoctorView(long doctorToken) {
		initialize(doctorToken);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken) {
		authCtrl = new authenticationController();
		details = (Doctor)authCtrl.getLoggedinUser(doctorToken);
		docCtrl = new doctorController(details);
		patientsList = docCtrl.getPatientsList(doctorToken);
		
		frmDoctor = new JFrame();
		frmDoctor.setTitle("Doctor");
		frmDoctor.setBounds(100, 100, 1058, 571);
		frmDoctor.getContentPane().setLayout(null);
		frmDoctor.setVisible(true);
		
		frmDoctor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(80, 58, 282, 20);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmDoctor.getContentPane().add(lblWelcome);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 127, 575, 334);
		frmDoctor.getContentPane().add(scrollPane);
		
		tbl_doctors = new JTable();
		tbl_doctors.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tbl_doctors.setBorder(null);
		tbl_doctors.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_doctors.setFocusable(false);
		tbl_doctors.setShowVerticalLines(false);
		tbl_doctors.setSelectionBackground(new Color(211, 211, 211));
		tbl_doctors.setRowMargin(0);
		tbl_doctors.setRowHeight(25);
		tbl_doctors.setIntercellSpacing(new Dimension(0, 0));
		Object[][] listObj = new Object[3][];
		
//		int rowsIndex = 1;
//		for (String key: patientsList.keySet()) {
//			listObj[rowsIndex][0] = rowsIndex;
//			listObj[rowsIndex][1] = patientsList.get(key).getName();
//			listObj[rowsIndex][2] = patientsList.get(key).getId();
//			rowsIndex++;
//		}
		
		tbl_doctors.setModel(new DefaultTableModel(
				listObj,
				new String[] {
					"Num.", "Patient", "ID"
				}
			));


		tbl_doctors.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tbl_doctors.getTableHeader().setOpaque(false);
		tbl_doctors.getTableHeader().setBackground(new Color(32, 136, 203));
		tbl_doctors.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbl_doctors);
		
		txtSearch = new JTextField();
		txtSearch.setForeground(Color.GRAY);
		txtSearch.setSelectionColor(new Color(192, 192, 192));
		txtSearch.setText("Search Patient...");
		txtSearch.setBounds(80, 477, 311, 26);
		frmDoctor.getContentPane().add(txtSearch);
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
						PatientDetailsView patientDetails = new PatientDetailsView(doctorToken, details, searchStr);
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
		frmDoctor.getContentPane().add(btnSearchButton);
		
		btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPatientView(doctorToken);
				frmDoctor.dispose();
			}
		});
		btnAddPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddPatient.setBounds(516, 477, 139, 29);
		frmDoctor.getContentPane().add(btnAddPatient);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(693, 136, 119, 20);
		frmDoctor.getContentPane().add(lblName);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(693, 208, 119, 20);
		frmDoctor.getContentPane().add(lblPhone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(693, 239, 119, 20);
		frmDoctor.getContentPane().add(lblEmail);
		
		txtName = new JTextField();
		txtName.setText(docCtrl.getDoctorName());
		txtName.setEnabled(false);
		txtName.setBounds(821, 133, 146, 26);
		frmDoctor.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText(docCtrl.getDoctorID());
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(821, 170, 146, 26);
		frmDoctor.getContentPane().add(txtId);
		
		txtPhone = new JTextField();
		txtPhone.setText(String.valueOf(docCtrl.getDoctorPhone()));
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(821, 206, 146, 26);
		frmDoctor.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setText(docCtrl.getDoctorEmail());
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(821, 239, 146, 26);
		frmDoctor.getContentPane().add(txtEmail);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblID.setBounds(693, 172, 119, 20);
		frmDoctor.getContentPane().add(lblID);
		
		btnNewMedical = new JButton("Add Medical Record");
		btnNewMedical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchStr = txtSearch.getText();
				if(searchStr != null)
				{
					Patient patient = docCtrl.getPatient(doctorToken, searchStr);
					if (patient != null)
					{
						NewMedicalRecordView newMedicalRecord = new NewMedicalRecordView(doctorToken, searchStr, details);
						frmDoctor.dispose();
					}
					else
					{
						txtSearch.setText("Patient not found !");
					}
				}
			}
		});
		btnNewMedical.setBounds(659, 477, 153, 29);
		frmDoctor.getContentPane().add(btnNewMedical);
		
		btnRecordsHistory = new JButton("View medical history");
		btnRecordsHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchStr = txtSearch.getText();
				if(searchStr != null)
				{
					Patient patient = docCtrl.getPatient(doctorToken, searchStr);
					if (patient != null)
					{
						MedicalRecordHistoryView newMedicalRecord = new MedicalRecordHistoryView(doctorToken, searchStr);
						frmDoctor.dispose();
					}
					else
					{
						txtSearch.setText("Patient not found !");
					}
				}
			}
		});
		btnRecordsHistory.setBounds(821, 477, 153, 29);
		frmDoctor.getContentPane().add(btnRecordsHistory);
	}
}
