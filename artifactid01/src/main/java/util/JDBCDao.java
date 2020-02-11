package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDao {
    //深度封装增删改
    public static boolean update(String sql, Object ... obj) {
        Connection conn = JDBCUtil.getCollection(false);
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(sql);
//            给占位符传值；
            for (int i = 0; i < obj.length; i++) {
                pstm.setObject(i + 1, obj[i]);
            }
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstm, null);
        }
        return result > 0 ? true : false;
    }
}
