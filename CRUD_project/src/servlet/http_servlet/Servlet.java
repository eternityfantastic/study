package servlet.http_servlet;

public abstract class Servlet {
    public abstract void doGet(Request req, Response resp) throws Exception;
}
