package library_management_system;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Table {
    private JTable table1;
    private JPanel panel1;
    public Table(JTable table, JPanel panel){
        this.table1 = table;
        this.panel1 = panel;
        JFrame frame = new JFrame("Student List");
        JTableHeader header = table1.getTableHeader();
        header.setBackground(Color.yellow);
        JScrollPane pane = new JScrollPane(table1);
        panel1.add(pane);
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setSize(500, 150);
        frame.setVisible(true);

    }
}
