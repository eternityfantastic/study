package util;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import javax.sql.DataSource;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;

public class DBUtil {
    public static final String URL = "jdbc:sqlite://";
    public static  volatile DataSource DATASOURSE ;

    private DBUtil(){}

    public static DataSource getDataSourse() throws URISyntaxException {
        if(DATASOURSE == null){
            synchronized (DBUtil.class){
                if(DATASOURSE==null){
//                    sqlite默认的时间日期格式是yyyy-mm-dd HH:mm:ss
                    SQLiteConfig config = new SQLiteConfig();
                    config.setDateStringFormat("yyyy-mm-dd HH:mm:ss");
//                    创建连接池对象
                    DATASOURSE = new SQLiteDataSource(config);
                    ((SQLiteDataSource)DATASOURSE).setUrl(getUrl());
                }
            }
        }
        return DATASOURSE;
    }
    public static Connection getConnection() throws SQLException, URISyntaxException {
        return getDataSourse().getConnection();
    }
    public static String getUrl () throws URISyntaxException {
        String dbName = "dbname.db";
//        ClassLoad是classes为相对路径
        URL url = DBUtil.class.getClassLoader().getResource(".");
        return "jdbc:sqlite://"+ new File(url.toURI()).getParent()+File.separator+dbName;
    }
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
    public static void close(Connection conn, Statement pstm) {
            close(conn,pstm,null);
    }

        public static void main(String[] args) throws SQLException, URISyntaxException {
            DBUtil.getConnection();
    }
}
