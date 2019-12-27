public class ThreadTest03 {
    public static int n = 0;
    private static class myThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                synchronized (ThreadTest03.class) {
                    if(n < 10000){
                        n++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread t = new myThread();
            t.start();
            threads[i] = t;

            System.out.println(n);
            threads[0].join();
            System.out.println(n);


        }
//        for (int i = 0; i < 5; i++) {
//            try {
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        if(threads[0].getState() == Thread.State.TERMINATED){
//            System.out.println(n);
//        }

    }
}
