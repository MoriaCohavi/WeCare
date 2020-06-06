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

public class ManagerPanelView {

	private JFrame frame;
	private JTable table;
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
	public ManagerPanelView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 664, 10);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"a", "a", "a"},
			},
			new String[] {
				"Doctor name", "Id", "Specialization"
			}
		));
		table.setBounds(0, 10, 322, 305);
		frame.getContentPane().add(table);
		
		lbl_id = new JLabel("Id:");
		lbl_id.setBounds(350, 20, 45, 13);
		frame.getContentPane().add(lbl_id);
		
		lbl_name = new JLabel("Name:");
		lbl_name.setBounds(350, 43, 45, 13);
		frame.getContentPane().add(lbl_name);
		
		lbl_phone = new JLabel("Phone:");
		lbl_phone.setBounds(350, 66, 45, 13);
		frame.getContentPane().add(lbl_phone);
		
		lbl_address = new JLabel("Address:");
		lbl_address.setBounds(350, 89, 45, 13);
		frame.getContentPane().add(lbl_address);
		
		lbl_email = new JLabel("Email:");
		lbl_email.setBounds(350, 112, 45, 13);
		frame.getContentPane().add(lbl_email);
		
		btn_statistical = new JButton("View statistical report");
		btn_statistical.setBounds(350, 147, 178, 21);
		frame.getContentPane().add(btn_statistical);
		
		lbl_search = new JLabel("Search doctor:");
		lbl_search.setBounds(10, 344, 91, 13);
		frame.getContentPane().add(lbl_search);
		
		txtf_doctor = new JTextField();
		txtf_doctor.setBounds(131, 341, 96, 19);
		frame.getContentPane().add(txtf_doctor);
		txtf_doctor.setColumns(10);
		
		btn_find = new JButton("Find");
		btn_find.setBounds(10, 380, 85, 21);
		frame.getContentPane().add(btn_find);
		
		btn_addDoctor = new JButton("Add Doctor");
		btn_addDoctor.setBounds(131, 380, 96, 21);
		frame.getContentPane().add(btn_addDoctor);
	}
}
