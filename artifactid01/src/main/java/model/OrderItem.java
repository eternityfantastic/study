package model;

import lombok.Data;

@Data
public class OrderItem {
    private int id;
    private String orderId;
    private int goodsId;
    private String goodsName;
    private String goodsInstroduce;
    private int goodsNum;
    private String goodsUnit;
    private int goodsPrice;
    private int goodsDiscount;

    public double getGoodsPrice() {
        return goodsPrice / 100.0;
    }

}
