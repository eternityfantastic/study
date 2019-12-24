import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        try {
            //Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            outputStream.write("我想要发的消息".getBytes());
            outputStream.write("\n".getBytes());
            outputStream.flush();
            System.out.println(new String(inputStream.readAllBytes()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
