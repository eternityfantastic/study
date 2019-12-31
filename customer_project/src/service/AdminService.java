package service;
import model.Admin;

public interface AdminService {

	//设定标准
	//注册功能！
	public abstract boolean register(Admin admin);

	//登录功能！
	public abstract Admin login(Admin admin);
}
