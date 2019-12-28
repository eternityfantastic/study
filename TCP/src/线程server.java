import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;
import java.lang.Thread;

public class 线程server {
    private static class Worker implements Runnable {
        private final Socket socket;

        Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Scanner scanner = new Scanner(is, "UTF-8");
                PrintStream out = new PrintStream(os, false, "UTF-8");

                while (scanner.hasNextLine()) {
                    System.out.println(name + ":等待客户端发送消息");
                    String message = scanner.nextLine();
                    System.out.println(name + ":收到消息:" + message);
                    String echoMessage = message;
                    out.println(echoMessage);
                }
            } catch (UnsupportedEncodingException e) {
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        int i = 0;
        while (true) {
            System.out.println("main:等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("main:连接建立");
            /*
            static ExecutorService
newFixedThreadPool​(int nThreads)
Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
             */
            ExecutorService pool = Executors.newFixedThreadPool(100);
            pool.execute(new Worker(socket));
            //或者

            /*
            ThreadPoolExecutor​(
            int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
             BlockingQueue<Runnable> workQueue)
             */

            ThreadPoolExecutor pool2 = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
            pool2.execute(new Worker(socket));
            //Thread thread = new Thread(new Worker(socket), "工作人员(" + i++ + ")");
//            thread.start();
        }
    }
}
