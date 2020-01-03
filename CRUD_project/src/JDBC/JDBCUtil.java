package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCUtil {

    private static  volatile DataSource DATESOURCE = null;

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private JDBCUtil() {
    }

    public  static DataSource getDATESOURCE() {
        if (DATESOURCE == null) {
            synchronized (DataSource.class){
                if(DATESOURCE == null){
                    DATESOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATESOURCE).setURL(URL);
                    ((MysqlDataSource) DATESOURCE).setUser(USER);
                    ((MysqlDataSource) DATESOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATESOURCE;
    }

    public  static Connection getCollection() {
        Connection connection = null;
        try {
            connection = (Connection) getDATESOURCE().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //2. 将关闭资源的代码提取！
    public static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement pstm) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
