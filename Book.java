package com.example.myIO;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String writer;
    private int price;

    private int soldPrice; // 판매된 가격

    private int discPrice; // 할인 금액

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

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setDiscPrice(int discPrice) {
        this.discPrice = discPrice;
    }

    public int getDiscPrice() {
        return discPrice;
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
