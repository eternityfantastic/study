public class PrintInOrder {
    static Object objects0 = new Object();
    static Object objects1 = new Object();
    static Object objects2 = new Object();
    static int i = 0;
    public void first() throws InterruptedException {

        synchronized (objects0) {
            System.out.println("one");
            objects1.notify();
            objects0.wait();
        }
    }

    public void second() throws InterruptedException {

        synchronized (objects1) {
            System.out.println("two");
            objects2.notify();
            objects1.wait();
        }
    }

    public void third() throws InterruptedException {

        synchronized (objects2) {
            System.out.println("three");
            objects0.notify();
            objects2.wait();
        }
    }

    private static class PrintOne extends Thread {
        PrintInOrder object;
        PrintOne(PrintInOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    object.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PrintTwo extends Thread {
        PrintInOrder object;
        PrintTwo(PrintInOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    object.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PrintThree extends Thread {
        PrintInOrder object;
        PrintThree(PrintInOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    object.third();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        PrintInOrder object = new PrintInOrder();
//        Thread t1 = new PrintOne(object);
//        t1.start();
//        Thread t2 = new PrintTwo(object);
//        t2.start();
//        Thread t3 = new PrintThree(object);
//        t3.start();
        for (int j = 501; j <= 1000 ; j++) {
            System.out.println(j/5);
        }

    }
}
