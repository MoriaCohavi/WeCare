package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.authenticationController;
import Controller.managerController;
import Model.Manager;

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
	private JTextField textfPatientsMonth;
	private JTextField txtfLabMonth;
	private JTextField txtfSubsMonth;
	private managerController managerCtrl;
	private authenticationController authCtrl;
	private Manager managerDetails;
	
	
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
		managerCtrl = new managerController();
		authCtrl = new authenticationController();
		managerDetails = (Manager)authCtrl.getLoggedinUser(managerToken);
		managerCtrl.setClinicManager(managerDetails);
		
		managerCtrl.getManager().calcDailyStats();
		managerCtrl.getManager().calcMonthlyStats();
		frmStatisticalDetails = new JFrame();
		frmStatisticalDetails.setTitle("Statistical details");
		frmStatisticalDetails.setBounds(100, 100, 618, 399);
		
		
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
		lbl_daily.setBounds(121, 51, 176, 13);
		panel.add(lbl_daily);
		
		JLabel lbl_lblRequests = new JLabel("Lab requests daily average:");
		lbl_lblRequests.setBounds(121, 97, 219, 13);
		panel.add(lbl_lblRequests);
		
		JLabel lbl_subscribe = new JLabel("Subscription day average:");
		lbl_subscribe.setBounds(121, 139, 198, 13);
		panel.add(lbl_subscribe);
		
		JLabel lbl_monthly_patients = new JLabel("Monthly patients:");
		lbl_monthly_patients.setBounds(121, 179, 176, 13);
		panel.add(lbl_monthly_patients);
		
		JLabel lbl_monthly_Requests = new JLabel("Lab requests monthly average: ");
		lbl_monthly_Requests.setBounds(121, 225, 219, 13);
		panel.add(lbl_monthly_Requests);
		
		JLabel lbl_monthly_subscribe = new JLabel("Subscription monthly average: ");
		lbl_monthly_subscribe.setBounds(121, 267, 198, 13);
		panel.add(lbl_monthly_subscribe);
		
		
		JButton btn_export = new JButton("Export to report");
		btn_export.setBounds(446, 328, 146, 21);
		panel.add(btn_export);
		frmStatisticalDetails.setVisible(true);
		
		/* Fill the data */
		
		lbl_lblRequests.setText("Lab requests daily average: ");
		lbl_subscribe.setText("Subscription day average: ");
		
		txtfPatients = new JTextField(String.valueOf(managerCtrl.getDailyStats(managerToken).getTotalDailyPatients()));
		txtfPatients.setEnabled(false);
		txtfPatients.setEditable(false);
		txtfPatients.setBounds(329, 48, 96, 19);
		panel.add(txtfPatients);
		txtfPatients.setColumns(10);
		
		txtfLabs = new JTextField(String.valueOf(managerCtrl.getDailyStats(managerToken).getTotalDailylabs()));
		txtfLabs.setEnabled(false);
		txtfLabs.setEditable(false);
		txtfLabs.setColumns(10);
		txtfLabs.setBounds(329, 94, 96, 19);
		panel.add(txtfLabs);
		
		txtfSubs = new JTextField(String.valueOf(managerCtrl.getDailyStats(managerToken).getTotalDailySubs()));
		txtfSubs.setEnabled(false);
		txtfSubs.setEditable(false);
		txtfSubs.setColumns(10);
		txtfSubs.setBounds(329, 136, 96, 19);
		panel.add(txtfSubs);
		
		
		textfPatientsMonth = new JTextField(String.valueOf(managerCtrl.getMonthlyStats(managerToken).getTotalDailyPatients()));
		textfPatientsMonth.setEnabled(false);
		textfPatientsMonth.setEditable(false);
		textfPatientsMonth.setColumns(10);
		textfPatientsMonth.setBounds(329, 176, 96, 19);
		panel.add(textfPatientsMonth);
		
		txtfLabMonth = new JTextField(String.valueOf(managerCtrl.getMonthlyStats(managerToken).getTotalDailylabs()));
		txtfLabMonth.setEnabled(false);
		txtfLabMonth.setEditable(false);
		txtfLabMonth.setColumns(10);
		txtfLabMonth.setBounds(329, 222, 96, 19);
		panel.add(txtfLabMonth);
		
		txtfSubsMonth = new JTextField(String.valueOf(managerCtrl.getMonthlyStats(managerToken).getTotalDailySubs()));
		txtfSubsMonth.setEnabled(false);
		txtfSubsMonth.setEditable(false);
		txtfSubsMonth.setColumns(10);
		txtfSubsMonth.setBounds(329, 264, 96, 19);
		panel.add(txtfSubsMonth);
		frmStatisticalDetails.setVisible(true);		
	}
}
