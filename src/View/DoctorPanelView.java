package View;

import javax.swing.*;
import java.awt.*;

public class DoctorPanelView {
    JFrame frame;

    JPanel pnl_left;
    JPanel pnl_right;
    JPanel pnl_table;
    JPanel pnl_search;

    JTable tbl_patient;

    JTextField tf_patient;

    JButton btn_find;
    JButton btn_addPatient;
    JButton btn_dailyReport;

    public DoctorPanelView()
    {
          // Frame Initialization
          frame = new JFrame("Doctor panel");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.getContentPane().setLayout(new BorderLayout());
          frame.setSize(500, 500);
  
          /************* Left side *************/
  
          // Table and its panel initialization
          String[] columnNames = { "ID", "Patient name" };
          Object[][] data = { { 4, "Smith" }, { 113, "Doe" } };
          JTable table = new JTable(data, columnNames);
  
          pnl_table = new JPanel(new BorderLayout());
          pnl_table.add(table.getTableHeader(), BorderLayout.PAGE_START);
          pnl_table.add(table, BorderLayout.CENTER);
  
          // Doctor search panel init
          JLabel lbl_search = new JLabel("Search patient: ");
          tf_patient = new JTextField(12);
  
          btn_find = new JButton("Find");
          btn_addPatient = new JButton("Add patient");
  
          GridLayout lyt_left = new GridLayout(2, 2);
          lyt_left.setHgap(10);
          lyt_left.setVgap(10);
          pnl_search = new JPanel(lyt_left);
          pnl_search.add(lbl_search);
          pnl_search.add(tf_patient);
          pnl_search.add(btn_find);
          pnl_search.add(btn_addPatient);
  
          pnl_left = new JPanel(new BorderLayout());
          pnl_left.add(pnl_table, BorderLayout.NORTH);
          pnl_left.add(pnl_search, BorderLayout.SOUTH);
  
          /************* Right side *************/
  
          JLabel lbl_clinicId = new JLabel("ID: 123");
          JLabel lbl_clinicName = new JLabel("Name: SMileClinic");
          JLabel lbl_clinicPhone = new JLabel("Phone: +972-5442312");
          JLabel lbl_clinicAddress = new JLabel("Address: Gaza");
          JLabel lbl_clinicEmail = new JLabel("Email: Wallak@gaza.com");
  
          btn_dailyReport = new JButton("View daily test report");
  
          pnl_right = new JPanel();
          pnl_right.setLayout(new BoxLayout(pnl_right, BoxLayout.PAGE_AXIS));
          pnl_right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  
          pnl_right.add(lbl_clinicId);
          pnl_right.add(lbl_clinicName);
          pnl_right.add(lbl_clinicPhone);
          pnl_right.add(lbl_clinicAddress);
          pnl_right.add(lbl_clinicEmail);
          pnl_right.add(btn_dailyReport);
  
          /************* Frame *************/
  
          // Add pnls to frame
          frame.getContentPane().add(pnl_left, BorderLayout.WEST);
          frame.getContentPane().add(pnl_right, BorderLayout.EAST);
          frame.setVisible(true);
    }

    public JTable getTbl_patient() {
    	return this.tbl_patient;
    }
    public void setTbl_patient(JTable tbl_patient) {
    	this.tbl_patient = tbl_patient;
    }


    public JTextField getTf_patient() {
    	return this.tf_patient;
    }
    public void setTf_patient(JTextField tf_patient) {
    	this.tf_patient = tf_patient;
    }


    public JButton getBtn_find() {
    	return this.btn_find;
    }
    public void setBtn_find(JButton btn_find) {
    	this.btn_find = btn_find;
    }


    public JButton getBtn_addPatient() {
    	return this.btn_addPatient;
    }
    public void setBtn_addPatient(JButton btn_addPatient) {
    	this.btn_addPatient = btn_addPatient;
    }


    public JButton getBtn_dailyReport() {
    	return this.btn_dailyReport;
    }
    public void setBtn_dailyReport(JButton btn_dailyReport) {
    	this.btn_dailyReport = btn_dailyReport;
    }

}