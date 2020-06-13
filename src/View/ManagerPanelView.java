package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ManagerPanelView {

	private JFrame frmManager;
	private JTable tbl_managers;
	private JLabel lbl_id;
	private JLabel lbl_name;
	private JLabel lbl_phone;
	private JLabel lbl_address;
	private JLabel lbl_email;
	private JButton btn_statistical;
	private JLabel lbl_search;
	private JTextField txtf_doctor;
	private JButton btn_find;
	private JButton btn_addDoctor;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerPanelView window = new ManagerPanelView();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ManagerPanelView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManager = new JFrame();
		frmManager.setTitle("Manager");
		frmManager.setBounds(100, 100, 593, 495);
		frmManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManager.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 664, 10);
		frmManager.getContentPane().add(panel);
		
		tbl_managers = new JTable();
		tbl_managers.setBorder(null);
		tbl_managers.setModel(new DefaultTableModel(
			new Object[][] {
				{"a", "a", "a"},
			},
			new String[] {
				"Doctor name", "Id", "Specialization"
			}
		));
		tbl_managers.setBounds(0, 10, 322, 305);
		frmManager.getContentPane().add(tbl_managers);
		
		lbl_id = new JLabel("Id:");
		lbl_id.setBounds(350, 20, 45, 13);
		frmManager.getContentPane().add(lbl_id);
		
		lbl_name = new JLabel("Name:");
		lbl_name.setBounds(350, 43, 45, 13);
		frmManager.getContentPane().add(lbl_name);
		
		lbl_phone = new JLabel("Phone:");
		lbl_phone.setBounds(350, 66, 45, 13);
		frmManager.getContentPane().add(lbl_phone);
		
		lbl_address = new JLabel("Address:");
		lbl_address.setBounds(350, 89, 45, 13);
		frmManager.getContentPane().add(lbl_address);
		
		lbl_email = new JLabel("Email:");
		lbl_email.setBounds(350, 112, 45, 13);
		frmManager.getContentPane().add(lbl_email);
		
		btn_statistical = new JButton("View statistical report");
		btn_statistical.setBounds(350, 147, 178, 21);
		frmManager.getContentPane().add(btn_statistical);
		
		lbl_search = new JLabel("Search doctor:");
		lbl_search.setBounds(10, 344, 91, 13);
		frmManager.getContentPane().add(lbl_search);
		
		txtf_doctor = new JTextField();
		txtf_doctor.setBounds(131, 341, 96, 19);
		frmManager.getContentPane().add(txtf_doctor);
		txtf_doctor.setColumns(10);
		
		btn_find = new JButton("Find");
		btn_find.setBounds(10, 380, 85, 21);
		frmManager.getContentPane().add(btn_find);
		
		btn_addDoctor = new JButton("Add Doctor");
		btn_addDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddDoctorView addDoctorView = new AddDoctorView();
				frmManager.dispose();
			}
		});
		btn_addDoctor.setBounds(131, 380, 96, 21);
		frmManager.getContentPane().add(btn_addDoctor);
		frmManager.setVisible(true);
	}
}
