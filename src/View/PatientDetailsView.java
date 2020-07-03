package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controller.doctorController;
import Controller.managerController;
import Model.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PatientDetailsView {

	private doctorController docCtrl;
	private managerController manCtrl;
	private JFrame frmPatient;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtAllergies;
	private JTextField txtCronicDiseases;
	private JTextField txtSubsriptions;

	/**
	 * Create the application.
	 */
	public PatientDetailsView(long token, Doctor doctor, String patientId) {
		initialize(token,doctor, patientId);
		docCtrl.deserializeRecords();
		docCtrl.deserializeStatsList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long token, Doctor doctor, String patientId) {
		docCtrl = new doctorController(doctor);
		manCtrl = new managerController();
		frmPatient = new JFrame();
		frmPatient.setTitle("Patient Details");
		frmPatient.setBounds(100, 100, 570, 600);

		JPanel panel = new JPanel();
		frmPatient.getContentPane().add(panel, BorderLayout.CENTER);
		
		try {
			
			frmPatient.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					docCtrl.serializeRecords();
					docCtrl.serializeStatsList();
					frmPatient.dispose();
					PatientMedicalHistoryView docView = new PatientMedicalHistoryView(token, doctor, patientId);
					
				}
			});
			
			BufferedImage img = ImageIO.read(new File("src\\view\\background2Img.jpg"));
			Image dimg = img.getScaledInstance(600, 561, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0, 0, 550, 561);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmPatient.setIconImage(dimg2);

			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(40, 45, 160, 15);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
						
			JLabel lblID = new JLabel("ID");
			lblID.setBounds(40, 80, 160, 15);
			lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
						
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(40, 115, 160, 15);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
						
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setBounds(38, 149, 160, 15);
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
						
			JLabel lblAge = new JLabel("Age");
			lblAge.setBounds(38, 189, 160, 15);
			lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lblHeight = new JLabel("Height");
			lblHeight.setBounds(38, 224, 160, 15);
			lblHeight.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblWeight = new JLabel("Weight");
			lblWeight.setBounds(38, 259, 160, 15);
			lblWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblAllergies = new JLabel("Allergies");
			lblAllergies.setBounds(38, 294, 160, 15);
			lblAllergies.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblCronicDiseases = new JLabel("Cronic Diseases");
			lblCronicDiseases.setBounds(38, 325, 160, 15);
			lblCronicDiseases.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lblSubsriptions = new JLabel("Subsriptions");
			lblSubsriptions.setBounds(38, 356, 160, 15);
			lblSubsriptions.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			txtName = new JTextField(docCtrl.getPatientName(patientId));
			txtName.setEnabled(false);
			txtName.setBounds(250, 45, 160, 15);
			panel.add(txtName);
			txtName.setColumns(10);
			
			txtID = new JTextField(patientId);
			txtID.setEnabled(false);
			txtID.setColumns(10);
			txtID.setBounds(250, 80, 160, 15);
			panel.add(txtID);
			
			txtEmail = new JTextField(docCtrl.getPatientEmail(patientId));
			txtEmail.setColumns(10);
			txtEmail.setBounds(250, 115, 160, 15);
			
			
			txtPhone = new JTextField(String.valueOf(docCtrl.getPatientPhone(patientId)));
			txtPhone.setColumns(10);
			txtPhone.setBounds(248, 149, 160, 15);
			
			
			txtAge = new JTextField(String.valueOf(docCtrl.getPatientAge(patientId)));
			txtAge.setEnabled(false);
			txtAge.setColumns(10);
			txtAge.setBounds(248, 184, 160, 15);
			
			
			txtHeight = new JTextField(String.valueOf(docCtrl.getPatientHeight(patientId)));
			txtHeight.setEnabled(false);
			txtHeight.setColumns(10);
			txtHeight.setBounds(248, 219, 160, 15);
			
			
			txtWeight = new JTextField(String.valueOf(docCtrl.getPatientWeight(patientId)));
			txtWeight.setEnabled(false);
			txtWeight.setColumns(10);
			txtWeight.setBounds(248, 254, 160, 15);
			
			
			txtAllergies = new JTextField(docCtrl.getPatientAllergic(patientId));
			txtAllergies.setColumns(10);
			txtAllergies.setBounds(248, 289, 160, 15);
			
				
			txtCronicDiseases = new JTextField(docCtrl.getPatientChronicDiseases(patientId));
			txtCronicDiseases.setColumns(10);
			txtCronicDiseases.setBounds(248, 320, 160, 15);
			
			
			txtSubsriptions = new JTextField(docCtrl.getPatientSubscription(patientId));
			txtSubsriptions.setColumns(10);
			txtSubsriptions.setBounds(248, 350, 160, 15);
			
			
			JButton btnEdit = new JButton("Save");
			btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEdit.setBounds(40, 441, 85, 21);
						
			JButton btnDelete = new JButton("Delete");
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnDelete.setBounds(139, 441, 85, 21);
			
			panel.setLayout(null);
			panel.add(lblName);
			panel.add(lblID);
			panel.add(lblEmail);
			panel.add(lblPhone);
			panel.add(lblAge);
			panel.add(lblHeight);
			panel.add(lblWeight);
			panel.add(lblAllergies);
			panel.add(lblCronicDiseases);			
			panel.add(lblSubsriptions);
			panel.add(txtEmail);
			panel.add(txtPhone);
			panel.add(txtAge);
			panel.add(txtHeight);
			panel.add(txtWeight);
			panel.add(txtAllergies);
			panel.add(txtCronicDiseases);
			panel.add(txtSubsriptions);
			panel.add(btnEdit);
			panel.add(btnDelete);
			panel.add(backgroundLabel);
			frmPatient.setVisible(true);
			
			btnEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					docCtrl.updatePatientInfo(token, patientId, txtEmail.getText(), Long.parseLong(txtPhone.getText()), txtAllergies.getText(), txtCronicDiseases.getText(), txtSubsriptions.getText());
					docCtrl.serializeRecords();
					docCtrl.serializeStatsList();
					docCtrl.serializePatients();
					frmPatient.dispose();
					PatientMedicalHistoryView docView = new PatientMedicalHistoryView(token, doctor, patientId);
				}
			});
			
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					docCtrl.deletePatient(token,patientId);
					docCtrl.serializePatients();
					docCtrl.serializeRecords();
					docCtrl.serializeStatsList();
					frmPatient.dispose();
					DoctorView docView = new DoctorView(token);
				}
			});
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
