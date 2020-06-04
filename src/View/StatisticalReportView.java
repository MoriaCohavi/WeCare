package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatisticalReportView {
    private JFrame frame;

    private JPanel pnl_btns;
    private JPanel pnl_lbls;

    private JLabel lbl_visitAvg;
    private JLabel lbl_dailyCount;
    private JLabel lbl_labDailyAvg;
    private JLabel lbl_subscriptionAvg;

    private JButton btn_export;

    public StatisticalReportView()
    {
            // Frame Initialization
            frame = new JFrame("Statistical details");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new BorderLayout());
            frame.setSize(350, 200);
    
            // Labels initialization
            lbl_visitAvg = new JLabel("Avergae time for single visit: ");
            lbl_dailyCount = new JLabel("Daily patients: ");
            lbl_labDailyAvg = new JLabel("Lab requests daily average: ");
            lbl_subscriptionAvg = new JLabel("Subscription day average: ");

            // Button initialization
            btn_export = new JButton("Export statistical report");

            pnl_lbls = new JPanel(new GridLayout(4, 1));
            pnl_lbls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pnl_lbls.add(lbl_visitAvg);
            pnl_lbls.add(lbl_dailyCount);
            pnl_lbls.add(lbl_labDailyAvg);
            pnl_lbls.add(lbl_subscriptionAvg);

            pnl_btns = new JPanel(new FlowLayout());
            pnl_btns.add(btn_export);

            // Add pnls to frame
           frame.getContentPane().add(pnl_lbls, BorderLayout.NORTH);
           frame.getContentPane().add(pnl_btns, BorderLayout.SOUTH);
           frame.setVisible(true);
    }

    public JLabel getLbl_visitAvg() {
    	return this.lbl_visitAvg;
    }
    public void setLbl_visitAvg(JLabel lbl_visitAvg) {
    	this.lbl_visitAvg = lbl_visitAvg;
    }


    public JLabel getLbl_dailyCount() {
    	return this.lbl_dailyCount;
    }
    public void setLbl_dailyCount(JLabel lbl_dailyCount) {
    	this.lbl_dailyCount = lbl_dailyCount;
    }


    public JLabel getLbl_labDailyAvg() {
    	return this.lbl_labDailyAvg;
    }
    public void setLbl_labDailyAvg(JLabel lbl_labDailyAvg) {
    	this.lbl_labDailyAvg = lbl_labDailyAvg;
    }


    public JLabel getLbl_subscriptionAvg() {
    	return this.lbl_subscriptionAvg;
    }
    public void setLbl_subscriptionAvg(JLabel lbl_subscriptionAvg) {
    	this.lbl_subscriptionAvg = lbl_subscriptionAvg;
    }


    public JButton getBtn_export() {
    	return this.btn_export;
    }
    public void setBtn_export(JButton btn_export) {
    	this.btn_export = btn_export; 
    }
}