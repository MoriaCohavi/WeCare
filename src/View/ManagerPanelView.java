package View;

import java.awt.Font;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.sun.glass.events.WindowEvent;
import Controller.authenticationController;
import Controller.managerController;
import Model.Doctor;
import Model.Manager;
import javax.swing.JLabel;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.HashMap;

public class ManagerPanelView {

	private managerController managerCtrl;
	private authenticationController authCtrl;
	private HashMap <String, Doctor> doctorsList;
	private Manager details;
	
	private JFrame frmManager;
	private JSeparator separator;
	private JTable tbl_doctors;
	private JButton btnSearch;
	private JButton btnAddDoctor;
	private JButton btnViewStatisticalReport;
	private JLabel lblName;
	private JLabel lblID;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblClinicName;
	private JTextField txtSearchDoctor;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtClinicName;
	
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
	public ManagerPanelView(long managerToken) {
		initialize(managerToken);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long managerToken) {
		
		authCtrl = new authenticationController();
		details = (Manager)authCtrl.getLoggedinUser(managerToken);
		managerCtrl = new managerController();
//		doctorsList = managerCtrl.getPatientsList();
		
		frmManager = new JFrame();
		frmManager.setTitle("Manager");
		frmManager.setBounds(100, 100, 1058, 571);
		frmManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManager.getContentPane().setLayout(null);
		frmManager.setVisible(true);
	
		frmManager.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				authCtrl.serialize();
				System.exit(0);
			}
		});
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(80, 58, 282, 20);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmManager.getContentPane().add(lblWelcome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 127, 575, 334);
		frmManager.getContentPane().add(scrollPane);
		
		tbl_doctors = new JTable();
		tbl_doctors.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tbl_doctors.setBorder(null);
		tbl_doctors.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_doctors.setFocusable(false);
		tbl_doctors.setShowVerticalLines(false);
		tbl_doctors.setSelectionBackground(new Color(211, 211, 211));
		tbl_doctors.setRowMargin(0);
		tbl_doctors.setRowHeight(25);
		tbl_doctors.setIntercellSpacing(new Dimension(0, 0));
//		Object[][] listObj = new Object[3][];
//		int rowsIndex = 1;
//		for (String key: doctorsList.keySet()) {
//			listObj[rowsIndex][0] = rowsIndex;
//			listObj[rowsIndex][1] = doctorsList.get(key).getName();
//			listObj[rowsIndex][2] = doctorsList.get(key).getId();
//			rowsIndex++;
//		}
		
		tbl_doctors.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Doctor", "Specialization"
			}
		));

		tbl_doctors.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tbl_doctors.getTableHeader().setOpaque(false);
		tbl_doctors.getTableHeader().setBackground(new Color(32, 136, 203));
		tbl_doctors.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbl_doctors);
		
		txtSearchDoctor = new JTextField();
		txtSearchDoctor.setForeground(Color.GRAY);
		txtSearchDoctor.setSelectionColor(new Color(192, 192, 192));
		txtSearchDoctor.setText("Search Doctor...");
		txtSearchDoctor.setBounds(80, 477, 311, 26);
		frmManager.getContentPane().add(txtSearchDoctor);
		txtSearchDoctor.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doctor isExist = details.getItem("111111111");
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSearch.setBounds(405, 477, 96, 29);
		frmManager.getContentPane().add(btnSearch);
		
		btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerCtrl.openManagerPanel(managerToken);
			}
		});
		btnAddDoctor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddDoctor.setBounds(516, 477, 139, 29);
		frmManager.getContentPane().add(btnAddDoctor);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(693, 136, 119, 20);
		frmManager.getContentPane().add(lblName);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblID.setBounds(693, 172, 119, 20);
		frmManager.getContentPane().add(lblID);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(693, 208, 119, 20);
		frmManager.getContentPane().add(lblPhone);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(693, 244, 119, 20);
		frmManager.getContentPane().add(lblAddress);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(693, 280, 119, 20);
		frmManager.getContentPane().add(lblEmail);
		
		lblClinicName = new JLabel("Clinic Name");
		lblClinicName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClinicName.setBounds(693, 316, 119, 20);
		frmManager.getContentPane().add(lblClinicName);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(670, 127, 351, 379);
		frmManager.getContentPane().add(separator);
		
		btnViewStatisticalReport = new JButton("View Statistical Report");
		btnViewStatisticalReport.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewStatisticalReport.setBounds(693, 475, 244, 29);
		frmManager.getContentPane().add(btnViewStatisticalReport);
		
		txtName = new JTextField();
//		txtName.setText(details.getName());
		txtName.setEnabled(false);
		txtName.setBounds(821, 133, 146, 26);
		frmManager.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setText(details.getID());
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(821, 170, 146, 26);
		frmManager.getContentPane().add(txtID);
		
		txtPhone = new JTextField();
//		txtPhone.setText(details.getPhone().toString());
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(821, 206, 146, 26);
		frmManager.getContentPane().add(txtPhone);
		
		txtAddress = new JTextField();
//		txtAddress.setText(details.getAddress());
		txtAddress.setEnabled(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(821, 242, 146, 26);
		frmManager.getContentPane().add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.setText(details.getEmail());
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(821, 278, 146, 26);
		frmManager.getContentPane().add(txtEmail);
		
		txtClinicName = new JTextField();
//		txtClinicName.setText(details.getClinicName());
		txtClinicName.setEnabled(false);
		txtClinicName.setColumns(10);
		txtClinicName.setBounds(821, 314, 146, 26);
		frmManager.getContentPane().add(txtClinicName);
		frmManager.setVisible(true);
	}
}