package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StatisticalReportView {

	private JFrame frmStatisticalDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticalReportView window = new StatisticalReportView();
					window.frmStatisticalDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatisticalReportView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatisticalDetails = new JFrame();
		frmStatisticalDetails.setTitle("Statistical details");
		frmStatisticalDetails.setBounds(100, 100, 472, 300);
		frmStatisticalDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmStatisticalDetails.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_average = new JLabel("Average time for single visit:");
		lbl_average.setBounds(35, 36, 269, 13);
		panel.add(lbl_average);
		
		JLabel lbl_daily = new JLabel("Daily patients:");
		lbl_daily.setBounds(35, 77, 176, 13);
		panel.add(lbl_daily);
		
		JLabel lbl_lblRequests = new JLabel("Lab requests daily average:");
		lbl_lblRequests.setBounds(35, 123, 219, 13);
		panel.add(lbl_lblRequests);
		
		JLabel lbl_subscribe = new JLabel("Subscription day average:");
		lbl_subscribe.setBounds(35, 165, 176, 13);
		panel.add(lbl_subscribe);
		
		JButton btn_export = new JButton("Export to report");
		btn_export.setBounds(158, 205, 146, 21);
		panel.add(btn_export);
	}

}
