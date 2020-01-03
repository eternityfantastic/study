import servlet.http_servlet.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    /**
     * 这是http服务器输入URL回车后：
     * 1、URL 解析
     * 2、DNS 查询
     * 3、TCP 连接
     *
     *
     */
    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            /**
             * 4、处理请求
             * 接受请求并把它交给一个线程去完成
             */
            Socket socket = serverSocket.accept();
            pool.execute(new Task(socket));
        }
    }
}