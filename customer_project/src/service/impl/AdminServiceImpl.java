package service.impl;

import dao.AdminDao;
import model.Admin;
import service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean register(Admin admin) {
		// TODO 执行注册功能！
		String sql ="INSERT INTO student (id, sn, name) VALUES";

		AdminDao.update(sql,)
		String sql1 = "insert admin_id, admin_name, admin_password into admin where admin_name = ? and admin_password = ?";
		List<Admin> list = AdminDao.queryAll(sql, admin.getName(), admin.getPassword());
		//return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Admin login(Admin admin) {
		// TODO 执行登录功能！
		String sql = "select admin_id, admin_name, admin_password from admin where admin_name = ? and admin_password = ?";
		List<Admin> list = AdminDao.queryAll(sql, admin.getName(), admin.getPassword());
		return list.size() > 0 ? list.get(0) : null;
	}

}
