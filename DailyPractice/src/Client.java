import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.next();
            byte[] sendbuff = message.getBytes();
            InetAddress address = InetAddress.getLocalHost();
            int port = 8888;
            String ipAddress = "192.169.137.1";
            InetAddress AdderssName = InetAddress.getByName(ipAddress);
            DatagramPacket sentPacket = new DatagramPacket(sendbuff, 0, sendbuff.length, address, port);
            socket.send(sentPacket);
            byte[] receiveBuff = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuff, 0, receiveBuff.length);
            socket.receive(receivePacket);
            System.out.println(new String(receiveBuff));

        }
    }
}