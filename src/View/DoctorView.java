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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DoctorView {
	
	private authenticationController authCtrl;
	private doctorController docCtrl;
	private Doctor details;
	private HashMap <String, Patient> patientsList;

	private JFrame frmDoctor;
	private JTable tbl_doctors;
	private JScrollPane scrollPane;
	private JTextField txtSearchPatient;
	private JButton btnSearch;
	private JButton btnAddPatient;
	private JLabel lblName;
	private JLabel lblID;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JButton btnGetDailyTestsReports;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtClinicName;


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
		
		frmDoctor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				authCtrl.serialize();
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
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				docCtrl.
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSearch.setBounds(405, 477, 96, 29);
		frmDoctor.getContentPane().add(btnSearch);
		
		btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docCtrl.openAddPatient(doctorToken);
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
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblID.setBounds(693, 172, 119, 20);
		frmDoctor.getContentPane().add(lblID);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(693, 208, 119, 20);
		frmDoctor.getContentPane().add(lblPhone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(693, 239, 119, 20);
		frmDoctor.getContentPane().add(lblEmail);
		
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
		
		txtID = new JTextField();
		txtID.setText(details.getDoctorID());
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(821, 170, 146, 26);
		frmDoctor.getContentPane().add(txtID);
		
		txtPhone = new JTextField();
		txtPhone.setText(String.valueOf(details.getDoctorPhone()));
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(821, 206, 146, 26);
		frmDoctor.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setText(details.getDoctorEmail());
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(821, 239, 146, 26);
		frmDoctor.getContentPane().add(txtEmail);
		
		txtClinicName = new JTextField();
//		txtClinicName.setText(details.getClinicName());
		txtClinicName.setEnabled(false);
		txtClinicName.setColumns(10);
		txtClinicName.setBounds(821, 314, 146, 26);
		frmDoctor.getContentPane().add(txtClinicName);
	}
}
