package View;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.doctorController;
import Model.Doctor;
import jdk.nashorn.api.tree.NewTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddLabView {

	private doctorController docCtrl;
	private JFrame frmAddLabResults;
	private JTextField txtfLabType;
	private JTextField txtfResults;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddLabView window = new AddLabView();
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
		frmAddLabResults.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 572, 10);
		frmAddLabResults.getContentPane().add(panel);
		
		JLabel lblType = new JLabel("Lab type:");
		lblType.setBounds(47, 52, 67, 13);
		frmAddLabResults.getContentPane().add(lblType);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setBounds(47, 97, 67, 13);
		frmAddLabResults.getContentPane().add(lblResults);
		
		JCheckBox chckbxAttention = new JCheckBox("Attention required?");
		chckbxAttention.setBounds(129, 170, 159, 21);
		frmAddLabResults.getContentPane().add(chckbxAttention);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setBounds(47, 148, 45, 13);
		frmAddLabResults.getContentPane().add(lblWarning);
		
		JButton btnAdd = new JButton("Add");
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
				frmAddLabResults.dispose();
			}
		});
		btnAdd.setBounds(140, 207, 85, 21);
		frmAddLabResults.getContentPane().add(btnAdd);
		
		txtfLabType = new JTextField();
		txtfLabType.setBounds(129, 49, 96, 19);
		frmAddLabResults.getContentPane().add(txtfLabType);
		txtfLabType.setColumns(10);
		
		txtfResults = new JTextField();
		txtfResults.setBounds(129, 94, 96, 19);
		frmAddLabResults.getContentPane().add(txtfResults);
		txtfResults.setColumns(10);
		

		frmAddLabResults.setVisible(true);
	}
}
