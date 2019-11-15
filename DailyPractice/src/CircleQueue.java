import javax.swing.*;

public class CircleQueue {
    int[] que ;
    int front;
    int rear;

    public CircleQueue(int size) {
        this.que = new int[size];
        this.front = 0;
        this.rear = 0;
    }
    public void enterQueue(){
        if(!IsFull()){

        }
    }
    public boolean IsFull(){
        if((rear+1)%que.length == front ){
            return true;
        }
        return false;
    }
}
