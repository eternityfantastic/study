public class ThreadTest04 extends Thread {
    public static volatile boolean falg = true;

    public static class worker extends Thread {
        @Override
        public void run() {
            while (falg) {
                System.out.println("挖煤");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        public static void main1(String[] args) {
            //主线程
            Thread main = Thread.currentThread();
            System.out.println(main.getName());
            //子线程
            ThreadTest04 thread = new ThreadTest04();
            System.out.println(thread.getName());
            System.out.println(thread.getId());
            System.out.println(thread.isAlive());
        }
        public static void quit(){
            falg = false;
        }
    }

        public static void main(String[] args) {
            worker w = new worker();
            w.start();
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("gohome");
            worker.quit();
            try {
                w.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("OK");
        }
    }
