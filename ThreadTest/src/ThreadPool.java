import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
    public  int corePoolSize = 10;
    private int currentPoolSize = 0;
    private List<Worker> workers = new ArrayList<>();
    private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();

    private class Worker extends Thread {

    }
    public void method(){
        if(currentPoolSize < corePoolSize){

        }
    }
}
