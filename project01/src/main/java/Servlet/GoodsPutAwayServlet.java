package Servlet;

import dao.goodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inbound")
public class GoodsPutAwayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        int stock = Integer.parseInt(req.getParameter("stock"));
        String introduce = req.getParameter("introduce");
        String unit = req.getParameter("unit");
        String price = req.getParameter("price");
        double price1 = Double.parseDouble(price);
        int realPrice = (int) (price1 * 100);
        int discount = Integer.parseInt(req.getParameter("discount"));

        String sql = "insert into goods(name ,introduce,stock,unit,price,discount)values(?,?,?,?,?,?)";
        boolean update = goodsDao.update(sql, name, introduce, stock, unit, realPrice, discount);
        if (update) {
            //添加成功
            resp.sendRedirect("index.html");
        }

    }

}
