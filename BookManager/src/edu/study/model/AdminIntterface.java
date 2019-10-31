package edu.study.model;

public interface AdminIntterface {
    boolean check(String name);

    void addCustomer(Customer customer);

    boolean deleteCustomer(String name);


    //对图书表的管理

    void addBook(Book book);


    boolean deleBook(String name);
}
