import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Sercer_test01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));


    }
}
