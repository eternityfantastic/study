package service;


import model.Customer;

import java.util.List;

public interface CustomerService {

	//设定标准
	//添加功能！
	public abstract boolean insertCustomer(Customer customer);

	//修改功能！
	public abstract boolean updateCustomer(Customer customer);

	//删除功能！
	public abstract boolean deleteCustomer(int id);

	//查询功能！
	public abstract List<Customer> selectCustomer();

	//根据id查询功能！
	public abstract Customer selectCustomerById(int id);

	//根据id或者tel进行模糊查询
	public abstract List<Customer> selectByIdOrName(String id, String tel);
}




