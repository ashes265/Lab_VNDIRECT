package edu.java.jaxp;

import java.util.StringJoiner;

public class Book {
    private String title;
    private String author;
    private float price;
    private int page;

    public Book() {
    }

    public Book(String title, String author, float price, int page) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        StringJoiner joiner=new StringJoiner(",");
        joiner.add(title).add(author).add(String.valueOf(price)).add(String.valueOf(page));
        return joiner.toString();
    }
}
