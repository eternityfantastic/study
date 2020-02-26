package dao;

import model.Goods;
import util.JDBCDao;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class goodsDao {
    //增删改
    public static boolean update(String sql, Object... obj) {
        return JDBCDao.update(true, sql, obj);
    }

    public static Goods quarryById(int id) {
        String sql = "select id,name,introduce,stock,unit,price,discount from goods where id=?";
        Connection conn = JDBCUtil.getCollection(true);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Goods> list = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            buildGoods(rs, list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstm, rs);
        }
        if (list.size() > 0) {
            //是否有此商品；
            return list.get(0);
        }
        return null;
    }

    public static int quarryStock(int id) {
        String sql = "select stock from goods where id=?";
        Connection conn = JDBCUtil.getCollection(true);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Integer> list = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstm, rs);
        }
        //是否有此商品；
        return list.get(0);
    }


    public static List<Goods> queryAll() {

        String sql = "select id,name,introduce,stock,unit,price,discount from goods";

        Connection conn = JDBCUtil.getCollection(true);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Goods> list = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            rs = pstm.executeQuery();
            buildGoods(rs, list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstm, rs);
        }
        return list;
    }

    private static void buildGoods(ResultSet rs, List<Goods> list) throws SQLException {
        while (rs.next()) {
            Goods goods = new Goods();
            goods.setId(rs.getInt("id"));
            goods.setName(rs.getString("name"));
            goods.setDiscount(rs.getInt("discount"));
            goods.setPrice(rs.getInt("price"));
            goods.setUnit(rs.getString("unit"));
            goods.setStock(rs.getInt("stock"));
            goods.setIntroduce(rs.getString("introduce"));
            list.add(goods);
        }
    }
}
