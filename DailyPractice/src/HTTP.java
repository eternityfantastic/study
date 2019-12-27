import java.io.IOException;
import java.net.Socket;

public class HTTP {
    public static void main(String[] args) throws IOException {


        String 请求行 = "GET /hello.txt HTTP/1.1\r\n" ;
        String 请求报头 = "Host: www.baidu.com\r\n" + "\r\n";
        String request = 请求行+请求报头;
        Socket socket = new Socket("www.baidu.com",80);
        socket.getOutputStream().write(request.getBytes());
        socket.getOutputStream().flush();
        socket.shutdownOutput();
        byte[] res = new byte[4096];
        //TCP的特点决定了不一定能读4096;
        int read = socket.getInputStream().read(res);
        socket.close();
        String response = new String(res);
        System.out.println(response);

    }


}
