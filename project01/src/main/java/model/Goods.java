package model;

import lombok.Data;

@Data
public class Goods {
    private int id;
    private String name;
    private String introduce;
    private int stock;
    private int buyNum;
    private String unit;
    //输入的double以int存储
    private int price;
    private int discount;
    public double getPrice(){
        return price/100.0;
    }
    public int getIntPrice(){
        return price;
    }
}
