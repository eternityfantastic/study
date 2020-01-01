import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 简易版线程池，只考虑正式员工，不考虑临时工，也不考虑拒绝策略
 */
public class MyThreadPool {
    private static class Worker extends Thread {
        //        员工有一个工作任务的阻塞队列，直到队列为空，或线程被打断，线程才算结束；
        private BlockingQueue<Runnable> queue;

        Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    Runnable command = queue.take();
                    command.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    private int currentPoolSize;//当前员工数目
    private int corePoolSize;//可以容纳的员工的总是；
    private BlockingQueue<Runnable> queue;//任务队列；
    private List<Worker> workerList;//工人花名册；

    public MyThreadPool(int corePoolSize, BlockingQueue<Runnable> queue) {
        this.currentPoolSize = 0;
        this.corePoolSize = corePoolSize;
        this.queue = queue;
        this.workerList = new ArrayList<>();
    }

    public void execute(Runnable command) {
        // 起初来一个任务，就会雇一个人去解决，当雇佣不了人的时候，先把活揽下，
        // 等工人手头活干完了就去工作队列中去取
//
        if (queue.isEmpty() && currentPoolSize > 0) {
//            有闲人，放活就行
            queue.add(command);
        }else {
            if (currentPoolSize < corePoolSize) {
                // 雇人
                Worker worker = new Worker(queue);
                // 工人加入花名册
                workerList.add(worker);
                // 给新员工派活，旧员工不用派活；
                worker.start();
                currentPoolSize++;
            }
            queue.add(command);
        }
    }

    /**
     * 公司破产
     */
    public void shutDown() throws InterruptedException {
        // 挨个通知大家下岗了
        for (Worker worker : workerList) {
            worker.interrupt();
        }

        // 等待大家真的下岗（先通知，效率比较高）
        for (Worker worker : workerList) {
            worker.join();
        }
    }
}
