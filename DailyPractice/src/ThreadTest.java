public class ThreadTest extends Thread {
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            int a = 0;
            for (int i = 0; i < COUNT; i++) {
                a += i;
                //System.out.println("子线程");
            }
        }
    });
    public static final long COUNT = 10000000_0000L;
    public static void concurrency(){

    }
    public static void method(){
        int b = 0;
        for (int i = 0; i < COUNT; i++) {
            b += i;
        }
        int a = 0;
        for (int i = 0; i < COUNT; i++) {
            a += i;
        }
    }
    public static void main(String... args) {
        long start = System.currentTimeMillis();
        ThreadTest t = new ThreadTest();
        t.start();
        int b = 0;
        for (int i = 0; i < COUNT; i++) {
            b += i;
        }
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long s = System.currentTimeMillis();
        method();
        long e = System.currentTimeMillis();
        System.out.println(e - s+"串行");


    }
}
