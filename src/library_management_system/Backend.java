package library_management_system;

import java.util.ArrayList;

public class Backend {
    ArrayList<String> students = new ArrayList<>();
    ArrayList<String> Books = new ArrayList<>();

    public ArrayList<String> getStudents() {
        return students;
    }

    public ArrayList<String> getBooks() {
        return Books;
    }

    public void add_book(String book)
    {
        Books.add(book);
    }
    public void add_student(String stu){
        students.add(stu);
    }
}
