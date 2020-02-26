package Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.goodsDao;
import model.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet("/browseGoods")
public class GoodsBrowseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("browseGoods");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        List<Goods> list = goodsDao.queryAll();

//      把list装换成Json发送到前端进行解析
        ObjectMapper mapper = new ObjectMapper();
//        将响应包推送给浏览器
        PrintWriter pw = resp.getWriter();
//        将list转换成字符串
        mapper.writeValue(pw,list);
        Writer writer = resp.getWriter();
        writer.write(pw.toString());
    }
}
