package dao;

import model.Customer;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao {

	//深度封装增删改
	public static boolean update(String sql, Object ... obj) {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement pstm = null;
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
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

	//深度封装查询所有字段
	public static List<Customer> queryAll(String sql, Object ... obj) {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setScore(rs.getDouble(3));
				customer.setTel(rs.getString(4));
				customer.setSex(rs.getString(5));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, rs);
		}
		return list;
	}
}









