//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    static Scanner in = new Scanner(System.in);
//
//    public static int[] makeCord(int n) {
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i++] = in.nextInt();
//        }
//        return arr;
//    }
//
//    public static void shuffle(int n, int k) {
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        //System.out.println(Arrays.toString(arr));
//        while (k-- > 0) {
//            int[] left = new int[n / 2];
//            int[] right = new int[n / 2];
//            int index_l = 0;
//            int index_r = 0;
//            System.arraycopy(arr, 0, left, 0, n / 2);
//            System.arraycopy(arr, n / 2, right, 0, n / 2);
//            for (int i = 0; i < n; i++) {
//                if (i % 2 == 0) {
//                    arr[i] = right[index_r++];
//                } else {
//                    arr[i] = left[index_l++];
//                }
////                System.out.println(Arrays.toString(left));
////                System.out.println(Arrays.toString(right));
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i]);
//        }
//
//
//    }
//
//    public static void main2(String[] args) {
//
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int T = in.nextInt();
//            int n = in.nextInt();
//            int k = in.nextInt();
//            shuffle(2*n,k);
//        }
////        int[] arr = {1, 2, 3, 4, 5, 6};
////        int[] left = new int[3];
////        int[] right = new int[3];
//
////        System.arraycopy(arr, 0, left, 0, 3);
////        System.arraycopy(arr, 3, right, 0, 3);
////        System.out.println(Arrays.toString(left));
//////        for
//    }
//        public static void main(String[] args) {
//            System.out.print(10*30+" ");
//            System.out.println(0X3fffffff);
//        }
//}
////
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Arrays;
//
//public class Main {
//    static Scanner in = new Scanner(System.in);
//
//    public static void main(String args[]) {
//        String s1 = in.nextLine();
//        String s2 = in.nextLine();
//        s1 = s1.toUpperCase();
//        s2 = s2.toUpperCase();
//        HashSet<Character> set = new HashSet<>();
//        for (char ch : s2.toCharArray()) {
//            set.add(ch);
//        }
//        for (char ch : s1.toCharArray()) {
//            if (!set.contains(ch)) {
//                System.out.print(ch);
//            }
//            set.add(ch);
//        }
//
//        System.out.println();
//    }
//}

import java.util.Scanner;

public class Main {
    char[] chs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine().toUpperCase();
            int n = 0;
            int count = 0;
            for (int i = s.length() - 1; i >= 2; i--) {
                char x = s.charAt(i) ;
                if (x >= 'A' && x <= 'F') {
                    count += (x-'A'+ 10 )* Math.pow(16, n++);
                }else{
                    count += (x-'0')* Math.pow(16, n++);
                }
            }
            System.out.println(count);
        }
    }
}

