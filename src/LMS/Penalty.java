package LMS;

public class Penalty {
    private int fine, balance;


    public Penalty(int fine, int balance) {
        this.fine = fine;
        this.balance = balance;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "{" +
                "Fine=" + fine +
                ", Balance=" + balance +
                '}';
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
