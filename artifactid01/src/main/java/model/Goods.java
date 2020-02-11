package model;

import lombok.Data;

@Data
public class Goods {
    int id;
    String name;
    String introduce;
    int stock;
    String unit;
    int price;
    int discount;
}
