package service.impl;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

	//负责写方法！
	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO 负责执行添加
		//1. 编写SQL语句
		String sql = "insert into customer values(?, ?, ?, ?, ?)";
		//2. 调用DAO中方法直接执行添加功能！
		return CustomerDao.update(sql, customer.getId(), customer.getName(), customer.getScore(), customer.getTel(), customer.getSex());
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO 执行修改功能！
		String sql = "update customer set customer_name = ?, customer_score = ?, customer_tel = ?, customer_sex = ? where customer_id = ?";
		return CustomerDao.update(sql, customer.getName(), customer.getScore(), customer.getTel(), customer.getSex(), customer.getId());
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> selectCustomer() {
		// TODO 执行全查询功能！
		String sql = "select customer_id, customer_name, customer_score, customer_tel, customer_sex from customer";
		return CustomerDao.queryAll(sql);
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO 执行根据id查询的功能！
		String sql = "select customer_id, customer_name, customer_score, customer_tel, customer_sex from customer where customer_id = ?";
		List<Customer> list = CustomerDao.queryAll(sql, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<Customer> selectByIdOrName(String id, String tel) {
		// TODO 执行根据id和tel进行模糊查询的功能！
		//将四种情况罗列出来
		List<Customer> list = null;
		if ("".equals(id) && "".equals(tel)) {
			//执行全查询
			String sql = "select customer_id, "
					+ "customer_name, "
					+ "customer_score, "
					+ "customer_tel, "
					+ "customer_sex "
					+ "from customer";
			list = CustomerDao.queryAll(sql);
		} else if (!"".equals(id) && "".equals(tel)) {
			//根据id模糊查询
			String sql = "select customer_id, "
					+ "customer_name, "
					+ "customer_score, "
					+ "customer_tel, "
					+ "customer_sex "
					+ "from customer where customer_id like ?";
			list = CustomerDao.queryAll(sql, "%" + id + "%");
		} else if ("".equals(id) && !"".equals(tel)) {
			//根据tel模糊查询
			String sql = "select customer_id, "
					+ "customer_name, "
					+ "customer_score, "
					+ "customer_tel, "
					+ "customer_sex "
					+ "from customer where customer_tel like ?";
			list = CustomerDao.queryAll(sql, "%" + tel + "%");
		} else if (!"".equals(id) && !"".equals(tel)) {
			//根据id和tel模糊查询
			String sql = "select customer_id, "
					+ "customer_name, "
					+ "customer_score, "
					+ "customer_tel, "
					+ "customer_sex "
					+ "from customer where customer_id like ? and customer_tel like ?";
			list = CustomerDao.queryAll(sql, "%" + id + "%", "%" + tel + "%");
		}
		return list;
	}

}
