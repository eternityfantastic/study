import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

public class ArrayQueue1 {
    private int[] array = new int[10];
    private volatile int  size = 0;   // 有效元素个数
    private int front = 0;
    private int rear = 0;
//不能确保下一次唤醒的是生产者还是消费者，连续唤醒两个消费者的话，
// 第一个生产者再获得队列为空的消息后，就会试图唤醒生产者，但是不能确保唤醒的一定是生产者，
// 如果环形的还是一个消费者，他就不会再判断队列是否为空了，直接接着上一次wait（）后面的执行；
//    将if改为while
    public void put(int val) throws InterruptedException {
        if (size == array.length) {
            synchronized (this) {
                wait();
            }
        }

        array[rear] = val;
        rear = (rear + 1) % array.length;
        synchronized (this) {
            size++;
            notify();
        }
    }

    public int take() {
        if (size == 0) {
            throw new RuntimeException("空了");
        }

        int val = array[front];
        front = (front + 1) % array.length;
        synchronized (this) {
            size--;
            notify();
        }
        return val;
    }

    public int getSize() {
        //需要添加确保可见性；
        return size;
    }

    private static ArrayQueue queue = new ArrayQueue();

    private static class Producer extends Thread {
        Producer() {
            super("生产者");
        }

        PrintWriter printWriter;
        {
            try {
                printWriter = new PrintWriter("生产了.txt", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Random random = new Random(20191216);
            for (int i = 0; i < 1000; i++) {
                int val = random.nextInt(100);
                printWriter.println(val);
                do {
                    try {
                        queue.put(val);
                        break;
                    } catch (RuntimeException e) {
                    }
                } while (true);
            }
            printWriter.close();
        }
    }

    private static class Customer extends Thread {
        PrintWriter printWriter;
        Customer() {
            super("消费者");
        }

        {
            try {
                printWriter = new PrintWriter("消费了.txt", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                do {
                    try {
                        int val = queue.take();
                        printWriter.println(val);
                        break;
                    } catch (RuntimeException e) {
                    }
                } while (true);
            }
            printWriter.close();
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Customer customer = new Customer();
        customer.start();
    }
}
