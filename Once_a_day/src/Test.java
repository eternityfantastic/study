import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Day1 d = new Day1();
        int[] arr = new int[]{1,7,3,68,3,46,5,9,23};
        d.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
