package task;


import dao.FileOperateDao;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {
    AtomicInteger COUNT = new AtomicInteger();
    static ExecutorService Pool = Executors.newFixedThreadPool(4);

    private static final CountDownLatch LATCH = new CountDownLatch(1);
    FileScanCallback fileScanTask;

    public FileScanner(FileScanCallback fileScanTask) {
        this.fileScanTask = fileScanTask;
    }

    public void listFile(File dir) {
        fileScanTask.executor(dir);
        if (!Thread.interrupted()) {
            try {
                if (dir.isDirectory()) {
                    File[] children = dir.listFiles();
                    if (children != null || children.length > 0) {
                        for (File child : children) {
                            if (child.isDirectory()) {
                                // 使用线程进行遍历文件夹
                                COUNT.incrementAndGet();
                                listFile(child);
                            } else {
                                fileScanTask.executor(new File(child.getPath()));
                            }
                        }
                    }
                }
            } finally {
                if (COUNT.decrementAndGet() == 0) {
                    LATCH.countDown();
                }
            }
        }
    }
    //启动根目录的扫描任务
    public void startScan(File file) {
        COUNT.incrementAndGet();
        Pool.execute(new Runnable() {
            @Override
            public void run() {
                listFile(file);
            }
        });
    }

    //等待所有扫描任务执行完毕
    public void waitFinish() {
        try {
            LATCH.await();
        } catch (InterruptedException e) {
            /**
             * 中断所有线程
             * 调用每个线程的interrupt修改标志位Pool.shutdown();
             * 调用每个线程的stop方法直接停止；Pool.shutdownNow();
             */
            Pool.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FileScanCallback callback = new FileOperateDao();
        FileScanner task = new FileScanner(callback);
        task.startScan(new File("D:\\Study\\TCP\\src"));
        synchronized (task) {
            task.wait();
        }
        System.out.println("执行完毕");

    }
}