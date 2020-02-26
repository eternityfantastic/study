package Servlet;

import dao.goodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateGoods")
public class GoodsUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int stock = Integer.parseInt(req.getParameter("stock"));
        String introduce = req.getParameter("introduce");
        String util = req.getParameter("util");
        int price = Integer.parseInt(req.getParameter("price"));

        int discount = Integer.parseInt(req.getParameter("discount"));

        //查询商品的数目
        int i = goodsDao.quarryStock(id);
        stock += i;
        String sql = "update goods set name=? ,introduce=?,stock=?,util=？,price=？,discount=？where id=?";
        boolean update = goodsDao.update(sql, name, introduce, stock, util, price, discount);
        if (update) {
            //修改成功
        } else {
            //失败；
        }


    }

}
