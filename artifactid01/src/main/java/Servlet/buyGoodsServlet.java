package Servlet;

import common.OrderStatus;
import dao.goodsDao;
import dao.orderDao;
import model.Goods;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 点击完确认后，执行buyGoodsServlet，进行插入订单和订单项到数据库
 * 而这些操作都涉及到实务操作
 * 如果插入不成功需要进行手动提交事务
 */
@WebServlet("/buyGoodsServlet")
public class buyGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        ArrayList<Goods> goodsList = (ArrayList<Goods>)session.getAttribute("goodsList");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        order.setFinish_time(LocalDateTime.now().format(dateTimeFormatter));
        //点击确认后订单状态就是Ok了
        order.setOrderStatus(OrderStatus.OK);
        //开始提交订单（订单插入到数据库）
        boolean effect = orderDao.commitOrder(order);
        if(effect){
            //订单提交成功，商品出库（修改库存）
            for (Goods goods : goodsList) {
                String sql = "update goods set stock=? where id=?";
                boolean update = goodsDao.update(sql,goods.getStock()-goods.getStock(),goods.getId());
                if(update){
                    System.out.println("库存更新成功");
                    resp.sendRedirect("goodsBrowse.html");
                }else{
                    System.out.println("更新库存失败");
                }
            }
        }
    }
}
