package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DebugGraphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MedicalRecordHistoryView {

	private JFrame frmRecordsHistory;
	private JScrollPane scrollPane;
	private JTable tblRecords;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MedicalRecordHistoryView window = new MedicalRecordHistoryView();
//					window.frmRecordsHistory.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MedicalRecordHistoryView(long doctorToken, String patientID) {
		initialize(doctorToken, patientID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long doctorToken, String patientID) {
		frmRecordsHistory = new JFrame();
		frmRecordsHistory.setTitle("Medical Records History");
		frmRecordsHistory.setBounds(100, 100, 487, 423);
		//frmRecordsHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecordsHistory.getContentPane().setLayout(null);
		
		frmRecordsHistory.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DoctorView docView = new DoctorView(doctorToken);
				frmRecordsHistory.dispose();

			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 42, 452, 238);
		frmRecordsHistory.getContentPane().add(scrollPane);
		
		tblRecords = new JTable();
		tblRecords.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tblRecords.setBorder(null);
		tblRecords.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tblRecords.setFocusable(false);
		tblRecords.setShowVerticalLines(false);
		tblRecords.setSelectionBackground(new Color(211, 211, 211));
		tblRecords.setRowMargin(0);
		tblRecords.setRowHeight(25);
		tblRecords.setIntercellSpacing(new Dimension(0, 0));
		Object[][] listObj = new Object[3][];
		
//		int rowsIndex = 1;
//		for (String key: patientsList.keySet()) {
//			listObj[rowsIndex][0] = rowsIndex;
//			listObj[rowsIndex][1] = patientsList.get(key).getName();
//			listObj[rowsIndex][2] = patientsList.get(key).getId();
//			rowsIndex++;
//		}
		
		tblRecords.setModel(new DefaultTableModel(
				listObj,
				new String[] {
					"Record ID.", "Visit Purpose", "Visit Description"
				}
			));
		
		tblRecords.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tblRecords.getTableHeader().setOpaque(false);
		tblRecords.getTableHeader().setBackground(new Color(32, 136, 203));
		tblRecords.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tblRecords);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 574, 10);
		frmRecordsHistory.getContentPane().add(panel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRecordsHistory.dispose();
				DoctorView docView = new DoctorView(doctorToken);
			}
		});
		btnExit.setBounds(200, 326, 85, 21);
		frmRecordsHistory.getContentPane().add(btnExit);
		frmRecordsHistory.setVisible(true);
	}
}
