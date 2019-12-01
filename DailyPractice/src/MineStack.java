/**
 * @author aa
 */
public class MineStack<T> {
    int top ;
    int size;
    T [] myStack = (T[]) new Object[100];
    public T push( T num){
        myStack[top++] = num;
//        return top[];
        return myStack[top-1];
    }
    //出栈
    public  T pop(){
        //判断栈空否？
        return myStack[--top];
    }
    //得到栈顶元素，不出栈
    public T peek(){

        return myStack[top-1];
    }

    public boolean empty() {
        return this.size==0;
    }
}
