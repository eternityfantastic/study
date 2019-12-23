import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        while(true){
            byte[] buffer = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(receivePacket);
            int len = receivePacket.getLength();
            String message = new String(buffer,0,len,"UTF-8");

            String echomessage = message;
            byte[] sent = message.getBytes("UTF-8");
            DatagramPacket sentPacket = new DatagramPacket(sent, 0, sent.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sentPacket);
        }
    }
}
