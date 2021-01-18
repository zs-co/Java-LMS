package library_management_system;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {


        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        new Login_page();

    }
}
