import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP  {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("连接上了");
        InputStream inputStream =socket.getInputStream();//获取输入字节流
        OutputStream outputStream = socket.getOutputStream();//输出字节流
        //拿到的是字节流

        byte[] 收到的消息 = inputStream.readAllBytes();
//        byte[] 收到的消息 = new byte[1024];
//        while(inputStream.read(收到的消息)!=-1){
//        }
//        inputStream.read(收到的消息);
//        对消息进行处理及相应；
//        for(int i = 0 ; i < 1024&&收到的消息[i] != ; i++)
        String s = new String(收到的消息);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() && s.charAt(i)!= '\n';){
            sb.append(s.charAt(i)+"");
        }
        System.out.println("收到的消息是"+sb);
        //返回响应
        outputStream.write(s.getBytes());
        outputStream.flush();
//
//        PrintWriter printWriter = new PrintWriter(
//                new OutputStreamWriter(outputStream, "UTF-8"), false);
//        Scanner scanner = new Scanner(inputStream,"UTF-8");
//        while(scanner.hasNext()){
//            String message = scanner.nextLine();
//            System.out.println("收得到数据是"+message);
//            String response = message;
//            System.out.println("发送的响应是"+response);
//            printWriter.println(response);
//
//        }
    }
}
