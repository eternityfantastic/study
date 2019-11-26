import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int insert = arr[i];
            int j = i - 1;
            for (; insert < arr[j] && j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = insert;
        }
        //可以采用二分查找优化insert位置；
        System.out.println(Arrays.toString(arr));
    }

    private int findIndex(int begin, int end, int k) {
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (mid > k) {
                end = mid - 1;
                findIndex(begin,end,k);
            }else if(mid < k){
                begin = mid + 1;
                findIndex(begin,end,k);
            }else{
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
    }
}