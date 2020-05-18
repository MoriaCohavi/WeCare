package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerPanelView {
    JFrame frame;

    JPanel pnl_left;
    JPanel pnl_right;
    JPanel pnl_table;
    JPanel pnl_search;

    JTable tbl_doctor;

    JTextField tf_doctor;

    JButton btn_find;
    JButton btn_addDoctor;
    JButton btn_viewStats;

    public ManagerPanelView() {
        // Frame Initialization
        frame = new JFrame("Manager panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(500, 500);

        /************* Left side *************/

        // Table and its panel initialization
        String[] columnNames = { "ID", "Doctor name", "Specialization" };
        Object[][] data = { { 4, "Smith", "Gastro", 5, false }, { 113, "Doe", "Neurology" } };
        JTable table = new JTable(data, columnNames);

        pnl_table = new JPanel(new BorderLayout());
        pnl_table.add(table.getTableHeader(), BorderLayout.PAGE_START);
        pnl_table.add(table, BorderLayout.CENTER);

        // Doctor search panel init
        JLabel lbl_search = new JLabel("Search doctor: ");
        tf_doctor = new JTextField(12);

        btn_find = new JButton("Find");
        btn_addDoctor = new JButton("Add Doctor");

        GridLayout lyt_left = new GridLayout(2, 2);
        lyt_left.setHgap(10);
        lyt_left.setVgap(10);
        pnl_search = new JPanel(lyt_left);
        pnl_search.add(lbl_search);
        pnl_search.add(tf_doctor);
        pnl_search.add(btn_find);
        pnl_search.add(btn_addDoctor);

        pnl_left = new JPanel(new BorderLayout());
        pnl_left.add(pnl_table, BorderLayout.NORTH);
        pnl_left.add(pnl_search, BorderLayout.SOUTH);

        /************* Right side *************/

        JLabel lbl_clinicId = new JLabel("ID: 123");
        JLabel lbl_clinicName = new JLabel("Name: SMileClinic");
        JLabel lbl_clinicPhone = new JLabel("Phone: +972-5442312");
        JLabel lbl_clinicAddress = new JLabel("Address: Gaza");
        JLabel lbl_clinicEmail = new JLabel("Email: Wallak@gaza.com");

        btn_viewStats = new JButton("View statistical reports");

        pnl_right = new JPanel();
        pnl_right.setLayout(new BoxLayout(pnl_right, BoxLayout.PAGE_AXIS));
        pnl_right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pnl_right.add(lbl_clinicId);
        pnl_right.add(lbl_clinicName);
        pnl_right.add(lbl_clinicPhone);
        pnl_right.add(lbl_clinicAddress);
        pnl_right.add(lbl_clinicEmail);
        pnl_right.add(btn_viewStats);

        /************* Frame *************/

        // Add pnls to frame
        frame.getContentPane().add(pnl_left, BorderLayout.WEST);
        frame.getContentPane().add(pnl_right, BorderLayout.EAST);
        frame.setVisible(true);
    }
    
    public JTable getTbl_doctor() {
    	return this.tbl_doctor;
    }
    public void setTbl_doctor(JTable tbl_doctor) {
    	this.tbl_doctor = tbl_doctor;
    }


    public JTextField getTf_doctor() {
    	return this.tf_doctor;
    }
    public void setTf_doctor(JTextField tf_doctor) {
    	this.tf_doctor = tf_doctor;
    }


    public JButton getBtn_find() {
    	return this.btn_find;
    }
    public void setBtn_find(JButton btn_find) {
    	this.btn_find = btn_find;
    }


    public JButton getBtn_addDoctor() {
    	return this.btn_addDoctor;
    }
    public void setBtn_addDoctor(JButton btn_addDoctor) {
    	this.btn_addDoctor = btn_addDoctor;
    }


    public JButton getBtn_viewStats() {
    	return this.btn_viewStats;
    }
    public void setBtn_viewStats(JButton btn_viewStats) {
    	this.btn_viewStats = btn_viewStats;
    }

}