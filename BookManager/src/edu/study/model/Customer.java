package edu.study.model;

import edu.study.List.BookList;

public class Customer implements CustomerInterface {
    //字段和方法：会员号（用户名），借阅到的图书（保存在表中）、行为方法

    private String name;
    BookList customerBookList ;

    public Customer(String name) {
        this.name = name;
        this.customerBookList = new BookList();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Book getCustomerBook(int pos) {
        return customerBookList.getBook(pos);
    }

    @Override
    public BookList getCustomerBookList() {
        return customerBookList;
    }

    @Override
    public void setCustomerBookList(BookList customerBookList) {
        this.customerBookList = customerBookList;
    }

    //借阅图书
    @Override
    public boolean borrow(String name, Admin admin) {
        //查库有无此书
        int  pos = admin.adminBookList.search(name);
        if(pos != -1){
            //自己将库加上次书
            Book book = admin.adminBookList.getBook(pos);
            customerBookList.setBook(book);
            //管理员删除此书
            admin.deleBook(name);
        }

        //管理员将库减上此书，自己将库加上次书
        return false;
    }

    //归还图书
    @Override
    public boolean sentBack(String name, Admin administrator) {
        //查库有无此书
        int search = customerBookList.search(name);
        //管理员将库加上此书，自己将库减去此书
        if (search != -1) {
            Book book = customerBookList.getBook(search);
            administrator.addBook(book);
            //删除此书，将尾巴书替换它
            int tail = customerBookList.getUseSize()-1;
            Book tailBook = customerBookList.getBook(tail);
            customerBookList.RootSetList(tailBook, search);
            customerBookList.setUseSize(tail);
            return true;
        } else {
            System.out.println("您没有借阅此书");
        }

        return false;
    }

}
