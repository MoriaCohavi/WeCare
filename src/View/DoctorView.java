package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.*;
import Model.Doctor;
import Model.Patient;

import java.awt.Dimension;
import javax.swing.DebugGraphics;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.util.HashMap;

public class DoctorView {

	private JFrame frmDoctor;
	private JTable tbl_doctors;
	private JScrollPane scrollPane;
	private JTextField txtSearchPatient;
	private JButton btnNewButton;
	private JButton btnAddPatient;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblClinicName;
	private JSeparator separator;
	private JButton btnGetDailyTestsReports;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtClinicName;
	private authenticationController authCtrl;
	private doctorController docCtrl;
	private Doctor details;
	private HashMap <String, Patient> patientsList;

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
		patientsList = docCtrl.getPatientsList();
		
		frmDoctor = new JFrame();
		frmDoctor.setTitle("Doctor");
		frmDoctor.setBounds(100, 100, 1058, 571);
		frmDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctor.getContentPane().setLayout(null);
		frmDoctor.setVisible(true);
		
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
		int rowsIndex = 1;
		for (String key: patientsList.keySet()) {
			listObj[rowsIndex][0] = rowsIndex;
			listObj[rowsIndex][1] = patientsList.get(key).getName();
			listObj[rowsIndex][2] = patientsList.get(key).getId();
			rowsIndex++;
		}
		
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
		
		txtSearchPatient = new JTextField();
		txtSearchPatient.setForeground(Color.GRAY);
		txtSearchPatient.setSelectionColor(new Color(192, 192, 192));
		txtSearchPatient.setText("Search Patient...");
		txtSearchPatient.setBounds(80, 477, 311, 26);
		frmDoctor.getContentPane().add(txtSearchPatient);
		txtSearchPatient.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(405, 477, 96, 29);
		frmDoctor.getContentPane().add(btnNewButton);
		
		btnAddPatient = new JButton("Add Patient");
		btnAddPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddPatient.setBounds(516, 477, 139, 29);
		frmDoctor.getContentPane().add(btnAddPatient);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(693, 136, 119, 20);
		frmDoctor.getContentPane().add(lblNewLabel);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(693, 208, 119, 20);
		frmDoctor.getContentPane().add(lblPhone);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(693, 244, 119, 20);
		frmDoctor.getContentPane().add(lblAddress);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(693, 280, 119, 20);
		frmDoctor.getContentPane().add(lblEmail);
		
		lblClinicName = new JLabel("Clinic Name");
		lblClinicName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClinicName.setBounds(693, 316, 119, 20);
		frmDoctor.getContentPane().add(lblClinicName);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(670, 127, 351, 379);
		frmDoctor.getContentPane().add(separator);
		
		btnGetDailyTestsReports = new JButton("Get Daily Tests Reports");
		btnGetDailyTestsReports.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGetDailyTestsReports.setBounds(693, 475, 244, 29);
		frmDoctor.getContentPane().add(btnGetDailyTestsReports);
		
		txtName = new JTextField();
		txtName.setText(details.getDoctorName());
		txtName.setEnabled(false);
		txtName.setBounds(821, 133, 146, 26);
		frmDoctor.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText(details.getDoctorID());
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(821, 170, 146, 26);
		frmDoctor.getContentPane().add(txtId);
		
		txtPhone = new JTextField();
//		txtPhone.setText(details.getPhone().toString());
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(821, 206, 146, 26);
		frmDoctor.getContentPane().add(txtPhone);
		
		txtAddress = new JTextField();
//		txtAddress.setText(details.getAddress());
		txtAddress.setEnabled(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(821, 242, 146, 26);
		frmDoctor.getContentPane().add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.setText(details.getDoctorEmail());
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(821, 278, 146, 26);
		frmDoctor.getContentPane().add(txtEmail);
		
		txtClinicName = new JTextField();
//		txtClinicName.setText(details.getClinicName());
		txtClinicName.setEnabled(false);
		txtClinicName.setColumns(10);
		txtClinicName.setBounds(821, 314, 146, 26);
		frmDoctor.getContentPane().add(txtClinicName);
		
		lblName = new JLabel("ID");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(693, 172, 119, 20);
		frmDoctor.getContentPane().add(lblName);
	}
}
