import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static int[] makeCord(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i++] = in.nextInt();
        }
        return arr;
    }

    public static void shuffle(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //System.out.println(Arrays.toString(arr));
        while (k-- > 0) {
            int[] left = new int[n / 2];
            int[] right = new int[n / 2];
            int index_l = 0;
            int index_r = 0;
            System.arraycopy(arr, 0, left, 0, n / 2);
            System.arraycopy(arr, n / 2, right, 0, n / 2);
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = right[index_r++];
                } else {
                    arr[i] = left[index_l++];
                }
//                System.out.println(Arrays.toString(left));
//                System.out.println(Arrays.toString(right));
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }


    }

    public static void main2(String[] args) {

        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int T = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            shuffle(2*n,k);
        }
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        int[] left = new int[3];
//        int[] right = new int[3];

//        System.arraycopy(arr, 0, left, 0, 3);
//        System.arraycopy(arr, 3, right, 0, 3);
//        System.out.println(Arrays.toString(left));
////        for
    }
        public static void main(String[] args) {
            System.out.print(10*30+" ");
            System.out.println(0X3fffffff);
        }
}

