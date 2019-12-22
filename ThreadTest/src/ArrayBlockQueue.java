public class ArrayBlockQueue {
    private int [] arr;
    private volatile int size;
    private int rear;
    private int front;
    public synchronized void put(int num) throws InterruptedException {
        while(size == arr.length){
            wait();
        }
        arr[rear++] = num;
        size++;
        if(rear == arr.length){rear=0;}
    }
    public synchronized int get() throws InterruptedException {
        while(size == 0){
            wait();
        }
        int ret = arr[front++];
        size--;
        if(front==arr.length){front=0;}
        return ret;
    }
    public int getSize(){
        return size;
    }
}
