package library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_page  {
    private JPanel Login;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JButton cancelButton;



    public Login_page() {

        JFrame frame = new JFrame("Library Management System");
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setContentPane(Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10,10,420, 360) ;

        frame.setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals("admin") && passwordField1.getText().equals("admin")){
                    JOptionPane.showMessageDialog(Login, "Login successfully!", "Congratulations",JOptionPane.PLAIN_MESSAGE );

                    Admin_menu menu = new Admin_menu(frame);

                }
                else if(textField1.getText().equals("") || passwordField1.getText().equals("")){
                    JOptionPane.showMessageDialog(Login, "One or more empty fields", "Error", JOptionPane.OK_OPTION);
                }
                else{
                    JOptionPane.showMessageDialog(Login, "Invalid Username or Password!", "Login Failed!", JOptionPane.OK_OPTION);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(Login, "Are you sure want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if(opt == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }


}
