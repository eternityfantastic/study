package servlet.http_servlet;

public class NotFoundServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) throws Exception {
        resp.setStatusAndDescribe("404 Not Found");
        resp.setBodyBuilder("<h1>没有找到这个页面</h1>");
    }
}
