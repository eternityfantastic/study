import java.util.Arrays;

public class ArrayCopy {
    public static int[] arrayCopy1(int[] src, int[] target) {
        target = Arrays.copyOf(src, src.length);
        return target;
    }

    public static int[] arrayCopy2(int[] src, int[] target) {
        target = Arrays.copyOfRange(src, 0, src.length);
        return target;
    }

    public static int[] arrayCopy3(int[] src, int[] target) {
        System.arraycopy(src, 0, target, 0, src.length);
        return target;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] ret = new int[7];
        arrayCopy1(arr,ret);
        System.out.println(Arrays.toString(ret));
        arrayCopy2(arr,ret);
        System.out.println(Arrays.toString(ret));
        arrayCopy3(arr,ret);
        System.out.println(Arrays.toString(ret));

    }

}

class TestArrayCopy {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[][] arr2 = new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int[] clone = arr.clone();
        int[][] clone2 = arr2.clone();
        clone2[1][2] = 0;
        System.out.println(clone2[1][2]);
        System.out.println(arr2[1][2]);

//        System.out.println(Arrays.toString(clone2));
//        System.out.println(Arrays.toString(arr2));
    }

}
