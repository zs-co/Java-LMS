package library_management_system;

import javax.swing.*;
import javax.swing.plaf.TableUI;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import LMS.*;

import static java.lang.Integer.parseInt;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import LMS.*;
public class book_menu {

    private JPanel basePane;
    private JTable table;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton SAVEButton;
    private JButton DELETEButton;
    private JButton BACKButton;
    private JPanel tablePanel;
    Library lib = new Library();
    Book book;
    DefaultTableModel model = new DefaultTableModel();
    public book_menu(JFrame f) {
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        f.setVisible(false);
        JFrame frame = new JFrame("Books Menu");
        frame.setSize(700, 500);
        model.addColumn("Book Name");
        model.addColumn("Author");
        model.addColumn("Published");
        model.addColumn("Edition");
        model.insertRow(0, new Object[] {"BOOK NAME", "AUTHOR", "EDITION", "PUBLISHED"});
        model.insertRow(1, new Object[] {" ______", " ______", " ______" , " ______ "});
        table.setGridColor(Color.GREEN);

        table.setModel(model);



        frame.setLocationRelativeTo(null);
        frame.setContentPane(basePane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "NOTE: \n\tAll data will be erased", "Warning!", JOptionPane.OK_OPTION);
                new Admin_menu(frame);
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                    JOptionPane.showMessageDialog(null, "Invalid input", "Warning!", JOptionPane.OK_OPTION);
                    textField1.setText("");
                }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Warning!", JOptionPane.OK_OPTION);
                    textField2.setText("");
                }
            }
        });
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char ch = e.getKeyChar();
                if(Character.isLetter(ch)){
                    JOptionPane.showMessageDialog(null, "Publish Year: 2000", "Example", JOptionPane.OK_OPTION);
                    textField3.setText("");
                }
            }
        });
        textField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char ch = e.getKeyChar();
                if(Character.isLetter(ch)){
                    JOptionPane.showMessageDialog(null, "Enter number of Edition only", "Warning!", JOptionPane.OK_OPTION);
                    textField4.setText("");
                }
            }
        });
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                table.setGridColor(Color.BLACK);
                try{
                String name = textField1.getText().toString();
                String author = textField2.getText().toString();
                int edition = Integer.parseInt(textField3.getText().toString());
                int published = Integer.parseInt(textField4.getText().toString());
                book = new Book(name, author, edition, published);
                lib.add_book(book);
                JOptionPane.showMessageDialog(null ,"Book is successfully added", "Message", JOptionPane.PLAIN_MESSAGE);
                Object[] row = {name, author, String.valueOf(edition), String.valueOf(published)};
                model.addRow(row);
                table.setModel(model);
            }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Empty field(s)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = true;
                int row_index = table.getSelectedRow();
                try {
                    model.removeRow(row_index);
                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Failed to delete row due to " + e1);
                }
            }
        });
    }
}
