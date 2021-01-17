package LMS;

public class Account {
    private int bk_borrow, returned, issued, days;

    public Account(int bk_borrow, int returned,int issued, int days) {
        this.bk_borrow = bk_borrow;
        this.issued = issued;
        this.days = days;
        this.returned = returned;
    }

    public int getBk_borrow() {
        return bk_borrow;
    }

    public int getReturned() {
        return returned;
    }

    @Override
    public String toString() {
        return "{" +
                "books borrow=" + bk_borrow +
                ", Books returned=" + returned +
                ", Books Reserved=" + issued +
                ", last returned after =" + days + " days" +
                '}';
    }

    public int getIssued() {
        return issued;
    }

    public int getDays() {
        return days;
    }
}
