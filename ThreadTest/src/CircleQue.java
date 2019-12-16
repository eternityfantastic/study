public class CircleQue {
    static int[] arr = new int[10];
    //    队头位置
    static int head = 0;
    //    tail 表示要插入的位置（空元素）
    static int tail = 1;
    static int len = 10;

    public void offer(int k) {
        if (tail == head) {
            return;
        }
        arr[tail] = k;
        tail = (tail + 1) % len;
    }

    public int pull() {
        if (isEmpty()) {
            return -1;
        }
        int ret = arr[head];
        head = (head + 1) % len;
        return ret;
    }

    public boolean isEmpty() {
        if ((head + 1) % len == tail) {
            return true;
        }
        return false;
    }

    public int getSize() {
        if(tail == head){
            return 10;
        }
        int count = 0;
        int index = (head + 1) % len;

        while (tail != index) {
            count++;
            index = (index + 1) % len;
        }
        return count;
    }
}
class Test{
    public static void main(String[] args) {
        CircleQue que = new CircleQue();
        que.offer(1);
        que.offer(1);
        que.offer(3);
        que.offer(1);
        que.offer(1);
        que.offer(6);
        System.out.println(que.getSize());
        que.offer(1);
        que.offer(1);
        que.offer(1);
        System.out.println(que.getSize());
        que.offer(1);
        que.offer(1);
        System.out.println(que.getSize());

        que.offer(1);
        System.out.println(que.getSize());
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        System.out.println(que.getSize());
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        que.pull();
        que.offer(2);
        System.out.println(que.getSize());
    }

}
