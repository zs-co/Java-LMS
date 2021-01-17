package LMS;

import java.util.ArrayList;

public class Book {
    private String name_of_bk, author;
    private int Edition, year;


    public Book(String name_of_bk, String author, int edition, int year) {
        this.name_of_bk = name_of_bk;
        this.author = author;
        Edition = edition;
        this.year = year;
    }

    public String getName_of_bk() {
        return name_of_bk;
    }

    @Override
    public String toString() {
        return "Book details:-" +
                "\nName='" + name_of_bk +
                "\nAuthor='" + author +
                "\nEdition=" + Edition +
                "\nyear=" + year
                + "\n\n";
    }

    public void setName_of_bk(String name_of_bk) {
        this.name_of_bk = name_of_bk;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return Edition;
    }

    public void setEdition(int edition) {
        Edition = edition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
