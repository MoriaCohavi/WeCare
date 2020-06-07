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
import java.awt.Dimension;
import javax.swing.DebugGraphics;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

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
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
	public DoctorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDoctor = new JFrame();
		frmDoctor.setTitle("Doctor");
		frmDoctor.setBounds(100, 100, 1058, 571);
		frmDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctor.getContentPane().setLayout(null);
		
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
		tbl_doctors.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "moria", "123"},
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
		
		lblName = new JLabel("ID");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(693, 172, 119, 20);
		frmDoctor.getContentPane().add(lblName);
		
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
		
		btnNewButton_1 = new JButton("Get Daily Tests Reports");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(693, 475, 244, 29);
		frmDoctor.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(821, 133, 146, 26);
		frmDoctor.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(821, 170, 146, 26);
		frmDoctor.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(821, 206, 146, 26);
		frmDoctor.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(821, 242, 146, 26);
		frmDoctor.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(821, 278, 146, 26);
		frmDoctor.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(821, 314, 146, 26);
		frmDoctor.getContentPane().add(textField_5);
	}
}
