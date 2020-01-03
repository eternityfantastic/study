import servlet.http_servlet.*;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Task extends Thread {
    //    服务器的一个进程负责处理浏览器的请求并返回浏览器的响应
    Socket socket = null;

    private Map<String, Servlet> urlMap = new HashMap<>();
    private Servlet notFoundServlet = new NotFoundServlet();

    public Task(Socket socket) {
        this.socket = socket;
//        urlMap.put("/joke.js", new JokeJSServlet());
        urlMap.put("/index.html", new LoginServlet());
//        urlMap.put("/profile", new ProfileServlet());
    }

    @Override
    public void run() {
        Request request = null;
        try {
//            一.解析请求（从流中取出请求数据：解析浏览器发送来的报文request）
            request = Request.parseRequset(socket.getInputStream());
//            二.处理请求
            Response response = new Response();
            Servlet servlet = urlMap.get(request.getUrl());
            if(servlet==null){
                if(StaitcServlet.exits(request.getUrl())){
                    servlet = new StaitcServlet();
                }else{
                    servlet = notFoundServlet;
                }
            }
            servlet.doGet(request, response);
//            Servlet servlet ;
////            2.1 :servlet会根据url去找相对应的servlet文件
//            if (!StaitcServlet.exits(request.getUrl())) {
//                response.setStatusAndDescribe("404 Not Found");
//                response.setBodyBuilder("<h1>没有找到这个页面</h1>");
//            } else {
//                servlet = new StaitcServlet();
////                if ("get".equals(request.getMethod())) {
////                    servlet.doGet(request, response);
////                } else {
////                    servlet.doPost(request, response);
////                }
//                servlet.doGet(request, response);
//            }
//            三.（servlet给response进行了实例化），返回相应response给浏览器
            response.writeAndFlush(socket.getOutputStream());
            socket.close();
            /**
             * 5、浏览器会自动接受响应并6.渲染页面（不需要实现）
             */
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}