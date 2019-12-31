package servlet01;

import model.Admin;
import service.impl.AdminServiceImpl;
import servlet.HttpServlet;

import java.io.IOException;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 接取flag
		String flag = request.getParameter("flag");
		//2. 判断
		if ("goRegister".equals(flag)) {
			//点击超链接跳转到注册页面
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 解决中文乱码
		request.setCharacterEncoding("UTF-8");
		//2. 接取flag
		String flag = request.getParameter("flag");
		if ("doLogin".equals(flag)) {
			//执行登录校验！
			//1. 接取参数
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			//(1). 非空校验
			if ("".equals(name)) {
				String message = "帐号不能为空";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customer_login.jsp").forward(request, response);
				return;//结束当前方法的运行！
			}
			if ("".equals(password)) {
				String message = "密码不能为空";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customer_login.jsp").forward(request, response);
				return;//结束当前方法的运行！
			}

			//(2). 格式校验 --> 正则表达式
			//帐号：5~12位，英文开头，后面英文数字不限
			String nameReg = "[a-zA-Z][a-zA-Z0-9]{4,11}";
			if (!name.matches(nameReg)) {
				String message = "帐号格式有误";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customer_login.jsp").forward(request, response);
				return;//结束当前方法的运行！
			}
			//密码：5~12位，英文开头，后面英文数字不限
			String passwordReg = "[a-zA-Z][a-zA-Z0-9]{4,11}";
			if (!password.matches(passwordReg)) {
				String message = "密码格式有误";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customer_login.jsp").forward(request, response);
				return;//结束当前方法的运行！
			}

			//(3). 有效性校验 --> 调用查询方法
			AdminServiceImpl a1 = new AdminServiceImpl();
			Admin admin = new Admin();
			admin.setName(name);
			admin.setPassword(password);
			Admin result = a1.login(admin);
			if (result == null) {
				String message = "帐号或密码错误";
				request.setAttribute("message", message);
				request.getRequestDispatcher("customer_login.jsp").forward(request, response);
				return;//结束当前方法的运行！
			}

			//为了让后续画面都能够正常显示用户名，需要将用户数据存放到session作用域中
			HttpSession session = request.getSession();
			session.setAttribute("userName", name);

			//执行到此，登录成功！查询所有会员信息，并发送到首页！
			request.getRequestDispatcher("CustomerServlet?flag=doLogin").forward(request, response);
		} else if ("doRegister".equals(flag)) {
			//点击注册按钮，完成注册功能！
			//1. 接取参数
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String confirmPassoword = request.getParameter("confirmPassoword");
			//2. 注册校验
			//(1). 非空校验

			//(2). 格式校验

			//(3). 有效性校验(帐号是否重复？两次密码是否一致？)

			//3. 注册成功！调用注册方法！跳转到注册成功页面！
		}
	}
}






