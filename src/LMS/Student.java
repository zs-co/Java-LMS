package LMS;

import java.util.Scanner;

public class Student {
    private String name;
    private int id;
    Account account;
    Penalty penalty;
    Scanner input = new Scanner(System.in);

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student details:- " +
                "\nname='" + name  +
                "\nid=" + id +
                "\naccount=" + account +
                "\npenalty=" + penalty;
    }
    public void account_details(){
        System.out.print("Enter books borrowed: ");
        int bk_borrow = input.nextInt();
        System.out.print("Enter returned Books: ");
        int bk_returned = input.nextInt();
        System.out.print("Returned after(no. of days) : ");
        int days = input.nextInt();
        int issued = bk_borrow - bk_returned;
        account = new Account(bk_borrow, bk_returned,issued, days);
    }
    public void generate_penalty(){
        int fine;
        if(account.getDays() > 10) {
            fine = ((account.getDays() - 10) * 15) * account.getReturned();
            System.out.print("Your fine = " + fine + " (15pkr/book) \nPay Fine amount: ");
            int payment = input.nextInt();
            int balance = payment - fine;
            penalty = new Penalty(fine, balance);
        }
        else{
            penalty = new Penalty(0,0);
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

}
