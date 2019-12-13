public class ThreadTest03 {
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            long a = 0;
            for (int i = 0; i < 1_0000_0000; i++) {
                a += (long) Math.pow(i, 2);
            }
            System.out.println("线程1"+a);
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            long a = 0;
            for (int i = 0; i < 1_0000_0000; i++) {
                a += (long) Math.pow(i, 2);
            }
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        Thread thread2 = new Thread(new MyThread2());
        thread2.start();
        Thread thread3 = new Thread(new MyThread1());
        thread3.start();
    }
}
