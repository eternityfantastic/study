package edu.study.model;

public class Book {
    private String name;
    private String author;
    private double price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return author;
    }

    public void setAuther(String auther) {
        this.author = auther;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, String auther, double price) {
        this.name = name;
        this.author = auther;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' +
                ", author='" + author + '\'' + ", price="
                + price + '}';
    }
}
