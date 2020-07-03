package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.doctorController;
import Model.Doctor;
//import jdk.nashorn.api.tree.NewTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddLabView {

	private doctorController docCtrl;
	private JFrame frmAddLabResults;
	private JTextField txtfLabType;
	private JTextField txtfResults;


	/**
	 * Create the application.
	 */
	public AddLabView(long doctorToken, String patientID, Doctor doctor) {
		initialize(doctorToken, patientID, doctor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken, String patientID, Doctor doctor) {
		frmAddLabResults = new JFrame();
		frmAddLabResults.setTitle("Add Lab Results");
		frmAddLabResults.setBounds(100, 100, 391, 331);
		frmAddLabResults.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAddLabResults.getContentPane().add(panel, BorderLayout.CENTER);
		
		try {
			BufferedImage img = ImageIO.read(new File("src\\view\\DoctorDetailsViewImg.jpg"));
			Image dimg = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel backgroundLabel = new JLabel(icon);
			backgroundLabel.setBounds(0, 0, 375, 292);
			
			BufferedImage img2 = ImageIO.read(new File("src\\view\\logo2Img.jpg"));
			Image dimg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			frmAddLabResults.setIconImage(dimg2);
			
			JLabel lblType = new JLabel("Lab type:");
			lblType.setBounds(47, 52, 67, 13);
			lblType.setForeground(Color.black);
			lblType.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			
			JLabel lblResults = new JLabel("Results:");
			lblResults.setBounds(47, 97, 67, 13);
			lblResults.setForeground(Color.black);
			lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			
			JCheckBox chckbxAttention = new JCheckBox("Attention required?");
			chckbxAttention.setBounds(129, 170, 159, 21);
			chckbxAttention.setForeground(Color.black);
			chckbxAttention.setFont(new Font("Tahoma", Font.BOLD, 10));
			chckbxAttention.setOpaque(false);
			
			JLabel lblWarning = new JLabel("");
			lblWarning.setBounds(47, 148, 45, 13);
			
			
			JButton btnAdd = new JButton("Add");
			btnAdd.setBounds(140, 207, 85, 21);
			
			
			txtfLabType = new JTextField();
			txtfLabType.setBounds(129, 49, 96, 19);
			txtfLabType.setColumns(10);
			
			txtfResults = new JTextField();
			txtfResults.setBounds(129, 94, 96, 19);
			txtfResults.setColumns(10);
			
			panel.setLayout(null);
			panel.add(lblType);
			panel.add(lblResults);
			panel.add(chckbxAttention);
			panel.add(lblWarning);
			panel.add(btnAdd);
			panel.add(txtfLabType);
			panel.add(txtfResults);
			panel.add(backgroundLabel);
			frmAddLabResults.setVisible(true);
			
			btnAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					docCtrl = new doctorController(doctor);
					if (docCtrl.addNewLab(doctorToken, patientID, txtfLabType.getText(), txtfResults.getText(), chckbxAttention.isSelected()))
					{
						docCtrl.serializeLabs();
						docCtrl.serializeStatsList();
					}
					else
						lblWarning.setText("Error! Lab not set - contact administrator");
						lblWarning.setForeground(Color.black);
						lblWarning.setFont(new Font("Tahoma", Font.BOLD, 14));
					frmAddLabResults.dispose();
				}
			});
			
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
