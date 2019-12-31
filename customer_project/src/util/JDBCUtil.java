package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	//工具类，将JDBC重复的代码提取到此处
	public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动路径
	public static final String URL = "jdbc:mysql://localhost:3306/handsome";//连接数据库的路径
	public static final String USER = "root";//帐号
	public static final String PASSWORD = "root";//密码

	//1. 将前两步代码提取出来
	public static Connection getConn() {
		//此方法本质上就是为了生成conn对象，并返回！
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
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

	//JDBCUtil只需直接赋值即可！
}







