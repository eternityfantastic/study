package common;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PAYING(1, "待支付"), OK(2, "支付完成");
    private int flg;
    private String desc;

    OrderStatus(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }

    OrderStatus valueOf(int flg) {

        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.flg == flg) {
                return orderStatus;
            }

        }
        throw new RuntimeException("not fund");
    }
}
