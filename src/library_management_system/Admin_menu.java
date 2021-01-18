package library_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Admin_menu {

    public JPanel next_panel;
    private JButton studentsManagementMenuButton;
    private JButton BOOKMENUButton;
    private JButton BACKButton;

    public Admin_menu(JFrame frame) {
        frame.setVisible(false);
        JFrame frame1 = new JFrame("Library Management System");
        ImageIcon icon = new ImageIcon("bk.png");
        JLabel label = new JLabel();
        label.setIcon(icon);
        //label.setVerticalTextPosition(JLabel.TOP);
        //label.setHorizontalTextPosition(JLabel.CENTER);
        //next_panel.add(label);
        frame1.setSize(650, 500);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setContentPane(next_panel);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setBounds(10, 10, 650, 500);
        frame1.setVisible(true);

        studentsManagementMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student_Menu menu = new Student_Menu(frame1);
            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           int option = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
                System.exit(0);
            }
        });
    }

    public void nextFrame() {



    }
}

