package dao;

import model.Admin;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
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



		//深度封装查询
		public static List<Admin> queryAll(String sql, Object ... obj) {
			Connection conn = JDBCUtil.getConn();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			List<Admin> list = new ArrayList<>();
			try {
				pstm = conn.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
				rs = pstm.executeQuery();
				while (rs.next()) {
					Admin admin = new Admin();
					admin.setId(rs.getInt(1));
					admin.setName(rs.getString(2));
					admin.setPassword(rs.getString(3));
					list.add(admin);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstm, rs);
			}
			return list;
		}
	}
