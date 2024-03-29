package dao;

import model.Account;
import util.JDBCDao;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//账号操作
public class accountDao {
    //增删改
    public static boolean update(Object... obj) {
        String sql = "insert into account (username,password) values(?,?)";
        return JDBCDao.update(true,sql, obj);
    }

    //查询
    public static Account query(Object... obj) {
        String sql ="select id,username,password from account where username=?and password=?";
        Connection conn = JDBCUtil.getCollection(true);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < obj.length; i++) {
                pstm.setObject(i + 1, obj[i]);
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstm, rs);
        }
        if (list.size() != 1) {
            //理论上只能查到一个用户
            return null;
        } else {
            return list.get(0);
        }
    }
}