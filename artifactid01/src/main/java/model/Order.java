package model;

import common.OrderStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private String id;
    private int account_id;
    private String account_name;
    private String create_time;
    private String finish_time;
    private int actual_amount;
    private int tatal_money;
    private OrderStatus orderStatus;
    public List<OrderItem> orderItemsList = new ArrayList<>();

    public double getTatal_money() {
        return tatal_money / 100.0;
    }
    public int getTatal_moneyInt() {
        return tatal_money;
    }

    public double getActual_amount() {
        return actual_amount / 100.0;
    }
    public int getActual_amountInt() {
        return actual_amount;
    }


    public double getDiscount() {
        return (this.tatal_money - this.account_id)/100.0;
    }
}
