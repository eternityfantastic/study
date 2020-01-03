package servlet.http_servlet;

import JDBC.JDBCDao;
import model.Admin;

import java.util.List;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request request, Response resp) throws Exception {

        String username = request.parameters.get("username");
        String password = request.parameters.get("password");
        if (username == null || password == null) {
            resp.setStatusAndDescribe("401 Unauthorized");
            resp.setBodyBuilder("<h1>请登录</h1>");
            return;
        }
        //	程序到这里说明用户名和密码已经填写
        String sql = " select * from classes where username = ? and password = ?;";
        List<Admin> admins = JDBCDao.queryAll(sql, username,password);

        // 把用户信息保存到 SessionServer 中
        String sessionId = SessionServer.put(admins.get(0));

        // 把 sessionId 种到 Cookie 中
        resp.setHeader("Set-Cookie", "session-id=" + sessionId);

        resp.setBodyBuilder("<h1>登录成功，欢迎 " + username + "</h1>");

    }
}