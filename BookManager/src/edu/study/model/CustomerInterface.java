package edu.study.model;

import edu.study.List.BookList;

public interface CustomerInterface {
    String getName();

    void setName(String name);

    Book getCustomerBook(int pos);

    BookList getCustomerBookList();

    void setCustomerBookList(BookList customerBookList);

    //借阅图书

    boolean borrow(String name, Admin admin);

    //归还图书

    boolean sentBack(String name, Admin administrator);
}
