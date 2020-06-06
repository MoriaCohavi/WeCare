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

	private JFrame frame;
	private JTable table;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorView window = new DoctorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 1058, 571);
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
		
		table = new JTable();
		table.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		table.setBorder(null);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setFocusable(false);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(211, 211, 211));
		table.setRowMargin(0);
		table.setRowHeight(25);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setModel(new DefaultTableModel(
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
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		txtSearchPatient = new JTextField();
		txtSearchPatient.setForeground(Color.GRAY);
		txtSearchPatient.setSelectionColor(new Color(192, 192, 192));
		txtSearchPatient.setText("Search Patient...");
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
		
		btnNewButton_1 = new JButton("Get Daily Tests Reports");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(693, 475, 244, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(821, 133, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(821, 170, 146, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(821, 206, 146, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(821, 242, 146, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(821, 278, 146, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(821, 314, 146, 26);
		frame.getContentPane().add(textField_5);
	}
}
