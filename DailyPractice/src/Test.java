import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
    LinkedList Li = new LinkedList();
        Li.addLast(1);
        Li.addLast(2);
        Li.addLast(4);
        Li.addLast(5);
        Li.addIndex(3,4);
        Li.show();
//        Li.remove(1);
//        Li.show();
//        Li.remove(5);
//        Li.show();
//        Li.remove(3);
//        Li.show()
        LinkedList L2 = new LinkedList();
        L2.head = Li.partition(4);
        L2.show();


    }

}
