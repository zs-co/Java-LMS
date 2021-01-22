package library_management_system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import LMS.Library;
import LMS.Student;

public class Student_Menu extends Library {
    ArrayList<Std_details> std_details;
    private JButton addStudentButton;
    private JButton deleteStudentButton;
    private JButton searchStudentButton;
    private JPanel Std_panel;
    private JButton BACKButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table;
    ArrayList<Integer> student_ids = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    boolean found = true;
    Library lib = new Library();

    public Student_Menu(JFrame f) {
        f.setVisible(false);
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(700, 600);
        frame.setLayout(null);
        frame.setContentPane(Std_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "One or more empty fields");
                }
                else
                    {

                    Student student = new Student(textField2.getText().toString(), Integer.parseInt(textField1.getText().toString()));
                    //Student student1 = new Student("Hamza ", 32);
                    if(lib.getStudents().size() == 0)
                    {
                        lib.add_student(student);
                        JOptionPane.showMessageDialog(null,"Student is successfully added.");
                    }

                    else {
                        for (int i = 0; i < lib.getStudents().size(); i++) {
                            if (Integer.parseInt(textField1.getText().toString()) == lib.getStudents().get(i).getId()) {
                                JOptionPane.showMessageDialog(null, "Student with ID: " + lib.getStudents().get(i).getId() + " already exists.");
                                found = true;
                                break;
                            } else
                                found = false;
                        }
                        if(found == false){
                            lib.add_student(student);
                            JOptionPane.showMessageDialog(null, "Student is successfully added.");
                        }
                    }

                }

            }
        });

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "NOTE: \n\tAll Data will be erased, project do not contain filing", "Warning!", JOptionPane.OK_OPTION);
                new Admin_menu(frame);

            }
        });
        deleteStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lib.getStudents().size() > 0){

                    String input = JOptionPane.showInputDialog("Enter ID of Student: ");
                    int id = Integer.parseInt(input);
                    for(int i = 0; i < lib.getStudents().size(); i++){
                        if(id == lib.getStudents().get(i).getId()){
                            int opt = JOptionPane.showConfirmDialog(null,"Do you really want to delete "+ lib.getStudents().get(i).getName() + "?", "Delete", JOptionPane.YES_NO_OPTION);
                        if(opt == JOptionPane.YES_OPTION){
                            lib.getStudents().remove(i) ;
                            JOptionPane.showMessageDialog(null, "Deleted successfully");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Student is not deleted");
                        }
                            found = true;
                            break;

                                         }
                        else
                            found = false;
                    }
                    if(found == false){
                        JOptionPane.showMessageDialog(null,"Student not found in the list", "Sorry", JOptionPane.OK_OPTION);
                    }

                }
                else
                    JOptionPane.showMessageDialog(null, "Please add students first");
            }
        });
        searchStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lib.getStudents().size() > 0) {
                    int choice = JOptionPane.showConfirmDialog(null, "Do you want to see all Students?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                         JPanel panel = new JPanel();
                        Object[] col = {"Name", "SAP ID"};
                        DefaultTableModel model = new DefaultTableModel();
                        model.setColumnIdentifiers(col);
                        table = new JTable();
                        table.setModel(model);
                        for (int i = 0; i < lib.getStudents().size(); i++) {
                            Object data[] = {lib.getStudents().get(i).getName(), String.valueOf(lib.getStudents().get(i).getId())};
                            model.addRow(data);
                        }
                            new Table(model,panel);


                    } else {
                        String input = JOptionPane.showInputDialog("Enter ID to search: ");
                        int id = Integer.parseInt(input);
                        for (int i = 0; i < lib.getStudents().size(); i++) {
                            if (id == lib.getStudents().get(i).getId()) {
                                JOptionPane.showMessageDialog(null, "Name: " + lib.getStudents().get(i).getName() + "\nID: " + lib.getStudents().get(i).getId());
                                found = true;
                                break;
                            } else
                                found = false;
                        }
                        if (found == false) {
                            JOptionPane.showMessageDialog(null, "No student has ID: " + id + " in our list");
                        }
                    }
                }

                else
                    JOptionPane.showMessageDialog(null , "Please add students first" );
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char ch = e.getKeyChar();
                if(Character.isLetter(ch))
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid ID");
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
                    JOptionPane.showMessageDialog(null , "Numbers are not allowed");
                    textField2.setText("");
                }
            }
        });
    }
    public void add_student_id(int id){
        student_ids.add(id);
    }
    public void add_stud(Student st){
        students.add(st);
    }
}
