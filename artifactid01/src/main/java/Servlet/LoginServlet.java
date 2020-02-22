package Servlet;

import dao.accountDao;
import model.Account;
import util.ToSecret;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("login")
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

        Account user = accountDao.query(username,password);
        //
        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("index.html");
        }else{
            //查无此账号
            resp.sendRedirect("login.html");

        }


    }

}
