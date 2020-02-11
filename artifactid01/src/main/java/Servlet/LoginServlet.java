package Servlet;

import dao.accountDao;
import model.Account;
import util.ToSecret;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        password = ToSecret.toSecret(password);
        //查询数据库
        String sql ="select id,username,password from account where username=?and password=?";
        Account user = accountDao.query(sql);
        //
        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("index.html");
        }else{
            //查无此账号
        }


    }

}
