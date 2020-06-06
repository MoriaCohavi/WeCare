package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.DebugGraphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DailyTestsReportsView {

	private JFrame frame;
	private JTable tbl_tests;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DailyTestsReportsView window = new DailyTestsReportsView();
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
	public DailyTestsReportsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1058, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDailyTestsReports = new JLabel("Daily Tests Reports");
		lblDailyTestsReports.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDailyTestsReports.setBounds(80, 51, 282, 20);
		frame.getContentPane().add(lblDailyTestsReports);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 115, 922, 346);
		frame.getContentPane().add(scrollPane);
		
		tbl_tests = new JTable();
		tbl_tests.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		tbl_tests.setBorder(null);
		tbl_tests.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_tests.setFocusable(false);
		tbl_tests.setShowVerticalLines(false);
		tbl_tests.setSelectionBackground(new Color(211, 211, 211));
		tbl_tests.setRowMargin(0);
		tbl_tests.setRowHeight(25);
		tbl_tests.setIntercellSpacing(new Dimension(0, 0));
		tbl_tests.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Num.", "Patient ID", "Result", "Attention Requires", "Type"
			}
		));
		tbl_tests.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		tbl_tests.getTableHeader().setOpaque(false);
		tbl_tests.getTableHeader().setBackground(new Color(32, 136, 203));
		tbl_tests.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbl_tests);
	}
}
