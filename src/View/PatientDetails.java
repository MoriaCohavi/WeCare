package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatientDetails {
    private JFrame frame;

    private JPanel pnl_btns;
    private JPanel pnl_tfs;
    private JPanel pnl_lbls;

    private JTextField tf_name;
    private JTextField tf_id;
    private JTextField tf_phone;
    private JTextField tf_address;
    private JTextField tf_email;
    private JTextField tf_gender;
    private JTextField tf_age;
    private JTextField tf_weight;
    private JTextField tf_height;
    private JTextField tf_allergies;
    private JTextField tf_chronicDiseases;
    private JTextField tf_subscription;

    private JButton btn_save;
    private JButton btn_cancel;

    public PatientDetails()
    {
           // Frame Initialization
           frame = new JFrame("Patient details");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.getContentPane().setLayout(new BorderLayout());
           frame.setSize(500, 500);
   
           // Labels pnl initialization
           String[] labels = {"Name: ", "Id: ", "Email: ", "Address: ", "Phone: ", "Age: ", "Gender: ", "Weight: ", "Height: ", "Allergies: ", "Chronic diseases: ", "Subscriptions: "};
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
           tf_gender = new JTextField();
           tf_age = new JTextField();
           tf_weight = new JTextField();
           tf_height = new JTextField();
           tf_allergies = new JTextField();
           tf_chronicDiseases = new JTextField();
           tf_subscription = new JTextField();
           /* -------------- */
           pnl_tfs = new JPanel(new GridLayout(numPairs, 1));
           pnl_tfs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
           pnl_tfs.add(tf_name);
           pnl_tfs.add(tf_id);
           pnl_tfs.add(tf_address);
           pnl_tfs.add(tf_email);
           pnl_tfs.add(tf_phone);
           pnl_tfs.add(tf_gender);
           pnl_tfs.add(tf_age);
           pnl_tfs.add(tf_weight);
           pnl_tfs.add(tf_height);
           pnl_tfs.add(tf_allergies);
           pnl_tfs.add(tf_chronicDiseases);
           pnl_tfs.add(tf_subscription);
   
           // Buttons pnl initialization
           btn_save = new JButton("Save");
           btn_cancel = new JButton("Cancel");
           pnl_btns = new JPanel(new FlowLayout());
           pnl_btns.add(btn_save);
           pnl_btns.add(btn_cancel);
   
           // Add pnls to frame
           frame.getContentPane().add(pnl_lbls, BorderLayout.WEST);
           frame.getContentPane().add(pnl_tfs, BorderLayout.EAST);
           frame.getContentPane().add(pnl_btns, BorderLayout.SOUTH);
           frame.setVisible(true);
    }

    public JTextField getTf_name() {
    	return this.tf_name;
    }
    public void setTf_name(JTextField tf_name) {
    	this.tf_name = tf_name;
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


    public JTextField getTf_gender() {
    	return this.tf_gender;
    }
    public void setTf_gender(JTextField tf_gender) {
    	this.tf_gender = tf_gender;
    }


    public JTextField getTf_age() {
    	return this.tf_age;
    }
    public void setTf_age(JTextField tf_age) {
    	this.tf_age = tf_age;
    }


    public JTextField getTf_weight() {
    	return this.tf_weight;
    }
    public void setTf_weight(JTextField tf_weight) {
    	this.tf_weight = tf_weight;
    }


    public JTextField getTf_height() {
    	return this.tf_height;
    }
    public void setTf_height(JTextField tf_height) {
    	this.tf_height = tf_height;
    }


    public JTextField getTf_allergies() {
    	return this.tf_allergies;
    }
    public void setTf_allergies(JTextField tf_allergies) {
    	this.tf_allergies = tf_allergies;
    }


    public JTextField getTf_chronicDiseases() {
    	return this.tf_chronicDiseases;
    }
    public void setTf_chronicDiseases(JTextField tf_chronicDiseases) {
    	this.tf_chronicDiseases = tf_chronicDiseases;
    }


    public JTextField getTf_subscription() {
    	return this.tf_subscription;
    }
    public void setTf_subscription(JTextField tf_subscription) {
    	this.tf_subscription = tf_subscription;
    }


    public JButton getBtn_save() {
    	return this.btn_save;
    }
    public void setBtn_save(JButton btn_save) {
    	this.btn_save = btn_save;
    }


    public JButton getBtn_cancel() {
    	return this.btn_cancel;
    }
    public void setBtn_cancel(JButton btn_cancel) {
    	this.btn_cancel = btn_cancel;
    }

}