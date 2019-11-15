import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {

    public Queue<Integer> queue1;
    public Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */

    public QueueToStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int ret = -1 ;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size -1; i++) {
                queue2.offer(queue1.poll());
            }
            ret = queue1.poll();
        } else if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size -1; i++) {
                queue1.offer(queue2.poll());
            }
            ret = queue2.poll();
        }
        return ret;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ret = -1 ;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size -1; i++) {
                queue2.offer(queue1.poll());
            }
            ret = queue1.poll();
            queue2.offer(ret);
        } else if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size -1; i++) {
                queue1.offer(queue2.poll());
            }
            ret = queue2.poll();
            queue1.offer(ret);
        }
        return ret;

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            return true;
        }
        return false;
    }


}
