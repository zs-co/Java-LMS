package library_management_system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Table {
    private JTable table1;
    private JPanel panel1;

    public Table(DefaultTableModel model, JPanel panel){
        table1.setModel(model);
        this.panel1 = panel;
        JFrame frame = new JFrame("Student List");

        JScrollPane pane = new JScrollPane(table1);
        panel1.add(pane);
        frame.add(panel1);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(500, 150);
        frame.setVisible(true);

    }
}
