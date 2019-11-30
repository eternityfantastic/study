import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

public class DButil {
    public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动路径
    public static final String URL = "jdbc:mysql://localhost:3306/test";//连接数据库的路径
    public static final String USER = "root";//帐号
    public static final String PASSWORD = "root";//密码

    /**
     * 加载驱动器复制到lib
     * 加载jdbc驱动并将其注册到DriverManager中  Class.forName(DRIVER);
     * 建立数据库连接DriverManager.getConnection(URL, USER, PASSWORD);
     * 建立statement（执行无参数的sql命令）或者preparedStatement（执行带参数的sql命令）对象；
     * 执行sql
     * 访问结果集resultSet
     * 关闭对象
     */

    public static void main(String[] args) {
        //此方法本质上就是为了生成conn对象，并返回！
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            ((MysqlDataSource) mysqlDataSource).setURL(URL);
            mysqlDataSource.setUser(USER);
            mysqlDataSource.setPassword(PASSWORD);
            connection = mysqlDataSource.getConnection();

//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "insert into stu" + "id,name,sex,birthday,amout,resume" + "value(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            ((PreparedStatement) statement).setInt(1, 1);
            ((PreparedStatement) statement).setString(2, "小明");
            ((PreparedStatement) statement).setByte(3, (byte) 3);
//
//            statement.execute("insert into test value(1,tom,null)");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}