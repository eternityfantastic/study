package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDao {
    //深度封装增删改
    public static boolean update(Boolean autoCommmit, String sql, Object... obj) {
        Connection conn = JDBCUtil.getCollection(autoCommmit);
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
        return result > 0;
    }
}
