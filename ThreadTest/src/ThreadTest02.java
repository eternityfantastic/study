public class ThreadTest02 {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10000_0000; i++) {

                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println(t.getName()+":"+t.getState());
        t.start();
        System.out.println(t.getName()+":"+t.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object){
            for (int i = 0; i < 10; i++) {
                System.out.println(t.getName()+":"+t.getState());
            }
            object.notify();
        }
        while (t.isAlive()){
            System.out.println(t.getName()+":"+t.getState());
        }
        System.out.println(t.getName()+":"+t.getState());
    }
}
