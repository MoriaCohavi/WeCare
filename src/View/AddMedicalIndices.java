package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import Model.MedicalIndices;

public class AddMedicalIndices {

	private static MedicalIndices medIndices = null;
	private JFrame frmAddMedicalIndices;
	private JTextField txtf_height;
	private JTextField txtf_weight;
	private JTextField txtf_heartRate;
	private JTextField txtf_systolic;
	private JTextField txtf_dialostic;
	private JTextField txtf_temp;

	/**
	 * Create the application.
	 */
	public AddMedicalIndices() {
		initialize();
	}
	
	public static MedicalIndices getLastMedicalIndices()
	{
		return medIndices;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		medIndices = null;
		frmAddMedicalIndices = new JFrame();
		frmAddMedicalIndices.setTitle("Add Medical Indices");
		frmAddMedicalIndices.setBounds(100, 100, 454, 423);
		frmAddMedicalIndices.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAddMedicalIndices.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(52, 57, 45, 13);
		panel.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(52, 93, 45, 13);
		panel.add(lblWeight);
		
		JLabel lblHeartRate = new JLabel("Heart rate:");
		lblHeartRate.setBounds(52, 130, 105, 13);
		panel.add(lblHeartRate);
		
		JLabel lblSystolicBP = new JLabel("Systolic BP:");
		lblSystolicBP.setBounds(52, 169, 82, 13);
		panel.add(lblSystolicBP);
		
		JLabel lblDialosticBP = new JLabel("Dialostic BP:");
		lblDialosticBP.setBounds(52, 208, 82, 13);
		panel.add(lblDialosticBP);
		
		JLabel lblTemp = new JLabel("Temperature:");
		lblTemp.setBounds(52, 248, 82, 13);
		panel.add(lblTemp);
		
		txtf_height = new JTextField();
		txtf_height.setBounds(162, 54, 96, 19);
		panel.add(txtf_height);
		txtf_height.setColumns(10);
		
		txtf_weight = new JTextField();
		txtf_weight.setColumns(10);
		txtf_weight.setBounds(162, 90, 96, 19);
		panel.add(txtf_weight);
		
		txtf_heartRate = new JTextField();
		txtf_heartRate.setColumns(10);
		txtf_heartRate.setBounds(162, 127, 96, 19);
		panel.add(txtf_heartRate);
		
		txtf_systolic = new JTextField();
		txtf_systolic.setColumns(10);
		txtf_systolic.setBounds(162, 166, 96, 19);
		panel.add(txtf_systolic);
		
		txtf_dialostic = new JTextField();
		txtf_dialostic.setColumns(10);
		txtf_dialostic.setBounds(162, 205, 96, 19);
		panel.add(txtf_dialostic);
		
		txtf_temp = new JTextField();
		txtf_temp.setColumns(10);
		txtf_temp.setBounds(162, 245, 96, 19);
		panel.add(txtf_temp);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(52, 310, 85, 21);
		panel.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medIndices = new MedicalIndices(Integer.parseInt(txtf_weight.getText()), Integer.parseInt(txtf_height.getText()), Integer.parseInt(txtf_heartRate.getText()), Integer.parseInt(txtf_temp.getText()), Integer.parseInt(txtf_systolic.getText()), Integer.parseInt(txtf_dialostic.getText()));
				frmAddMedicalIndices.dispose();
			}
		});
		
		frmAddMedicalIndices.setVisible(true);
	}
}
