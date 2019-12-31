package servlet01;

import model.Customer;
import service.impl.CustomerServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. ����flag���ж�ǰ�˻���ִ�й��ܣ�
		String flag = request.getParameter("flag");
		if ("goInsert".equals(flag)) {
			//�����ӳ����ӣ���ת����ӻ��棡
			//ע�⣺ǰ�˻���һ��Ҫ����ת����̨��Ȼ��ͨ����̨��ת��ִ��ҳ��
			request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
		} else if ("goUpdate".equals(flag)) {
			//����޸ĳ�������ת���޸Ļ��棬������ǰ�����Ӷ�Ӧ�����ݷ��͵�ָ��������
			//1. ����id
			String id = request.getParameter("id");
			//2. ����id��ѯ��ǰ���� --> ���÷���
			CustomerServiceImpl c1 = new CustomerServiceImpl();
			Customer customer = c1.selectCustomerById(Integer.parseInt(id));
			//3. �����ݴ��
			request.setAttribute("customer", customer);
			//4. ��ת���޸�ҳ���У�
			request.getRequestDispatcher("customer_update.jsp").forward(request, response);
		} else if ("goIndex".equals(flag)) {
			//�����ҳ��������ת����ҳ�� --> �κν��뵽��ҳ��������뷢�����ݵ���ҳ��չʾ��
			//1. ����ȫ��ѯ
			CustomerServiceImpl c1 = new CustomerServiceImpl();
			List<Customer> list = c1.selectCustomer();
			//2. �������
			request.setAttribute("list", list);
			//3. ��ת����ҳ��
			request.getRequestDispatcher("customer_index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. �����������
		request.setCharacterEncoding("UTF-8");
		//2. ����flag���ж�ǰ�˻���ִ�й��ܣ�
		String flag = request.getParameter("flag");
		if ("doLogin".equals(flag)) {
			//ִ�е�¼����ת����ҳ��(������ҳ��չʾ��������Ҫ�����ݿ��в�ѯ�õ�)
			//(1). �Ȳ�ѯ���ݿ������е����� --> ���ò�ѯ����
			CustomerServiceImpl c1 = new CustomerServiceImpl();
			List<Customer> list = c1.selectCustomer();
			//(2). ����ѯ�õ����ݴ��
			request.setAttribute("list", list);
			//(3). ��ת����ҳ
			request.getRequestDispatcher("customer_index.jsp").forward(request, response);
		} else if ("doInsert".equals(flag)) {
			//ִ����ӹ��ܣ���������ӵ����ݿ��У�
			//1. ���ղ�����
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String score = request.getParameter("score");
			String tel = request.getParameter("tel");
			String sex = request.getParameter("sex");
			//2. ������ӷ�������������ӵ����ݿ��У�
			CustomerServiceImpl c1 = new CustomerServiceImpl();
			//3. ��������յ������ݴ���ɶ���
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(id));
			customer.setName(name);
			customer.setScore(Double.parseDouble(score));
			customer.setTel(tel);
			customer.setSex(sex);
			//4. ����ִ�з���
			boolean result = c1.insertCustomer(customer);
			//5. ����ж�
			if (result) {
				//��ӳɹ�����ת����ӳɹ�ҳ�棡(��Ҫ������ݷ���)
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("customer_insertok.jsp").forward(request, response);
			} else {
				//���ʧ�ܣ��ص����ҳ��
				request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
			}
		} else if ("doUpdate".equals(flag)) {
			//ִ���޸ģ�
			//1. ��ȡ����
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String score = request.getParameter("score");
			String tel = request.getParameter("tel");
			String sex = request.getParameter("sex");
			//2. ���÷���
			//����ȡ�Ĳ��������������
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(id));
			customer.setName(name);
			customer.setScore(Double.parseDouble(score));
			customer.setTel(tel);
			customer.setSex(sex);
			//����service�е��޸ķ���
			CustomerServiceImpl c1 = new CustomerServiceImpl();
			boolean result = c1.updateCustomer(customer);
			//3. �ж�
			if (result) {
				//ִ�гɹ�����ת���޸ĳɹ����棡
				//����޸ĺ������
				request.setAttribute("customer", customer);
				//��ת���޸�ҳ��
				request.getRequestDispatcher("customer_updateok.jsp").forward(request, response);
			} else {
				//ִ��ʧ�ܣ���ת���޸�ҳ�棡
				request.getRequestDispatcher("customer_update.jsp").forward(request, response);
			}
		} else if ("doSelect".equals(flag)) {
			//�������ִ��ģ����ѯ
			//1. ��ȡ����(����ı�����û�������κ����ݣ�������̨���ǿ��ַ�����)
			String id = request.getParameter("id");
			String tel = request.getParameter("tel");
			//2. ���÷��������е��߼�����ҵ����д���
			//(�߼����ж�id��tel�Ƿ���ֵ)
			CustomerServiceImpl c1 = new CustomerServiceImpl();
			List<Customer> list = c1.selectByIdOrName(id, tel);
			//3. �������
			request.setAttribute("list", list);
			//4. ��תҳ�棡
			request.getRequestDispatcher("customer_index.jsp").forward(request, response);
		}
	}

}





