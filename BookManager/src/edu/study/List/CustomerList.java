package edu.study.List;

import edu.study.List.BookList;
import edu.study.model.Customer;

public class CustomerList {
    private Customer[] customerlist = new Customer[1024];
    private int useSize;

    //
    public Customer getCustomers(int pos) {
        return customerlist[pos];
    }

    public void setCustomers(Customer customers) {
        customerlist[useSize] = customers;
        useSize++;
    }

    public void RootSetCustomers(Customer customers, int pos) {
        customerlist[pos] = customers;
    }

    public int getSize() {
        return useSize;
    }

    public void setSize(int numOfCustomer) {
        useSize = numOfCustomer;
    }


    //检索功能
    public int search(String name) {
        int size = useSize;
        for (int i = 0; i < size; i++) {
            if (name.equals(customerlist[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    //show功能
    public void show() {
        for (int i = 0; i < useSize; i++) {
            Customer customer = this.getCustomers(i);
            System.out.print(customer.getName()+"   ");
            BookList list = customer.getCustomerBookList();
            int size =  list.getUseSize();
            for (int j = 0; j < size; j++) {
                System.out.println(list.getBook(i).toString());
                if(j != size-1 ){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
