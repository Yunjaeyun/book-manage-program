package com.example.myIO;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String writer;
    private int price;

    public Book(String title, String writer, int price) {
        this.title = title;
        this.writer = writer;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                '}';
    }
}
