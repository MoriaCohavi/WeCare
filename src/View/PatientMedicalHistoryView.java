package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.authenticationController;
import Controller.doctorController;
import Model.Doctor;

import javax.swing.JScrollPane;
import javax.swing.DebugGraphics;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PatientMedicalHistoryView {

	private JFrame frmPatientHistory;
	private JTable tbl_history;
	
	private authenticationController authCtrl;
	private doctorController docCtrl;
	private Doctor details;
	
	private DefaultTableModel newRecordTbl;

	/**
	 * Create the application.
	 */
	public PatientMedicalHistoryView(long token, Doctor doctor, String patientId) {
		initialize(token,doctor, patientId);
		docCtrl.deserializeRecords();
		docCtrl.deserializeStatsList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long token, Doctor doctor, String patientId) {
		
		authCtrl = new authenticationController();
		details = (Doctor)authCtrl.getLoggedinUser(token);
		docCtrl = new doctorController(details);
		
		
		frmPatientHistory = new JFrame();
		frmPatientHistory.setTitle("Patient history");
		frmPatientHistory.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frmPatientHistory.setBounds(100, 100, 734, 571);
		//frmPatientHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientHistory.getContentPane().setLayout(null);
		
		frmPatientHistory.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				docCtrl.serializeRecords();
				docCtrl.serializeStatsList();
				frmPatientHistory.dispose();
				DoctorView docView = new DoctorView(token);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Patient Medical History");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 64, 282, 20);
		frmPatientHistory.getContentPane().add(lblNewLabel);
		
		JButton btn_addMedicalRecord = new JButton("Add Medical Record");
		btn_addMedicalRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewMedicalRecordView newMedicalRecord = new NewMedicalRecordView(token, patientId, doctor);
				frmPatientHistory.dispose();
			}
		});
		btn_addMedicalRecord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_addMedicalRecord.setBounds(80, 470, 214, 29);
		frmPatientHistory.getContentPane().add(btn_addMedicalRecord);
		
		JButton btn_editPatient = new JButton("View/Edit Patient Info");
		btn_editPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientDetailsView patientDetails = new PatientDetailsView(token, doctor, patientId);
				frmPatientHistory.dispose();
			}
		});
		btn_editPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_editPatient.setBounds(304, 470, 208, 29);
		frmPatientHistory.getContentPane().add(btn_editPatient);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 127, 575, 334);
		frmPatientHistory.getContentPane().add(scrollPane);
		
		tbl_history = new JTable();
		
		newRecordTbl = new DefaultTableModel();
		tbl_history .setModel(newRecordTbl);
		newRecordTbl.addColumn("Date");
		newRecordTbl.addColumn("Visit Purpose");
		newRecordTbl.addColumn("Visit Description");
		
		for (Integer key : docCtrl.getPatient(token, patientId).getMedicalRecords().keySet())
		{
			if (docCtrl.getPatient(token, patientId).getMedicalRecord(key, patientId, docCtrl.getDoctorID())!=null) {
				newRecordTbl.addRow(new Object[] {
					docCtrl.getPatient(token, patientId).getMedicalRecord(key, patientId,docCtrl.getDoctorID()).get_Date(),
					docCtrl.getPatient(token, patientId).getMedicalRecord(key, patientId, docCtrl.getDoctorID()).get_VisitPurpose(),
					docCtrl.getPatient(token, patientId).getMedicalRecord(key, patientId, docCtrl.getDoctorID()).get_VisitDescription()
					
				});
			}
		}
		
		
		tbl_history.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tbl_history.setBorder(null);
		tbl_history.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_history.setFocusable(false);
		tbl_history.setShowVerticalLines(false);
		tbl_history.setSelectionBackground(new Color(211, 211, 211));
		tbl_history.setRowMargin(0);
		tbl_history.setRowHeight(25);
		tbl_history.setIntercellSpacing(new Dimension(0, 0));
		
		tbl_history.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tbl_history.getTableHeader().setOpaque(false);
		tbl_history.getTableHeader().setBackground(new Color(32, 136, 203));
		tbl_history.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbl_history);
		frmPatientHistory.setVisible(true);
	}
}
