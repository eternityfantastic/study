package dao;

import model.Order;
import model.OrderItem;
import util.JDBCDao;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class orderDao {
    public static boolean commitOrder(Order order) {


//        String insertOrder = "insert into `order`(id,account_id, create_time, finish_time, " +
//                "actual_amount, total_money, order_status, account_name) values (?,?,now(),now(),?,?,?,?)";
//
//        String insertOrderItem = "insert into order_item(order_id, goods_id, goods_name,goods_introduce, goods_num, goods_unit," +
//                "goods_price, goods_discount) values (?,?,?,?,?,?,?,?)";

        String insertOrder ="insert into  `order` "+
                "(id,account_id,account_name,create_time,finish_time,"+
                "actual_amount,total_money,order_status)values(?,?,?,now(),now(),?,?,?)";

        Object[] obj1 = {order.getId(),order.getAccount_id(),order.getAccount_name(),
              order.getActual_amountInt(),order.getTatal_moneyInt(),order.getOrderStatus().getFlg()};
        boolean update = JDBCDao.update(false, insertOrder, obj1);
        if(update){
            System.out.println("订单表插入成功");
            //开始订单项表的插入
            updateTransaction(order);
            return true;
        }else{
            System.out.println("订单表插入失败");
            return false;
        }

    }


    private static void updateTransaction(Order order){
        String sql = "insert into order_item " +
                "(id,order_id,goods_id,goods_name,goods_introduce," +
                "goods_num,goods_unit,goods_price,goods_discount)" +
                "values(?,?,?,?,?,?,?,?,?)";

        Connection conn = JDBCUtil.getCollection(false);
        PreparedStatement pstm = null;
        int[] result = null;

        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            给占位符传值；
            for (OrderItem orderItem : order.orderItemsList) {
                Object[] obj = {orderItem.getId(),orderItem.getOrderId(),orderItem.getGoodsId(),
                        orderItem.getGoodsName(),orderItem.getGoodsInstroduce(), orderItem.getGoodsNum(),
                        orderItem.getGoodsUnit(), orderItem.getGoodsPrice(), orderItem.getGoodsDiscount()};

                for (int i = 0; i < obj.length; i++) {
                    pstm.setObject(i + 1, obj[i]);
                }
                //将每一项的pstm缓存起来；
                pstm.addBatch();
            }
            result = pstm.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstm, null);
        }
        for (int i : result) {
            if(i==0){
                throw new RuntimeException("插入失败");
            }
        }
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }
}
