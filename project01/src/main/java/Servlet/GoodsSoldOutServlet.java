package Servlet;

import dao.goodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//下架
@WebServlet("/delGoods")
public class GoodsSoldOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id")  ;

        String sql = "delete from goods where id=?";
        //删除
        boolean update = goodsDao.update(sql, id);


    }

}
