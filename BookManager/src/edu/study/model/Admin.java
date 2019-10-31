package edu.study.model;

import edu.study.List.BookList;
import edu.study.List.CustomerList;

public class Admin implements AdminIntterface {

    //字段和方法：图书信息库、会员信息库以及管理员的工作行为

    BookList adminBookList = new BookList();

    public BookList getAdminBookList() {
        return adminBookList;
    }

    public CustomerList getCurtomerList() {
        return curtomerList;
    }

    CustomerList curtomerList = new CustomerList();

    //对会员表的管理
    @Override
    public boolean check(String name){
        int search = curtomerList.search(name);
        if(search != -1){
            System.out.println("身份确认完成");
            return true;
        }
        System.out.println("404");
        return false;
    }
    @Override
    public void addCustomer(Customer customer) {
        curtomerList.setCustomers(customer);
    }
    @Override
    public boolean deleteCustomer(String name) {
        //查找
        int pos = curtomerList.search(name);
        //删除
        if (pos != -1) {
            //Customer customer = curtomerList.getCustomers(pos);
            int tail = curtomerList.getSize() - 1;
            Customer tailCustomer = curtomerList.getCustomers(tail);
            curtomerList.RootSetCustomers(tailCustomer, pos);
            curtomerList.setSize(tail);
            return true;
        }
        return false;
    }


    //对图书表的管理
    @Override
    public void addBook(Book book) {
        adminBookList.setBook(book);
    }

    @Override
    public boolean deleBook(String name) {
        //查找
        int pos =adminBookList.search(name);
        //删除
        if (pos != -1) {
            int tail = adminBookList.getUseSize() - 1;
            Book tailBook = adminBookList.getBook(tail);
            adminBookList.RootSetList(tailBook, pos);
            adminBookList.setUseSize(tail);
            return true;
        }
        return false;
    }

}
