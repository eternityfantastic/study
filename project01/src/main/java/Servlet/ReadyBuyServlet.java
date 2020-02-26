package Servlet;

import common.OrderStatus;
import dao.goodsDao;
import model.Account;
import model.Goods;
import model.Order;
import model.OrderItem;

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
import java.util.List;

@WebServlet("/pay")
public class ReadyBuyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

//        "12-2,13-3,14-5"
        String goodsIdAndNum = req.getParameter("goodsIdAndNum");
        String regex = ",";
        String[] split = goodsIdAndNum.split(regex);
        List<Goods> goodsList = new ArrayList<>();
        for (String s : split) {
            String[] str = s.split("-");
            //查找id
            Goods goods = goodsDao.quarryById(Integer.parseInt(str[0]));
            //
            if (goods != null) {
                goods.setBuyNum(Integer.parseInt(str[1]));
                goodsList.add(goods);
            }
        }
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("user");

        Order order = new Order();
        order.setId(System.currentTimeMillis() + "");
        order.setAccount_id(account.getId());
        order.setAccount_name(account.getUsername());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        order.setCreate_time(LocalDateTime.now().format(dateTimeFormatter));
        int totalMoney = 0;
        int finalMoney = 0;

        for (Goods goods : goodsList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setGoodsId(goods.getId());
            orderItem.setGoodsName(goods.getName());
            orderItem.setGoodsInstroduce(goods.getIntroduce());
            orderItem.setGoodsNum(goods.getBuyNum());
            orderItem.setGoodsUnit(goods.getUnit());
            orderItem.setGoodsPrice(goods.getIntPrice());
            orderItem.setGoodsDiscount(goods.getDiscount());
            order.orderItemsList.add(orderItem);
            double curMoney = goods.getBuyNum() * goods.getIntPrice();
            totalMoney += curMoney;
            finalMoney += curMoney * goods.getDiscount() / 100;

        }
        order.setTatal_money(totalMoney);
        order.setActual_amount(finalMoney);
        order.setOrderStatus(OrderStatus.PAYING);


        resp.getWriter().println(" <html>");
        resp.getWriter().println("<p>" + " [用户名称] :" + order.getAccount_name() + " </p>");
        resp.getWriter().println("<p>" + " [订单编号] :" + order.getId() + "</p>");
        resp.getWriter().println("<p>" + " [订单状态] :" + order.getOrderStatus().getDesc() + "</p>");
        resp.getWriter().println("<p>" + " [创建时间] :" + order.getCreate_time() + "</p>");
        resp.getWriter().println("<p>" + "编号" + "名称 " + "数量 " + "单位 " + "单价(元)" + "</p>");
        resp.getWriter().println("<o1>");
        for (OrderItem orderItem : order.orderItemsList) {
            resp.getWriter().println("<li>" + orderItem.getGoodsName() + " " + orderItem.getGoodsNum() + " " + orderItem.getGoodsUnit() + " " + orderItem.getGoodsPrice() + "</1i>");
            resp.getWriter().println(" </o1>");
            resp.getWriter().println("<p>" + " [总金额] :" + order.getTatal_money() + "</p>");
            resp.getWriter().println("<p>" + " [优惠金额] :" + order.getDiscount() + "</p>");
            resp.getWriter().println("<p>" + " [应支付金额] :" + order.getActual_amount() + " </p>");
            resp.getWriter().println("<a href=\" buyGoodsServlet\">确认</a>");
            resp.getWriter().println("<a href= \"index. htm1\">取消</a>");
            resp.getWriter().println(" </htm1>");
        }
        HttpSession session2 = req.getSession();
        session2.setAttribute("order",order);
        session2.setAttribute("goodsList",goodsList);
    }
}
