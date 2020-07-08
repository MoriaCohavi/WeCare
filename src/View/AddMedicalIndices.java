package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\background3Img.jpg"));
			Image dimg = img.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0, 0, 438, 397);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmAddMedicalIndices.setIconImage(dimg2);
			
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setBounds(52, 57, 45, 13);
			lblHeight.setForeground(Color.black);
			lblHeight.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lblWeight = new JLabel("Weight:");
			lblWeight.setBounds(52, 93, 63, 13);
			lblWeight.setForeground(Color.black);
			lblWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			JLabel lblHeartRate = new JLabel("Heart rate:");
			lblHeartRate.setBounds(52, 130, 105, 13);
			lblHeartRate.setForeground(Color.black);
			lblHeartRate.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lblSystolicBP = new JLabel("Systolic BP:");
			lblSystolicBP.setBounds(52, 169, 82, 13);
			lblSystolicBP.setForeground(Color.black);
			lblSystolicBP.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lblDialosticBP = new JLabel("Dialostic BP:");
			lblDialosticBP.setBounds(52, 208, 82, 13);
			lblDialosticBP.setForeground(Color.black);
			lblDialosticBP.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JLabel lblTemp = new JLabel("Temperature:");
			lblTemp.setBounds(52, 248, 82, 13);
			lblTemp.setForeground(Color.black);
			lblTemp.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			txtf_height = new JTextField();
			txtf_height.setBounds(162, 54, 96, 19);
			txtf_height.setForeground(Color.black);
			txtf_height.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtf_height.setColumns(10);
			
			txtf_weight = new JTextField();
			txtf_weight.setColumns(10);
			txtf_weight.setBounds(162, 90, 96, 19);
			txtf_weight.setForeground(Color.black);
			txtf_weight.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			txtf_heartRate = new JTextField();
			txtf_heartRate.setColumns(10);
			txtf_heartRate.setBounds(162, 127, 96, 19);
			txtf_heartRate.setForeground(Color.black);
			txtf_heartRate.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			txtf_systolic = new JTextField();
			txtf_systolic.setColumns(10);
			txtf_systolic.setBounds(162, 166, 96, 19);
			txtf_systolic.setForeground(Color.black);
			txtf_systolic.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			txtf_dialostic = new JTextField();
			txtf_dialostic.setColumns(10);
			txtf_dialostic.setBounds(162, 205, 96, 19);
			txtf_dialostic.setForeground(Color.black);
			txtf_dialostic.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			txtf_temp = new JTextField();
			txtf_temp.setColumns(10);
			txtf_temp.setBounds(162, 245, 96, 19);
			txtf_temp.setForeground(Color.black);
			txtf_temp.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			JButton btnAdd = new JButton("Add");
			btnAdd.setBounds(52, 310, 85, 21);
			btnAdd.setForeground(Color.black);
			btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					medIndices = new MedicalIndices(Integer.parseInt(txtf_weight.getText()), Integer.parseInt(txtf_height.getText()), Integer.parseInt(txtf_heartRate.getText()), Integer.parseInt(txtf_temp.getText()), Integer.parseInt(txtf_systolic.getText()), Integer.parseInt(txtf_dialostic.getText()));
					frmAddMedicalIndices.dispose();
				}
			});
			
			
			
			panel.setLayout(null);
			panel.add(lblHeight);
			panel.add(lblWeight);
			panel.add(lblHeartRate);
			panel.add(lblSystolicBP);
			panel.add(lblDialosticBP);
			panel.add(lblTemp);
			panel.add(btnAdd);
			panel.add(txtf_height);
			panel.add(txtf_temp);
			panel.add(txtf_dialostic);
			panel.add(txtf_systolic);
			panel.add(txtf_heartRate);
			panel.add(txtf_weight);
			panel.add(backgroundLabel);
			frmAddMedicalIndices.setVisible(true);
			
			
			
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
