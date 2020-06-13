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
import javax.swing.JScrollPane;
import javax.swing.DebugGraphics;
import java.awt.Dimension;
import java.awt.Scrollbar;

public class PatientMedicalHistoryView {

	private JFrame frmPatientHistory;
	private JTable tbl_history;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientMedicalHistoryView window = new PatientMedicalHistoryView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PatientMedicalHistoryView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPatientHistory = new JFrame();
		frmPatientHistory.setTitle("Patient history");
		frmPatientHistory.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frmPatientHistory.setBounds(100, 100, 1058, 571);
		frmPatientHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientHistory.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Medical History");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 64, 282, 20);
		frmPatientHistory.getContentPane().add(lblNewLabel);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_name.setBounds(698, 112, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_name);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_id.setBounds(698, 143, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_id);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_address.setBounds(698, 214, 79, 20);
		frmPatientHistory.getContentPane().add(lbl_address);
		
		JLabel lbl_phone = new JLabel("Phone");
		lbl_phone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_phone.setBounds(698, 178, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_phone);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_email.setBounds(698, 244, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_email);
		
		JLabel lbl_age = new JLabel("Age");
		lbl_age.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_age.setBounds(698, 269, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_age);
		
		JLabel lbl_weight = new JLabel("Weight");
		lbl_weight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_weight.setBounds(698, 298, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_weight);
		
		JLabel lbl_height = new JLabel("Height");
		lbl_height.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_height.setBounds(917, 112, 69, 20);
		frmPatientHistory.getContentPane().add(lbl_height);
		
		JLabel lbl_allergies = new JLabel("Allergies");
		lbl_allergies.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_allergies.setBounds(917, 143, 97, 20);
		frmPatientHistory.getContentPane().add(lbl_allergies);
		
		JLabel lbl_chronicDeseas = new JLabel("Chronic Diseases");
		lbl_chronicDeseas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_chronicDeseas.setBounds(916, 178, 144, 20);
		frmPatientHistory.getContentPane().add(lbl_chronicDeseas);
		
		JLabel lbl_subscriptions = new JLabel("Subscriptions");
		lbl_subscriptions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_subscriptions.setBounds(917, 214, 144, 20);
		frmPatientHistory.getContentPane().add(lbl_subscriptions);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_gender.setBounds(917, 244, 144, 20);
		frmPatientHistory.getContentPane().add(lbl_gender);
		
		JButton btn_addVisit = new JButton("Add Visit");
		btn_addVisit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_addVisit.setBounds(80, 470, 115, 29);
		frmPatientHistory.getContentPane().add(btn_addVisit);
		
		JButton btn_editPatient = new JButton("Edit Patient Info");
		btn_editPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_editPatient.setBounds(852, 425, 169, 29);
		frmPatientHistory.getContentPane().add(btn_editPatient);
		
		JButton btn_deletePatient = new JButton("Delete Patient");
		btn_deletePatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_deletePatient.setBounds(852, 470, 169, 29);
		frmPatientHistory.getContentPane().add(btn_deletePatient);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 127, 575, 334);
		frmPatientHistory.getContentPane().add(scrollPane);
		
		tbl_history = new JTable();
		tbl_history.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tbl_history.setBorder(null);
		tbl_history.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_history.setFocusable(false);
		tbl_history.setShowVerticalLines(false);
		tbl_history.setSelectionBackground(new Color(211, 211, 211));
		tbl_history.setRowMargin(0);
		tbl_history.setRowHeight(25);
		tbl_history.setIntercellSpacing(new Dimension(0, 0));
		tbl_history.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Num.", "Date", "Specialization"
			}
		));
		tbl_history.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tbl_history.getTableHeader().setOpaque(false);
		tbl_history.getTableHeader().setBackground(new Color(32, 136, 203));
		tbl_history.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbl_history);
	}
}
