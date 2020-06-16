package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Controller.*;
import Controller.managerController;
import Model.Doctor;
import Model.Manager;

public class ManagerView {

	private JFrame frame;
	private JTable tbl_managers;
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
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtClinicName;
	private managerController ManagerCtrl;
	private Manager details;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerView window = new ManagerView();
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
	public ManagerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		details = ManagerCtrl.getDetails();
		frame = new JFrame();
		frame.setBounds(100, 100, 1058, 571);
		frame.setTitle("Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(80, 58, 282, 20);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblWelcome);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 127, 575, 334);
		frame.getContentPane().add(scrollPane);
		
		tbl_managers = new JTable();
		tbl_managers.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tbl_managers.setBorder(null);
		tbl_managers.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_managers.setFocusable(false);
		tbl_managers.setShowVerticalLines(false);
		tbl_managers.setSelectionBackground(new Color(211, 211, 211));
		tbl_managers.setRowMargin(0);
		tbl_managers.setRowHeight(25);
		tbl_managers.setIntercellSpacing(new Dimension(0, 0));
		tbl_managers.setModel(new DefaultTableModel(
			new Object[][] {
				{"moria", "123"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null}
			},
			new String[] {
				"Doctor", "Specialization"
			}
		));
		tbl_managers.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tbl_managers.getTableHeader().setOpaque(false);
		tbl_managers.getTableHeader().setBackground(new Color(32, 136, 203));
		tbl_managers.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbl_managers);
		
		txtSearchPatient = new JTextField();
		txtSearchPatient.setForeground(Color.GRAY);
		txtSearchPatient.setSelectionColor(new Color(192, 192, 192));
		txtSearchPatient.setText("Search Doctor...");
		txtSearchPatient.setBounds(80, 477, 311, 26);
		frame.getContentPane().add(txtSearchPatient);
		txtSearchPatient.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(405, 477, 96, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnAddPatient = new JButton("Add Patient");
		btnAddPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddPatient.setBounds(516, 477, 139, 29);
		frame.getContentPane().add(btnAddPatient);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(693, 136, 119, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblName = new JLabel("ID");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(693, 172, 119, 20);
		frame.getContentPane().add(lblName);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(693, 208, 119, 20);
		frame.getContentPane().add(lblPhone);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(693, 244, 119, 20);
		frame.getContentPane().add(lblAddress);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(693, 280, 119, 20);
		frame.getContentPane().add(lblEmail);
		
		lblClinicName = new JLabel("Clinic Name");
		lblClinicName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClinicName.setBounds(693, 316, 119, 20);
		frame.getContentPane().add(lblClinicName);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(670, 127, 351, 379);
		frame.getContentPane().add(separator);
		
		btnNewButton_1 = new JButton("View Statistical Reports");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(693, 475, 244, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		txtName = new JTextField();
		txtName.setText(details.getName());
		txtName.setEnabled(false);
		txtName.setBounds(821, 133, 146, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setText(details.getID());
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(821, 170, 146, 26);
		frame.getContentPane().add(txtID);
		
		txtPhone = new JTextField();
//		txtPhone.setText(details.getPhone());
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(821, 206, 146, 26);
		frame.getContentPane().add(txtPhone);
		
		txtAddress = new JTextField();
//		txtAddress.setText(details.getAddress());
		txtAddress.setEnabled(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(821, 242, 146, 26);
		frame.getContentPane().add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.setText(details.getEmail());
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(821, 278, 146, 26);
		frame.getContentPane().add(txtEmail);
		
		txtClinicName = new JTextField();
//		txtEmail.setText(details.getClinic());
		txtClinicName.setEnabled(false);
		txtClinicName.setColumns(10);
		txtClinicName.setBounds(821, 314, 146, 26);
		frame.getContentPane().add(txtClinicName);
		frame.setVisible(true);
		
	}
}
