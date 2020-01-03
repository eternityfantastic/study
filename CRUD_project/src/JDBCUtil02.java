import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil02 {
    private static DataSource DATESOURCE;
    public static String DRIVER;
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    static {
        try {
//            从配置文件中读取数据；
            Properties pro = new Properties();
            pro.load(new FileReader("src\\jdbc.properties"));
            DRIVER = pro.getProperty("driver");
            URL = pro.getProperty("url");
            USER = pro.getProperty("user");
            PASSWORD = pro.getProperty("password");
//            注册驱动
            Class.forName(DRIVER);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getCollection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}
