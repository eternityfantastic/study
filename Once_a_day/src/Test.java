import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Day1 d1 = new Day1();
        Day02 d2 = new Day02();
        Day03 d3 = new Day03();
        int[] arr = new int[]{1,7,4,48,37,65,31,96,84,9,41,55,66,77,68,3,46,5,23};
//        d.mergeSort(arr);
//        d.mergeSort1(arr,0,arr.length);
        d3.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }



}
