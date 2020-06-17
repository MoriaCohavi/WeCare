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
import Model.Patient;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddPatientView {

	private JFrame frmPatientDetails;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtAge;
	private JTextField txtWeight;
	private JTextField txtHeight;
	private JTextField txtAllergies;
	private JTextField txtChronicDiseases;
	private JTextField txtSubscriptions;
	private authenticationController authCtrl;
	private doctorController docCtrl;
	private JTextField txtEmail;

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
	public AddPatientView(long doctorToken) {
		initialize(doctorToken);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken) {
		authCtrl = new authenticationController();
		docCtrl = new doctorController((Doctor)authCtrl.getLoggedinUser(doctorToken));
		
		frmPatientDetails = new JFrame();
		frmPatientDetails.setTitle("Add Patient");
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
		
		JLabel lblAddPatient = new JLabel("Add Patient");
		lblAddPatient.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddPatient.setBounds(98, 42, 282, 20);
		panel.add(lblAddPatient);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(98, 88, 69, 20);
		panel.add(lblName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblID.setBounds(98, 119, 69, 20);
		panel.add(lblID);
		
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
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.setBounds(866, 455, 115, 29);
		panel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSave.setBounds(736, 455, 115, 29);
		panel.add(btnSave);
		
		txtName = new JTextField();
		txtName.setBounds(323, 85, 257, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(323, 116, 257, 26);
		panel.add(txtID);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(323, 149, 257, 26);
		panel.add(txtPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(323, 233, 257, 26);
		panel.add(txtAddress);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(323, 269, 257, 26);
		panel.add(txtAge);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(323, 302, 257, 26);
		panel.add(txtWeight);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(323, 331, 257, 26);
		panel.add(txtHeight);
		
		txtAllergies = new JTextField();
		txtAllergies.setColumns(10);
		txtAllergies.setBounds(323, 360, 257, 26);
		panel.add(txtAllergies);
		
		txtChronicDiseases = new JTextField();
		txtChronicDiseases.setColumns(10);
		txtChronicDiseases.setBounds(323, 390, 257, 26);
		panel.add(txtChronicDiseases);
		
		txtSubscriptions = new JTextField();
		txtSubscriptions.setColumns(10);
		txtSubscriptions.setBounds(323, 420, 257, 26);
		panel.add(txtSubscriptions);
		
		JRadioButton radioMale = new JRadioButton("Male");
		radioMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioMale.setBounds(323, 455, 155, 29);
		panel.add(radioMale);
		
		JRadioButton radioFemale = new JRadioButton("Female");
		radioFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioFemale.setBounds(488, 455, 155, 29);
		panel.add(radioFemale);
		
		ButtonGroup btn_group = new ButtonGroup();
		btn_group.add(radioMale);
		btn_group.add(radioFemale);
		
		JLabel lbl_warning = new JLabel("");
		lbl_warning.setBounds(732, 398, 282, 15);
		panel.add(lbl_warning);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(98, 186, 69, 20);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(323, 186, 257, 26);
		panel.add(txtEmail);
		frmPatientDetails.setVisible(true);
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ((txtID.getText() != null && txtID.getText().length() != 9) || txtName.getText() == null)
					lbl_warning.setText("Please! Put valid ID of 9 digits, name and password");
				else
				{
					String gender;
					if (radioMale.isSelected())
						gender = "Male";
					else
						gender = "Female";
					try
					{
						Long.parseLong(txtPhone.getText());
						Integer.parseInt(txtAge.getText());
						Integer.parseInt(txtWeight.getText());
						Integer.parseInt(txtHeight.getText());
					}
					catch (Exception e)
					{
						lbl_warning.setText("Age, phone, weight and height should include digits only !");
					}
					if (!(docCtrl.addNewPatient(txtID.getText(), Integer.parseInt(txtAge.getText()), Long.parseLong(txtPhone.getText()), txtName.getText(), txtEmail.getText(), Integer.parseInt(txtWeight.getText()), 
							Integer.parseInt(txtHeight.getText()), gender, txtAllergies.getText(), txtSubscriptions.getText(), txtChronicDiseases.getText())))
						lbl_warning.setText("User exists");
					else
						frmPatientDetails.dispose();
				}
			}
		});
	}
}
