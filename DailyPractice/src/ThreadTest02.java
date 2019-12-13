public class ThreadTest02 {
    public static final long COUNT = 10000_0000_0L;

    public static void currency() throws InterruptedException {
        long s1 = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < COUNT; i++) {
                    a += i;
                }
            }
        });
        thread1.start();
//        int b = 0;
//        for (int i = 0; i < COUNT; i++) {
//            b += i;
//        }
//        thread1.join();
        long e1 = System.currentTimeMillis();
        System.out.println(e1-s1+Thread.currentThread().getName());
    }


    public static void serial(){
        long s2 = System.currentTimeMillis();

//        int b = 0;
//        for (int i = 0; i < COUNT; i++) {
//            b += i;
//        }
        int a = 0;
        for (int i = 0; i < COUNT; i++) {
            a += i;
        }
        long e2 = System.currentTimeMillis();
        System.out.println(e2-s2+"并行");
    }

    public static void main(String[] args) {
        serial();
        try {
            currency();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
