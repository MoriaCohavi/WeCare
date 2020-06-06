package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class NewDoctorView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDoctorView window = new NewDoctorView();
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
	public NewDoctorView() {
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
		
		JLabel lblNewDoctor = new JLabel("New Doctor");
		lblNewDoctor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewDoctor.setBounds(69, 80, 282, 20);
		frame.getContentPane().add(lblNewDoctor);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(69, 144, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(69, 180, 69, 20);
		frame.getContentPane().add(lblId);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhone.setBounds(69, 216, 69, 20);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(69, 255, 69, 20);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(69, 290, 69, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDailyPatient = new JLabel("Daily Patients");
		lblDailyPatient.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDailyPatient.setBounds(564, 252, 206, 20);
		frame.getContentPane().add(lblDailyPatient);
		
		JLabel lblDailySubscriptions = new JLabel("Daily Subscriptions");
		lblDailySubscriptions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDailySubscriptions.setBounds(564, 144, 176, 20);
		frame.getContentPane().add(lblDailySubscriptions);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSpecialization.setBounds(564, 180, 144, 20);
		frame.getContentPane().add(lblSpecialization);
		
		JLabel lblDailyVisitTime = new JLabel("Daily Visit Time");
		lblDailyVisitTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDailyVisitTime.setBounds(564, 216, 144, 20);
		frame.getContentPane().add(lblDailyVisitTime);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(69, 326, 144, 20);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(69, 362, 144, 20);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserType.setBounds(69, 402, 144, 20);
		frame.getContentPane().add(lblUserType);
		
		textField = new JTextField();
		textField.setBounds(221, 141, 206, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(221, 177, 206, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(221, 213, 206, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(221, 252, 206, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(221, 287, 206, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(221, 323, 206, 26);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(221, 359, 206, 26);
		frame.getContentPane().add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Manager", "Doctor", "Patient"}));
		comboBox.setBounds(221, 399, 206, 26);
		frame.getContentPane().add(comboBox);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(789, 141, 206, 26);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(789, 177, 206, 26);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(789, 213, 206, 26);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(789, 252, 206, 26);
		frame.getContentPane().add(textField_10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(906, 470, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSave.setBounds(776, 470, 115, 29);
		frame.getContentPane().add(btnSave);
	}

}
