import java.util.Arrays;

public class ShellSort {
    public void shellSort(int[] arr) {
        int[] gap = {5, 3, 1};
        int gaplen = gap.length;


        for (int i = 0; i < gaplen; i++) {
            int p = gap[i];

            int arrlen = arr.length;


            for (; p < arrlen; p++) {
                int insert = arr[p];
                int q = p - gap[i];
                for (; q >= 0 && arr[q] > insert; q -= gap[i]) {
                    arr[q + gap[i]] = arr[q];
                }
                arr[q + gap[i]] = insert;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public void  bub(int[] arr){
        int len = arr.length;
        int count = 0;
//        boolean flg = true;

        for (int i = 0; i < len ; i++) {
            boolean flg = true;
            count++;
            for (int j = 0; j < len-i -1; j++) {

                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flg = false;
                }
            }
            if(flg){
                break;
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }
//    public void shell(int[] arr) {
//        int gap[] = {5, 3, 1};
//        int gaplen = gap.length;
//        for (int i = 0; i < gaplen; i++) {
//            int len = arr.length;
//            for (int j = 0; j < len; j++) {
//                int insert = arr[j + gap[i]];
//                int k = ;
//                for (; k < ; k++) {
//
//                }
//            }
//        }
//    }
}

class TestShellSort {
    public static void main(String[] args) {
        ShellSort s = new ShellSort();
        s.shellSort(new int[]{1, 4, 6, 3, 2, 6, 22, 64, 12, 0});
        s.bub(new int[]{1, 2, 3, 4, 5, 6, 7, 12, 100});
    }
}