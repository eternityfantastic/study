public class ThreadStatus extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
//            只要没有中断线程，它就一直执行

        }
    }

    public static void main(String[] args) {
        ThreadStatus t = new ThreadStatus();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        t.interrupt();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(t.getState());

    }
}
 
