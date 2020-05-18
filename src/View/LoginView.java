package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView {
    private JFrame frame;

    private JPanel pnl_uname;
    private JPanel pnl_passwd;
    private JPanel pnl_buttons;

    private JButton btn_forgotPassword;
    private JButton btn_enter;

    private JTextField tf_uname;
    private JPasswordField tf_passwd;

    public LoginView() {

        // Frame Initialization
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(250, 250);

        // pnls Initialization
        pnl_buttons = new JPanel(new FlowLayout());
        pnl_buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnl_uname = new JPanel(new FlowLayout());
        pnl_uname.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnl_passwd = new JPanel(new FlowLayout());
        pnl_passwd.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Components Initialization
        JLabel lbl_passwd = new JLabel("Password");
        JLabel lbl_uname = new JLabel("Username");

        tf_uname = new JTextField(12);
        tf_passwd = new JPasswordField(12);

        btn_forgotPassword = new JButton("Forgot Password");
        btn_enter = new JButton("Login");

        // Add components to pnls
        pnl_uname.add(lbl_uname);
        pnl_uname.add(tf_uname);

        pnl_passwd.add(lbl_passwd);
        pnl_passwd.add(tf_passwd);

        pnl_buttons.add(btn_enter);
        pnl_buttons.add(btn_forgotPassword);

        // Add pnls to frame
        frame.getContentPane().add(pnl_uname, BorderLayout.NORTH);
        frame.getContentPane().add(pnl_passwd, BorderLayout.CENTER);
        frame.getContentPane().add(pnl_buttons, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public JTextField getTf_uname() {
        return this.tf_uname;
    }

    public void setTf_uname(JTextField tf_uname) {
        this.tf_uname = tf_uname;
    }

    public JPasswordField getTf_passwd() {
        return this.tf_passwd;
    }

    public void setTf_passwd(JPasswordField tf_passwd) {
        this.tf_passwd = tf_passwd;
    }

}