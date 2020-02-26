package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/cash";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    private JDBCUtil() {
    }

    private static volatile DataSource DATESOURCE;

    private static DataSource getDATESOURCE() {
        if (DATESOURCE == null) {
            synchronized (JDBCUtil.class) {
                if (DATESOURCE == null) {
                    DATESOURCE = new MysqlDataSource();
                }
            }
        }
        ((MysqlDataSource) DATESOURCE).setURL(URL);
            /*等价
            ((MysqlDataSource) DATESOURCE).setServerName("localhost");
            ((MysqlDataSource) DATESOURCE).setPort(3306);
            ((MysqlDataSource) DATESOURCE).setDatabaseName("cash");
           */
        ((MysqlDataSource) DATESOURCE).setUser(USER);
        ((MysqlDataSource) DATESOURCE).setPassword(PASSWORD);
        //((MysqlDataSource) DATESOURCE).setUseSSL(false);
        ((MysqlDataSource) DATESOURCE).setCharacterEncoding("utf8");

        return DATESOURCE;
    }
//可能有事物回滚
    public static Connection getCollection(boolean autoCommit) {
        Connection connection = null;
        try {
            connection = getDATESOURCE().getConnection();
            connection.setAutoCommit(autoCommit);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取连接失败");
        }
        return connection;
    }


    //2. 将关闭资源的代码提取！
    public static void close(Connection conn, Statement pstm, ResultSet rs) {
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
}