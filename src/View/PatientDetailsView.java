package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PatientDetailsView {

	private JFrame frmPatientDetails;
	private JTextField txtf_name;
	private JTextField txtf_id;
	private JTextField txtf_phone;
	private JTextField txtf_address;
	private JTextField txtf_age;
	private JTextField txtf_weight;
	private JTextField txtf_height;
	private JTextField txtf_allergies;
	private JTextField txtf_chronicDiseases;
	private JTextField txtf_subscriptions;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientDetailsView window = new PatientDetailsView();
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
	public PatientDetailsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPatientDetails = new JFrame();
		frmPatientDetails.setTitle("Patient details");
		frmPatientDetails.setBounds(100, 100, 1058, 571);
		frmPatientDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmPatientDetails.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPatientDetails = new JLabel("Patient Details");
		lblPatientDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPatientDetails.setBounds(98, 88, 282, 20);
		panel.add(lblPatientDetails);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(98, 136, 69, 20);
		panel.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(98, 167, 69, 20);
		panel.add(lblId);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhone.setBounds(98, 200, 69, 20);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(98, 236, 97, 20);
		panel.add(lblAddress);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(98, 272, 69, 20);
		panel.add(lblAge);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeight.setBounds(98, 305, 69, 20);
		panel.add(lblWeight);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeight.setBounds(98, 334, 69, 20);
		panel.add(lblHeight);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAllergies.setBounds(98, 363, 97, 20);
		panel.add(lblAllergies);
		
		JLabel lblChronicDiseases = new JLabel("Chronic Diseases");
		lblChronicDiseases.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChronicDiseases.setBounds(98, 393, 146, 20);
		panel.add(lblChronicDiseases);
		
		JLabel lblSubscription = new JLabel("Subscription");
		lblSubscription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubscription.setBounds(98, 423, 146, 20);
		panel.add(lblSubscription);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(98, 459, 146, 20);
		panel.add(lblGender);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cancel.setBounds(866, 455, 115, 29);
		panel.add(btn_cancel);
		
		JButton btn_save = new JButton("Save");
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_save.setBounds(736, 455, 115, 29);
		panel.add(btn_save);
		
		txtf_name = new JTextField();
		txtf_name.setBounds(323, 133, 257, 26);
		panel.add(txtf_name);
		txtf_name.setColumns(10);
		
		txtf_id = new JTextField();
		txtf_id.setColumns(10);
		txtf_id.setBounds(323, 164, 257, 26);
		panel.add(txtf_id);
		
		txtf_phone = new JTextField();
		txtf_phone.setColumns(10);
		txtf_phone.setBounds(323, 197, 257, 26);
		panel.add(txtf_phone);
		
		txtf_address = new JTextField();
		txtf_address.setColumns(10);
		txtf_address.setBounds(323, 233, 257, 26);
		panel.add(txtf_address);
		
		txtf_age = new JTextField();
		txtf_age.setColumns(10);
		txtf_age.setBounds(323, 269, 257, 26);
		panel.add(txtf_age);
		
		txtf_weight = new JTextField();
		txtf_weight.setColumns(10);
		txtf_weight.setBounds(323, 302, 257, 26);
		panel.add(txtf_weight);
		
		txtf_height = new JTextField();
		txtf_height.setColumns(10);
		txtf_height.setBounds(323, 331, 257, 26);
		panel.add(txtf_height);
		
		txtf_allergies = new JTextField();
		txtf_allergies.setColumns(10);
		txtf_allergies.setBounds(323, 360, 257, 26);
		panel.add(txtf_allergies);
		
		txtf_chronicDiseases = new JTextField();
		txtf_chronicDiseases.setColumns(10);
		txtf_chronicDiseases.setBounds(323, 390, 257, 26);
		panel.add(txtf_chronicDiseases);
		
		txtf_subscriptions = new JTextField();
		txtf_subscriptions.setColumns(10);
		txtf_subscriptions.setBounds(323, 420, 257, 26);
		panel.add(txtf_subscriptions);
		
		JRadioButton radio_male = new JRadioButton("Male");
		radio_male.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radio_male.setBounds(323, 455, 155, 29);
		panel.add(radio_male);
		
		JRadioButton radio_female = new JRadioButton("Female");
		radio_female.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radio_female.setBounds(488, 455, 155, 29);
		panel.add(radio_female);
	}
}
