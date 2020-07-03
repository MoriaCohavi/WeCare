package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.JPanel;
//import com.toedter.calendar.JDayChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.doctorController;
import Controller.managerController;
import Model.*;

import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JSeparator;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.*;

public class NewMedicalRecordView {

	private AddMedicalIndices addIndicesView;
	private MedicalIndices medIndices;
	private doctorController docCtrl;
	private managerController manCtrl;
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
		docCtrl.deserializeRecords();
		docCtrl.deserializeStatsList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken, String patientID, Doctor doctor) {
		medIndices = null;
		docCtrl = new doctorController(doctor);
		manCtrl = new managerController();
		frmMedicalRecord = new JFrame();
		frmMedicalRecord.setTitle("Medical record");
		frmMedicalRecord.setBounds(100, 100, 1058, 571);
		
		JPanel panel = new JPanel();
		frmMedicalRecord.getContentPane().add(panel, BorderLayout.CENTER);
		
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\backgroundImg.jpg"));
			Image dimg = img.getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0, 0, 1042, 532);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmMedicalRecord.setIconImage(dimg2);
			
			frmMedicalRecord.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					docCtrl.serializeRecords();
					docCtrl.serializeStatsList();
					frmMedicalRecord.dispose();
					PatientMedicalHistoryView docView = new PatientMedicalHistoryView(doctorToken, doctor, patientID);
					
				}
			});
			panel.setLayout(null);
			
			JLabel lbl_doctorId = new JLabel("Patient ID: " + patientID);
			lbl_doctorId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbl_doctorId.setBounds(31, 49, 219, 20);
			panel.add(lbl_doctorId);
			
			JLabel label_5 = new JLabel("Visit Purpose");
			label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_5.setBounds(31, 133, 118, 20);
			panel.add(label_5);
			
			JLabel label_6 = new JLabel("Visit Description");
			label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_6.setBounds(31, 186, 170, 20);
			panel.add(label_6);
			
			JLabel label_7 = new JLabel("Diagnostic Description");
			label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_7.setBounds(32, 261, 193, 20);
			panel.add(label_7);
			
			JLabel label_8 = new JLabel("Visit Summary");
			label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_8.setBounds(31, 338, 155, 20);
			panel.add(label_8);
			
			JLabel label_9 = new JLabel("Subscriptions");
			label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_9.setBounds(31, 404, 154, 20);
			panel.add(label_9);
			
			JLabel label_10 = new JLabel("Days Of Illnes Approval");
			label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_10.setBounds(31, 467, 219, 20);
			panel.add(label_10);
			
			JButton btn_save = new JButton("Save");
			btn_save.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_save.setBounds(765, 458, 115, 29);
			panel.add(btn_save);
			
			JButton btn_cancel = new JButton("Cancel");
			btn_cancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					docCtrl.serializeRecords();
					docCtrl.serializeStatsList();
					frmMedicalRecord.dispose();
					PatientMedicalHistoryView docView = new PatientMedicalHistoryView(doctorToken, doctor, patientID);
					
				}
			});
			btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_cancel.setBounds(895, 458, 115, 29);
			panel.add(btn_cancel);
			
			txtf_visitSummary = new JTextField();
			txtf_visitSummary.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtf_visitSummary.setColumns(10);
			txtf_visitSummary.setBounds(298, 338, 272, 47);
			panel.add(txtf_visitSummary);
			
			txtf_illnesDays = new JTextField();
			txtf_illnesDays.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtf_illnesDays.setColumns(10);
			txtf_illnesDays.setBounds(298, 464, 79, 26);
			panel.add(txtf_illnesDays);
			
			txtf_subscriptions = new JTextField();
			txtf_subscriptions.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtf_subscriptions.setColumns(10);
			txtf_subscriptions.setBounds(298, 401, 272, 47);
			panel.add(txtf_subscriptions);
			
			txtf_diagnostic = new JTextField();
			txtf_diagnostic.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtf_diagnostic.setColumns(10);
			txtf_diagnostic.setBounds(298, 261, 272, 47);
			panel.add(txtf_diagnostic);
			
			txtf_visistDesc = new JTextField();
			txtf_visistDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtf_visistDesc.setColumns(10);
			txtf_visistDesc.setBounds(298, 186, 272, 47);
			panel.add(txtf_visistDesc);
			
			JButton btn_addLabs = new JButton("Add Lab Results");
			btn_addLabs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AddLabView labView = new AddLabView(doctorToken, patientID, doctor);
				}
			});
			btn_addLabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_addLabs.setBounds(765, 413, 245, 29);
			panel.add(btn_addLabs);
			
			JButton btn_addMedicalIndices = new JButton("Add Medical Indices");
			btn_addMedicalIndices.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addIndicesView = new AddMedicalIndices();
				}
			});
			btn_addMedicalIndices.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_addMedicalIndices.setBounds(765, 368, 245, 29);
			panel.add(btn_addMedicalIndices);
			
			JButton btn_GetDayOf = new JButton("Get Days Of Illnes Approval");
			btn_GetDayOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_GetDayOf.setBounds(765, 321, 245, 29);
			panel.add(btn_GetDayOf);
			
			JComboBox combo_purpose = new JComboBox();
			combo_purpose.setFont(new Font("Tahoma", Font.PLAIN, 14));
			combo_purpose.setModel(new DefaultComboBoxModel(new String[] {"Select", "High Fiver", "Cuagh", "Ingert", "Other"}));
			combo_purpose.setBounds(298, 130, 272, 26);
			panel.add(combo_purpose);
			
			JLabel lblWarning = new JLabel("");
			lblWarning.setBounds(31, 79, 500, 13);
			panel.add(lblWarning);
			
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
							docCtrl.openNewMedicalRecord(doctorToken, patientID, Integer.parseInt(txtf_illnesDays.getText()), String.valueOf(combo_purpose.getSelectedItem()), txtf_visistDesc.getText(), txtf_visitSummary.getText(), txtf_subscriptions.getText(), txtf_diagnostic.getText(), medIndices.getWeight(), medIndices.getHeight(), medIndices.getHeartRate(), medIndices.getTemperature(), medIndices.getSystolicBP(), medIndices.getDiastolicBP());
							docCtrl.serializeRecords();
							manCtrl.serialize();
							docCtrl.serializeRecords();
							docCtrl.serializeStatsList();
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
			
			panel.add(backgroundLabel);
			frmMedicalRecord.setVisible(true);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
