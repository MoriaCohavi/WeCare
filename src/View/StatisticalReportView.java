package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.managerController;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class StatisticalReportView {

	private managerController mgmtController;
	
	private JFrame frmStatisticalDetails;
	private JTextField txtfPatients;
	private JTextField txtfLabs;
	private JTextField txtfSubs;
	
	/**
	 * Create the application.
	 */
	public StatisticalReportView(long managerToken) {
		initialize(managerToken);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long managerToken) {
		mgmtController = new  managerController();
		mgmtController.getManager().calcStats();
		frmStatisticalDetails = new JFrame();
		frmStatisticalDetails.setTitle("Statistical details");
		frmStatisticalDetails.setBounds(100, 100, 472, 300);
		
		
		frmStatisticalDetails.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ManagerView newManagerView = new ManagerView(managerToken);
				frmStatisticalDetails.dispose();

			}
		});
		
		
		JPanel panel = new JPanel();
		frmStatisticalDetails.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_daily = new JLabel("Daily patients:");
		lbl_daily.setBounds(35, 77, 176, 13);
		panel.add(lbl_daily);
		
		JLabel lbl_lblRequests = new JLabel("Lab requests daily average:");
		lbl_lblRequests.setBounds(35, 123, 219, 13);
		panel.add(lbl_lblRequests);
		
		JLabel lbl_subscribe = new JLabel("Subscription day average:");
		lbl_subscribe.setBounds(35, 165, 198, 13);
		panel.add(lbl_subscribe);
		
		JButton btn_export = new JButton("Export to report");
		btn_export.setBounds(158, 205, 146, 21);
		panel.add(btn_export);
		frmStatisticalDetails.setVisible(true);
		
		/* Fill the data */
		mgmtController = new managerController();
		lbl_lblRequests.setText("Lab requests daily average: ");
		lbl_subscribe.setText("Subscription day average: ");
		
		txtfPatients = new JTextField(String.valueOf(mgmtController.getStats(managerToken).getTotalDailyPatients()));
		txtfPatients.setEnabled(false);
		txtfPatients.setEditable(false);
		txtfPatients.setBounds(243, 74, 96, 19);
		panel.add(txtfPatients);
		txtfPatients.setColumns(10);
		
		txtfLabs = new JTextField(String.valueOf(mgmtController.getStats(managerToken).getTotalDailylabs()));
		txtfLabs.setEnabled(false);
		txtfLabs.setEditable(false);
		txtfLabs.setColumns(10);
		txtfLabs.setBounds(243, 120, 96, 19);
		panel.add(txtfLabs);
		
		txtfSubs = new JTextField(String.valueOf( mgmtController.getStats(managerToken).getTotalDailySubs()));
		txtfSubs.setEnabled(false);
		txtfSubs.setEditable(false);
		txtfSubs.setColumns(10);
		txtfSubs.setBounds(243, 162, 96, 19);
		panel.add(txtfSubs);
		frmStatisticalDetails.setVisible(true);		
	}
}
