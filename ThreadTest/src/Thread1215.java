public class Thread1215 extends Thread {
    static int index = 0;
    static int len = 10_0000;
    static int[] array = new int[len];


    static {
        for (int i = 0; i < len; i++) {
            array[i] = i;
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Thread1215.class) {
                if (index >= len) {
                    break;
                }
                array[index] *= 3;
                index++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1215[] thread1215s = new Thread1215[3];
        for (int i = 0; i < 3; i++) {
            Thread1215 thread1215 = new Thread1215();
            thread1215.start();
            thread1215s[i] = thread1215;
            //thread1215s[0].join();不合理每个线程执行那个结束的条件都是index < len 所以当使用join让线程0停止就是整个任务停止了
        }
        try {
            thread1215s[0].join();
            thread1215s[1].join();
            thread1215s[2].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int x : array) {
            System.out.println(x);
        }


    }
}
