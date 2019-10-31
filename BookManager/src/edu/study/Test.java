package edu.study;

import edu.study.model.Admin;
import edu.study.model.Book;
import edu.study.model.Customer;

import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Admin admin1 = new Admin();
        while (true) {
            System.out.println("我是管理员按0键");
            System.out.println("我是VIP会员按1键");
            System.out.println("退出按2");
            int opt1 = scanner.nextInt();
            if (opt1 == 0) {
                System.out.println("1.添加会员");
                System.out.println("2.删除会员");
                System.out.println("3.添加图书");
                int opt2 = scanner.nextInt();
                if (opt2 == 1) {
                    System.out.println("输入要添加的会员名");
                    String name = scanner.next();
                    Customer customer = new Customer(name);
                    admin1.addCustomer(customer);
                    admin1.getCurtomerList().show();
                }
                if (opt2 == 2) {
                    System.out.println("输入要删除的会员名");
                    String name = scanner.next();
                    admin1.deleteCustomer(name);
                }
                if (opt2 == 3) {
                    System.out.println("输入书名");
                    String name = scanner.next();
                    System.out.println("输入作者");
                    String auther = scanner.next();
                    System.out.println("输入价格");
                    double price = scanner.nextDouble();
                    Book book1 = new Book(name, auther, price);
                    admin1.addBook(book1);
                    admin1.getAdminBookList().show();
                }
            }
            if (opt1 == 1) {
                System.out.println("欢迎来到西安工业大学图书馆");
                System.out.println("请出示你的会员名");
                String name = scanner.next();
                boolean check = admin1.check(name);
                if (check) {
                    int pos = admin1.getCurtomerList().search(name);
                    Customer vip = admin1.getCurtomerList().getCustomers(pos);
                    System.out.println("0 借阅图书");
                    System.out.println("1 归还图书");
                    int opt = scanner.nextInt();
                    if (opt == 0) {
                        System.out.println("你要借的书：");
                        String bookName = scanner.next();
                        vip.borrow(bookName, admin1);
                    }
                    if (opt == 1) {
                        System.out.println("你要还的书：");
                        String bookName = scanner.next();
                        vip.sentBack(bookName, admin1);
                    }
                    admin1.getAdminBookList().show();
                }
            }
        }
    }
}
