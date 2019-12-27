import java.util.Scanner;

public class Wait extends Thread {
    static Object object = new Object();

    @Override
    public void run() {
        System.out.println("不想扫地");
        synchronized (object) {
            try {
                System.out.println("等待中...");
                object.wait();
                System.out.println("等待已过...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("擦桌子");
    }

    public static void main(String[] args) {
        Thread thread01 = new Wait();
        thread01.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入");
        String s = scanner.nextLine();
        synchronized (object) {
            object.notify();
        }
    }

    public static void main1(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("等待中...");
            object.wait();
            System.out.println("等待已过...");
        }
        System.out.println("main方法结束...");
    }
}
