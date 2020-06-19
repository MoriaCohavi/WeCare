package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.JPanel;
//import com.toedter.calendar.JDayChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

import Controller.doctorController;
import Model.*;

import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JSeparator;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.*;

public class NewMedicalRecordView {

	private AddMedicalIndices addIndicesView;
	private MedicalIndices medIndices;
	private doctorController docCtrl;
	private JFrame frmMedicalRecord;
	private JTextField txtf_visitSummary;
	private JTextField txtf_illnesDays;
	private JTextField txtf_subscriptions;
	private JTextField txtf_diagnostic;
	private JTextField txtf_visistDesc;

	/**
	 * Create the application.
	 */
	public NewMedicalRecordView(long doctorToken, String patientID, Doctor doctor) {
		initialize(doctorToken, patientID, doctor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken, String patientID, Doctor doctor) {
		medIndices = null;
		docCtrl = new doctorController(doctor);
		frmMedicalRecord = new JFrame();
		frmMedicalRecord.setTitle("Medical record");
		frmMedicalRecord.setBounds(100, 100, 1058, 571);
		//frmMedicalRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicalRecord.getContentPane().setLayout(null);
		
		frmMedicalRecord.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmMedicalRecord.dispose();
				PatientMedicalHistoryView docView = new PatientMedicalHistoryView(doctorToken, doctor, patientID);
				
			}
		});
		
		JLabel lbl_doctorId = new JLabel("Patient ID: ");
		lbl_doctorId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_doctorId.setBounds(31, 16, 118, 20);
		frmMedicalRecord.getContentPane().add(lbl_doctorId);
		
		JLabel label_5 = new JLabel("Visit Purpose");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(31, 133, 118, 20);
		frmMedicalRecord.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Visit Description");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(31, 186, 170, 20);
		frmMedicalRecord.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Diagnostic Description");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(32, 261, 193, 20);
		frmMedicalRecord.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Visit Summary");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(31, 338, 155, 20);
		frmMedicalRecord.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Subscriptions");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(31, 404, 154, 20);
		frmMedicalRecord.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Days Of Illnes Approval");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(31, 467, 219, 20);
		frmMedicalRecord.getContentPane().add(label_10);
		
		JButton btn_save = new JButton("Save");
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_save.setBounds(765, 458, 115, 29);
		frmMedicalRecord.getContentPane().add(btn_save);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmMedicalRecord.dispose();
				PatientMedicalHistoryView docView = new PatientMedicalHistoryView(doctorToken, doctor, patientID);
				
			}
		});
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cancel.setBounds(895, 458, 115, 29);
		frmMedicalRecord.getContentPane().add(btn_cancel);
		
		txtf_visitSummary = new JTextField();
		txtf_visitSummary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtf_visitSummary.setColumns(10);
		txtf_visitSummary.setBounds(298, 338, 272, 47);
		frmMedicalRecord.getContentPane().add(txtf_visitSummary);
		
		txtf_illnesDays = new JTextField();
		txtf_illnesDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtf_illnesDays.setColumns(10);
		txtf_illnesDays.setBounds(298, 464, 79, 26);
		frmMedicalRecord.getContentPane().add(txtf_illnesDays);
		
		txtf_subscriptions = new JTextField();
		txtf_subscriptions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtf_subscriptions.setColumns(10);
		txtf_subscriptions.setBounds(298, 401, 272, 47);
		frmMedicalRecord.getContentPane().add(txtf_subscriptions);
		
		txtf_diagnostic = new JTextField();
		txtf_diagnostic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtf_diagnostic.setColumns(10);
		txtf_diagnostic.setBounds(298, 261, 272, 47);
		frmMedicalRecord.getContentPane().add(txtf_diagnostic);
		
		txtf_visistDesc = new JTextField();
		txtf_visistDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtf_visistDesc.setColumns(10);
		txtf_visistDesc.setBounds(298, 186, 272, 47);
		frmMedicalRecord.getContentPane().add(txtf_visistDesc);
		
		JButton btn_addLabs = new JButton("Add Lab Results");
		btn_addLabs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_addLabs.setBounds(765, 413, 245, 29);
		frmMedicalRecord.getContentPane().add(btn_addLabs);
		
		JButton btn_addMedicalIndices = new JButton("Add Medical Indices");
		btn_addMedicalIndices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addIndicesView = new AddMedicalIndices();
			}
		});
		btn_addMedicalIndices.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_addMedicalIndices.setBounds(765, 368, 245, 29);
		frmMedicalRecord.getContentPane().add(btn_addMedicalIndices);
		
		JButton btn_GetDayOf = new JButton("Get Days Of Illnes Approval");
		btn_GetDayOf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_GetDayOf.setBounds(765, 321, 245, 29);
		frmMedicalRecord.getContentPane().add(btn_GetDayOf);
		
		JComboBox combo_purpose = new JComboBox();
		combo_purpose.setFont(new Font("Tahoma", Font.PLAIN, 17));
		combo_purpose.setModel(new DefaultComboBoxModel(new String[] {"Select", "High Fiver", "Cuagh", "Ingert"}));
		combo_purpose.setBounds(298, 130, 272, 26);
		frmMedicalRecord.getContentPane().add(combo_purpose);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setBounds(31, 79, 500, 13);
		frmMedicalRecord.getContentPane().add(lblWarning);
		
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				medIndices = addIndicesView.getLastMedicalIndices();
				if (medIndices == null)
				{
					lblWarning.setText("Indices were not set !");
				}
				else
				{
					try
					{
						docCtrl.openNewMedicalRecord(doctorToken, patientID, Integer.parseInt(txtf_illnesDays.getText()), String.valueOf(combo_purpose.getSelectedItem()), txtf_visistDesc.getText(), txtf_visitSummary.getText(), txtf_subscriptions.getText(), txtf_diagnostic.getText(), LocalTime.now(), LocalTime.now(), medIndices.getWeight(), medIndices.getHeight(), medIndices.getHeartRate(), medIndices.getTemperature(), medIndices.getSystolicBP(), medIndices.getDiastolicBP());
						docCtrl.serializeRecords();
						frmMedicalRecord.dispose();
						PatientMedicalHistoryView docView = new PatientMedicalHistoryView(doctorToken, doctor, patientID);
					}
					catch (Exception excp)
					{
						lblWarning.setText("Insert valid illnes days !");
					}
				}
			}
		});
		
		frmMedicalRecord.setVisible(true);
	}
}
