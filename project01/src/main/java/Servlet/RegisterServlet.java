package Servlet;

import dao.accountDao;
import util.ToSecret;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
    //密码进行加密
        password = ToSecret.toSecret(password);
    //插入数据库

        boolean update = accountDao.update(username, password);
        if(update){
            //注册成功
            resp.sendRedirect("login.html");
        }else{
            //注册失败
            resp.sendRedirect("register.html");
        }


    }

}
