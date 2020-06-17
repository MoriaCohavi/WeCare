package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.doctorController;
import Model.Doctor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoctorDetailsView {

	private doctorController docCtrl;
	private JFrame frmDoctorDetails;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAvgPatients;
	private JTextField txtAvgSubscriptions;
	private JTextField txtSpecialization;
	private JTextField txtVisitTime;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorDetailsView window = new DoctorDetailsView();
//					window.frmDoctorDetails.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DoctorDetailsView(Doctor doctor) {
		initialize(doctor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Doctor doctor) {
		docCtrl = new doctorController(doctor);
		frmDoctorDetails = new JFrame();
		frmDoctorDetails.setTitle("Doctor Details");
		frmDoctorDetails.setBounds(100, 100, 570, 494);
		frmDoctorDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorDetails.getContentPane().setLayout(null);
		
		frmDoctorDetails.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// ADD SERIALZATION OF MANAGER AND USERS
				frmDoctorDetails.dispose();

			}
		});
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(40, 45, 160, 15);
		frmDoctorDetails.getContentPane().add(lblName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(40, 80, 160, 15);
		frmDoctorDetails.getContentPane().add(lblID);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 115, 160, 15);
		frmDoctorDetails.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(40, 154, 160, 15);
		frmDoctorDetails.getContentPane().add(lblPhone);
		
		JLabel lblAvgPatients = new JLabel("Average patients");
		lblAvgPatients.setBounds(40, 194, 160, 15);
		frmDoctorDetails.getContentPane().add(lblAvgPatients);
		
		JLabel lblAvgSubs = new JLabel("Average subscriptions");
		lblAvgSubs.setBounds(40, 229, 160, 15);
		frmDoctorDetails.getContentPane().add(lblAvgSubs);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(40, 264, 160, 15);
		frmDoctorDetails.getContentPane().add(lblSpecialization);
		
		JLabel lblVisitTime = new JLabel("Daily visit time");
		lblVisitTime.setBounds(40, 299, 160, 15);
		frmDoctorDetails.getContentPane().add(lblVisitTime);
		
		txtName = new JTextField(docCtrl.getDoctorName());
		txtName.setBounds(250, 45, 160, 21);
		frmDoctorDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField(docCtrl.getDoctorID());
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(250, 80, 160, 21);
		frmDoctorDetails.getContentPane().add(txtID);
		
		txtEmail = new JTextField(docCtrl.getDoctorEmail());
		txtEmail.setColumns(10);
		txtEmail.setBounds(250, 115, 160, 21);
		frmDoctorDetails.getContentPane().add(txtEmail);
		
		txtPhone = new JTextField(String.valueOf(docCtrl.getDoctorPhone()));
		txtPhone.setColumns(10);
		txtPhone.setBounds(250, 159, 160, 21);
		frmDoctorDetails.getContentPane().add(txtPhone);
		
		txtAvgPatients = new JTextField(String.valueOf(docCtrl.getDoctorAveragePatients()));
		txtAvgPatients.setEditable(false);
		txtAvgPatients.setColumns(10);
		txtAvgPatients.setBounds(250, 194, 160, 21);
		frmDoctorDetails.getContentPane().add(txtAvgPatients);
		
		txtAvgSubscriptions = new JTextField(String.valueOf(docCtrl.getDoctorAverageSubscriptions()));
		txtAvgSubscriptions.setEditable(false);
		txtAvgSubscriptions.setColumns(10);
		txtAvgSubscriptions.setBounds(250, 229, 160, 21);
		frmDoctorDetails.getContentPane().add(txtAvgSubscriptions);
		
		txtSpecialization = new JTextField(docCtrl.getDoctorSpecialization());
		txtSpecialization.setEditable(false);
		txtSpecialization.setColumns(10);
		txtSpecialization.setBounds(250, 264, 160, 21);
		frmDoctorDetails.getContentPane().add(txtSpecialization);
		
		txtVisitTime = new JTextField(String.valueOf(docCtrl.getDoctorAverageVisitTime()));
		txtVisitTime.setEditable(false);
		txtVisitTime.setColumns(10);
		txtVisitTime.setBounds(250, 299, 160, 21);
		frmDoctorDetails.getContentPane().add(txtVisitTime);
		
		JButton btnEdit = new JButton("Save");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//docCtrl.updateDoctor(String id, String name, String email, long phone);
			}
		});
		btnEdit.setBounds(40, 390, 85, 21);
		frmDoctorDetails.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(140, 390, 85, 21);
		frmDoctorDetails.getContentPane().add(btnDelete);
		frmDoctorDetails.setVisible(true);
	}

}
