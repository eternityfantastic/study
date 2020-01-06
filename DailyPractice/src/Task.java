import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Task implements Runnable {
    private final Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 读取请求并解析
            Request request = Request.parse(is);
            System.out.println(request);
            // 处理业务
            // 拼接响应并发送
            // 关闭 socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
