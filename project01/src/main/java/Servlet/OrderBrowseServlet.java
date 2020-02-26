package Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Account;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
@WebServlet("/orderbrowse")
public class OrderBrowseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

//        根据当前用户ID查询，在“”表中当前用户的订单；
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("user");
//        查询结果可能有多个订单，也可能没有
//        List<Order> orderList;
////        如果有订单，就将订单list转成json传给前端
//
////        把list装换成Json发送到前端进行解析
//        ObjectMapper mapper = new ObjectMapper();
////        将响应包推送给浏览器
//        PrintWriter pw = resp.getWriter();
////        将list转换成字符串
//        mapper.writeValue(pw, orderList);
//        Writer writer = resp.getWriter();
//        writer.write(pw.toString());
//

    }

}
