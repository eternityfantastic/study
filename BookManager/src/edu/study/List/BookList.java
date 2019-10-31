package edu.study.List;

import edu.study.model.Book;
import edu.study.model.Customer;

public class BookList {

    private Book[] bookList = new Book[100]; ;
    private int useSize;

    public Book getBook(int i) {
        //返回位置i的位置
        return this.bookList[i];
    }

    public void setBook(Book book) {
        //给图书表尾巴添加图书
        bookList[useSize] = book;
        useSize++;
    }

    public void RootSetList(Book book, int i) {
        if (i > 0 && i < useSize) {
            bookList[i] = book;
        }
    }

    public int getUseSize() {
        return useSize;
    }

    public void setUseSize(int useSize) {
        this.useSize = useSize;
    }

    //检索功能
    public int search(String name){
        int size = useSize;
        for (int i = 0; i < size; i++) {
            if(name.equals(bookList[i].getName())){
                return i;
            }
        }
        return -1;
    }

    //show功能
    public void show() {
        for (int i = 0; i < useSize; i++) {
            Book book = this.getBook(i);
            System.out.print(book.toString());
        }
        System.out.println();
    }
}



















