import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] arr) {
        int len ;
        len = arr.length;
        for (int i = 1; i < len; i++) {
            int insert = arr[i];
            int j = i - 1;
            while (insert < arr[j] && j >= 0) {
                arr[j + 1] = arr[j--];
                //j--;
            }
            arr[j + 1] = insert;
        }
        //可以采用二分查找优化insert位置；
        System.out.println(Arrays.toString(arr));
    }

    private int findIndex(int[] arr, int begin, int end, int k) {
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (arr[mid] > k) {
                //if()
                end = mid - 1;
                findIndex(arr, begin, end, k);
            } else if (mid < k) {
                begin = mid + 1;
                findIndex(arr, begin, end, k);
            } else {
                return mid;
            }
        }
        return end;
    }
}


class TestInsertSort {
    public static void main(String[] args) {
        InsertSort I = new InsertSort();
        I.insertSort(new int[]{1, 3, 2, 3, 6, 56, 6778, 3});
        int a,b,c;



    }
}