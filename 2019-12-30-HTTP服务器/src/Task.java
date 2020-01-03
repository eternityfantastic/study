import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Task implements Runnable {
    private Socket socket;

    /**
     * key: url
     * value: 交给哪个 HttpServlet 对象去处理
     * map<String, HttpServlet>
     */
    private Map<String, HttpServlet> urlMap = new HashMap<>();
    private HttpServlet notFoundServlet = new NotFoundServlet();

    public Task(Socket socket) {
        this.socket = socket;
        urlMap.put("/joke.js", new JokeJSServlet());
        urlMap.put("/login", new LoginServlet());
        urlMap.put("/profile", new ProfileServlet());
    }

    @Override
    public void run() {
        try {
            Request request = Request.parse(socket.getInputStream());
            System.out.println(request);
            Response response = new Response();
//          根据url查找处理请求的方法；
            HttpServlet servlet = urlMap.get(request.url);
            if(servlet==null){
                if(StaticServlet.exits(request.url)){
                    servlet = new StaticServlet();
                }else{
                    servlet = notFoundServlet;
                }
            }
            servlet.doGet(request, response);

            response.writeAndFlush(socket.getOutputStream());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
