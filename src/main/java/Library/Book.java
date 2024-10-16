package Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Book {
    private String name;
    private String author;

    public Book() {};

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String toString() {
        String text = "Book Name: " + name +
                "\nAuthor: " + author;
        return text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString2() {
        String text = name + "</N>" + author;
        return text;
    }
}
