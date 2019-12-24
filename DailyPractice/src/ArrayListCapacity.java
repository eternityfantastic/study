import java.util.ArrayList;

public class ArrayListCapacity {
//    default String s ;
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(10);
        System.out.println(arr.size());

        arr.add(1);

        System.out.println(arr.size());
        arr.add(1);
        System.out.println(arr.size());
        arr.add(1);
        System.out.println(arr.size());
        arr.add(1);
        System.out.println(arr.size());
        arr.add(1);
        System.out.println(arr.size());
        arr.add(1);
        System.out.println(arr.size());

    }
}
