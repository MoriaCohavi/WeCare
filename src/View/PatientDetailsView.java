package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.authenticationController;
import Controller.doctorController;
import Model.Doctor;

import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private authenticationController authCtrl;
	private doctorController docCtrl;
	private JTextField txtf_email;

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
	public PatientDetailsView(long doctorToken) {
		initialize(doctorToken);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken) {
		authCtrl = new authenticationController();
		docCtrl = new doctorController((Doctor)authCtrl.getLoggedinUser(doctorToken));
		
		frmPatientDetails = new JFrame();
		frmPatientDetails.setTitle("Patient details");
		frmPatientDetails.setBounds(100, 100, 1058, 571);
		frmPatientDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmPatientDetails.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmPatientDetails.dispose();
				
			}
		});
		
		JPanel panel = new JPanel();
		frmPatientDetails.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPatientDetails = new JLabel("Patient Details");
		lblPatientDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPatientDetails.setBounds(98, 42, 282, 20);
		panel.add(lblPatientDetails);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(98, 88, 69, 20);
		panel.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(98, 119, 69, 20);
		panel.add(lblId);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhone.setBounds(98, 152, 69, 20);
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
		txtf_name.setBounds(323, 85, 257, 26);
		panel.add(txtf_name);
		txtf_name.setColumns(10);
		
		txtf_id = new JTextField();
		txtf_id.setColumns(10);
		txtf_id.setBounds(323, 116, 257, 26);
		panel.add(txtf_id);
		
		txtf_phone = new JTextField();
		txtf_phone.setColumns(10);
		txtf_phone.setBounds(323, 149, 257, 26);
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
		
		ButtonGroup btn_group = new ButtonGroup();
		btn_group.add(radio_male);
		btn_group.add(radio_female);
		
		JLabel lbl_warning = new JLabel("");
		lbl_warning.setBounds(732, 398, 282, 15);
		panel.add(lbl_warning);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(98, 186, 69, 20);
		panel.add(lblEmail);
		
		txtf_email = new JTextField();
		txtf_email.setColumns(10);
		txtf_email.setBounds(323, 186, 257, 26);
		panel.add(txtf_email);
		
		JButton btnNewButton = new JButton("Add Medical Record");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//create&add new window
			}
		});
		btnNewButton.setBounds(746, 182, 222, 29);
		panel.add(btnNewButton);
		frmPatientDetails.setVisible(true);
		
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ((txtf_id.getText() != null && txtf_id.getText().length() != 9) || txtf_name.getText() == null)
					lbl_warning.setText("Please! Put valid ID of 9 digits, name and password");
				else
				{
					String gender;
					if (radio_male.isSelected())
						gender = "Male";
					else
						gender = "Female";
					try
					{
						Long.parseLong(txtf_phone.getText());
						Integer.parseInt(txtf_age.getText());
						Integer.parseInt(txtf_weight.getText());
						Integer.parseInt(txtf_height.getText());
					}
					catch (Exception e)
					{
						lbl_warning.setText("Age, phone, weight and height should include digits only !");
					}
					if (!(docCtrl.addNewPatient(txtf_id.getText(), Integer.parseInt(txtf_age.getText()), Long.parseLong(txtf_phone.getText()), txtf_name.getText(), txtf_email.getText(), Integer.parseInt(txtf_weight.getText()), 
							Integer.parseInt(txtf_height.getText()), gender, txtf_allergies.getText(), txtf_subscriptions.getText(), txtf_chronicDiseases.getText())))
						lbl_warning.setText("User exists");
					else
						frmPatientDetails.dispose();
				}
			}
		});
	}
}
