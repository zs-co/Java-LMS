package LMS;

import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Library {
    int tries = 0;
    int choice;
    boolean found = true;
    ArrayList<Student> students;
    ArrayList<Book> books;
    Admin admin;
    Scanner input = new Scanner(System.in);
    public Library(){
        books = new ArrayList();
        students = new ArrayList();
    }
    public void login()  {

        while (true){
        System.out.println("Please log in first. ");
        System.out.print("Username: ");
        String name = input.nextLine();
        System.out.print("Password: ");
        String password = input.next();

        admin = new Admin();//pass with space is not allowed.
            if(!(admin.getUsername().equals(name)) || !(admin.getPassword().equals(password)) && tries < 5){

                ++tries;
                if(tries < 5){
                    System.out.println("\n\033[31mInvalid username or password! \033[0m");
                    input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    clrscr();
                    continue;
                }

                else {
                    System.out.print("\033[31mToo many wrong attempts. \n\nLogin Failed\033[0m");
                    break;
                }

            }
            else {
                clrscr();
                System.out.println("\033[31m____***Welcome to Admin Menu!***____ \033[0m" );
                clrscr();
                break;
            }

        }

        login_menu();

    }
    public void login_menu(){
        System.out.print("1.student Management \n2.Books Management \n3.To exit \n>>>");
         choice = input.nextInt();
         if(choice < 1 || choice > 3){
             clrscr();
             System.out.println("\n\033[31mPlease enter valid choice\033[0m\n");
             clrscr();
             login_menu();
             clrscr();
         }
        if(choice > 0 || choice < 4){
            if(choice == 1){
                clrscr();
                student_management();
                clrscr();
            }
            else if(choice == 2){
                clrscr();
                books_management();
                clrscr();
            }
            else if(choice == 3){
                clrscr();
                System.out.print("\033[31mExiting\033[0m");
                for(int i = 0; i <= 5; i++){
                    System.out.print(". ");
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.exit(0);
            }
        }


    }
    public void student_management(){
        System.out.print("1.Add Student \n2.Delete Student \n3.Search Student \n4.Return to Main Menu \n>>>");
        choice = input.nextInt();
        if(choice < 0 || choice > 4){
            clrscr();
            System.out.println("\n\033[31mPlease select valid choice\033[0m\n");
            clrscr();
            student_management();
            clrscr();
        }
        input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if(choice > 0 || choice < 5){
            if(choice == 1 ) {
                clrscr();
                System.out.print("Student Name: ");
                String name = input.nextLine();
                System.out.print("Student id: ");
                int id = input.nextInt();
                Student s = new Student(name, id);
                add_student(s);
                System.out.print("\033[31m\nStudent is added successfully.\n\tPlease provide Library Account details below:-\033[0m \n\n");
                s.account_details();
                s.generate_penalty();
                clrscr();
                student_management();
            }
            else if(choice == 2){
                if(students.size() == 0){
                    System.out.println("\n\033[31mYou have no student to delete yet.\033[0m\n");
                }
                else {
                    System.out.print("Enter Student ID: ");

                    int id = input.nextInt();
                    clrscr();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == id) {
                            found = true;
                            System.out.print("\033[31mDo you really want to delete(0/1)\n\033[0m ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                students.remove(i);
                                System.out.println("\n\033[31mStudent is deleted Successfully. \033[0m\n");

                            } else {
                                System.out.println("\033[31m\nNot deleted. \033[0m\n");
                            }

                            clrscr();
                            student_management();
                        } else
                            found = false;


                    }
                    if (found == false) {
                        System.out.print("\033[31m\nStudent not found! \033[0m\n\n");
                    }
                }
                clrscr();
                student_management();
            }
            else if(choice == 3){
                if(students.size() == 0){
                    System.out.println("\n\033[31mYou have no student to search yet.\033[0m\n");
                }
                else {
                    clrscr();
                    System.out.print("1.Search All student \n2.Search any student \n>>>");
                    choice = input.nextInt();
                    clrscr();
                    input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    if (choice == 1) {
                        clrscr();
                        all_students();

                    } else {
                        System.out.print("Enter Student ID: ");
                        int id = input.nextInt();
                        clrscr();
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getId() == id) {
                                System.out.println(students.get(i).toString());
                                found = true;
                            } else
                                found = false;

                        }
                        if (found == false) {
                            System.out.println("\033[31m\nStudent not found. \033[0m\n");
                        }
                    }
                }
                clrscr();
                student_management();

            }
            else if(choice == 4)
                clrscr();
                        login_menu();

        }




    }
    public void books_management() {

        System.out.print("1.Add Book \n2.Remove Book \n3.Search Book \n4.Total Books \n5.Return to Main " +
                "Menu \n>>>");
        choice = input.nextInt();
        if(choice < 0 || choice >5){
            clrscr();
            System.out.println("\n\033[31mPlease select valid choice\033[0m\n");
            clrscr();
            books_management();
            clrscr();
        }
        input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (choice > 0 || choice < 6) {
            if (choice == 1) {
                System.out.print("Book Name: ");
                String name = input.nextLine();
                name = name.toLowerCase();
                System.out.print("Author: ");
                String author = input.nextLine();
                System.out.print("Edition: ");
                int edition = input.nextInt();
                System.out.print("Publishing year: ");
                int year = input.nextInt();
                Book bk = new Book(name, author, edition, year);
                add_book(bk);
                System.out.println("\n\033[31mBook is successfully added.\033[0m\n");
                clrscr();
                books_management();
            } else if (choice == 2) {
                if(books.size() == 0){
                    System.out.println("\n\033[31mYou have no books to delete yet. \033[0m\n");
                }
                else {
                    System.out.print("Book name: ");
                    String bk_name = input.nextLine();
                    clrscr();
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getName_of_bk().contains(bk_name.toLowerCase())) {
                            books.remove(i);
                            System.out.println("\n\033[31mBook is removed/deleted Successfully.\033[0m\n");
                            found = true;
                        } else
                            found = false;


                    }

                    if (found == false) {
                        System.out.println("\n\033[31mYou have no book having ''" + bk_name + "'' in name\033[0m\n");
                    }
                }
                clrscr();
                books_management();
            } else if (choice == 3) {
                if (books.size() == 0) {
                    System.out.println("\n\033[31mYou have no books to search yet.\033[0m\n");
                } else {
                    clrscr();
                    System.out.print("1.Search All Books \n2.Search any book \n>>>");
                    choice = input.nextInt();
                    clrscr();
                    input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    if (choice == 1) {
                        clrscr();
                        all_books();

                    } else {
                        System.out.print("Book name: ");
                        String bk_name = input.nextLine();
                        clrscr();
                        for (int i = 0; i < books.size(); i++) {
                            if (books.get(i).getName_of_bk().contains(bk_name.toLowerCase())) {
                                System.out.print(books.get(i).toString());
                                found = true;
                            } else
                                found = false;

                        }
                        if (found == false) {
                            System.out.println("\n\033[31mYou have no book having ''" + bk_name + "'' in name\033[0m\n");
                        }
                    }
                }
                clrscr();
                books_management();
            }
            else if(choice == 4){
                System.out.println("You have \033[31m" + books.size() + " book(s)\033[0m in total.");
                clrscr();
                books_management();
            }

            else{
                clrscr();
                login_menu();
            }
        }


        }

    public void add_student(Student st){
        students.add(st);
    }
    public void add_book(Book bk){
        books.add(bk);
    }
    public void clrscr(){
        System.out.print("\n\n<");
        for(int i = 0; i < 101; i++){
            System.out.print("-");
        }
        System.out.println(">\n\n");
    }
    public void student_intro(){
        clrscr();
        System.out.println("Name: \n\t\t\tZain ul abdin");
        System.out.println("Sap ID: \n\t\t\t19683");
        System.out.println("OOP: \n\t\t\tProject Artifact 04(working code)");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clrscr();
    }
    public void all_students(){
        for(int i = 0 ; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }
    public void all_books(){
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).toString());
        }

    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
