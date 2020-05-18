package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoctorDetailsView {
    private JFrame frame;

    private JPanel pnl_btns;
    private JPanel pnl_tfs;
    private JPanel pnl_lbls;

    private JTextField tf_name;
    private JTextField tf_id;
    private JTextField tf_phone;
    private JTextField tf_address;
    private JTextField tf_email;
    private JTextField tf_daily_pat;
    private JTextField tf_daily_sub;
    private JTextField tf_spec;
    private JTextField tf_daily_visit;

    private JButton btn_edit;
    private JButton btn_delete;

    public DoctorDetailsView()
    {
        // Frame Initialization 
        frame = new JFrame("Doctor Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(500, 500);

        // Labels pnl initialization
        String[] labels = {"Name: ", "Id: ", "Email: ", "Address: ", "Phone: ", "Daily patients: ", "Daily subscriptions: ", "Specialization: ", "Daily visit time: "};
        int numPairs = labels.length;
        pnl_lbls = new JPanel(new GridLayout(numPairs, 1));
        pnl_lbls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //Create labels and populate the pnl.
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i]);
            pnl_lbls.add(l);
        }

        // Text fiels pnl initialization
        tf_name = new JTextField(25);
        tf_id = new JTextField();
        tf_phone = new JTextField();
        tf_address = new JTextField();
        tf_email = new JTextField();
        tf_daily_pat = new JTextField();
        tf_daily_sub = new JTextField();
        tf_spec = new JTextField();
        tf_daily_visit = new JTextField();
        /* -------------- */
        pnl_tfs = new JPanel(new GridLayout(numPairs, 1));
        pnl_tfs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnl_tfs.add(tf_name);
        pnl_tfs.add(tf_id);
        pnl_tfs.add(tf_address);
        pnl_tfs.add(tf_email);
        pnl_tfs.add(tf_phone);
        pnl_tfs.add(tf_daily_pat);
        pnl_tfs.add(tf_daily_sub);
        pnl_tfs.add(tf_spec);
        pnl_tfs.add(tf_daily_visit);

        // Buttons pnl initialization
        btn_edit = new JButton("Edit");
        btn_delete = new JButton("Delete");
        pnl_btns = new JPanel(new FlowLayout());
        pnl_btns.add(btn_edit);
        pnl_btns.add(btn_delete);

        // Add pnls to frame
        frame.getContentPane().add(pnl_lbls, BorderLayout.WEST);
        frame.getContentPane().add(pnl_tfs, BorderLayout.EAST);
        frame.getContentPane().add(pnl_btns, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public JTextField getTf_name() {
    	return this.tf_name;
    }
    public void setTf_name(JTextField tf_uname) {
    	this.tf_name = tf_uname;
    }


    public JTextField getTf_id() {
    	return this.tf_id;
    }
    public void setTf_id(JTextField tf_id) {
    	this.tf_id = tf_id;
    }


    public JTextField getTf_phone() {
    	return this.tf_phone;
    }
    public void setTf_phone(JTextField tf_phone) {
    	this.tf_phone = tf_phone;
    }


    public JTextField getTf_address() {
    	return this.tf_address;
    }
    public void setTf_address(JTextField tf_address) {
    	this.tf_address = tf_address;
    }


    public JTextField getTf_email() {
    	return this.tf_email;
    }
    public void setTf_email(JTextField tf_email) {
    	this.tf_email = tf_email;
    }


    public JTextField getTf_daily_pat() {
    	return this.tf_daily_pat;
    }
    public void setTf_daily_pat(JTextField tf_daily_pat) {
    	this.tf_daily_pat = tf_daily_pat;
    }


    public JTextField getTf_daily_sub() {
    	return this.tf_daily_sub;
    }
    public void setTf_daily_sub(JTextField tf_daily_sub) {
    	this.tf_daily_sub = tf_daily_sub;
    }


    public JTextField getTf_spec() {
    	return this.tf_spec;
    }
    public void setTf_spec(JTextField tf_spec) {
    	this.tf_spec = tf_spec;
    }


    public JTextField getTf_daily_visit() {
    	return this.tf_daily_visit;
    }
    public void setTf_daily_visit(JTextField tf_daily_visit) {
    	this.tf_daily_visit = tf_daily_visit;
    }


    public JButton getBtn_edit() {
    	return this.btn_edit;
    }
    public void setBtn_edit(JButton btn_edit) {
    	this.btn_edit = btn_edit;
    }


    public JButton getBtn_delete() {
    	return this.btn_delete;
    }
    public void setBtn_delete(JButton btn_delete) {
    	this.btn_delete = btn_delete;
    }

}