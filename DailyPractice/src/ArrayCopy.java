import java.util.Arrays;

public class ArrayCopy {
    public int[][] arrayCopy1(int[][] arr){
        int[][] target = new int[10][];
        System.arraycopy(arr,0,target,4,arr.length);
        return target;
    }

}
class TestArrayCopy{
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        int[][] arr2 = new int[][] {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[] clone = arr.clone();
        int[][] clone2 = arr2.clone();
        clone2[1][2] = 0;
        System.out.println(clone2[1][2]);
        System.out.println(arr2[1][2]);

//        System.out.println(Arrays.toString(clone2));
//        System.out.println(Arrays.toString(arr2));
    }

}
