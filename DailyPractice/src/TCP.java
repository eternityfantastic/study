import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8848);

        System.out.println("等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("连接上了");
        InputStream inputStream = socket.getInputStream();//获取输入字节流
        OutputStream outputStream = socket.getOutputStream();//输出字节流
        //拿到的是字节流
        byte[] bytes = inputStream.readAllBytes();
        String 收到的消息 = new String(bytes);
        System.out.println("收到的消息是：————" +收到的消息 );

        //返回响应
        outputStream.write(收到的消息.getBytes());
        outputStream.flush();


    }
}
