import java.util.Arrays;

public class MeageSort {

    //合并函数
    public void meager(int[] arr, int low, int mid, int high) {

        int s1 = low;
        int s2 = mid + 1;

        int len = high - low + 1;
        int[] temp = new int[len];
        int index = 0;

        while (s1 <= mid && s2 <= high) {
            if (arr[s1] <= arr[s2]) {
                temp[index++] = arr[s1++];
            } else {
                temp[index++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            temp[index++] = arr[s1++];
        }
        while (s2 <= high) {
            temp[index++] = arr[s2++];
        }
        System.arraycopy(temp, 0, arr, low, temp.length);

    }

    public void meragSort(int[] arr, int low, int hight) {
        if (low >= hight) {
            return;
        }
        int mid = (hight + low) / 2;
        meragSort(arr, low, mid);
        meragSort(arr, mid + 1, hight);
        meager(arr, low, mid, hight);
    }

    public void meragSort(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        int index = 0;

        for (int gap = 1; gap < len; gap <<= 1) {
            int s1 = 0;
            int e1 = s1 + gap - 1;
            int s2 = e1 + 1;
            int e2 = s1 + gap - 1 > len ? len - 1 : s1 + gap - 1;

            while (s1 < len && s2 < len) {
                while (s1 <= e1 && s2 <= e2) {
                    if (arr[s1] <= arr[s2]) {
                        temp[index++] = arr[s1++];
                    } else {
                        temp[index++] = arr[s2++];
                    }
                }
                while (s1 <= e1) {
                    temp[index++] = arr[s1++];
                }
                while (s2 <= e2) {
                    temp[index++] = arr[s2++];
                }
                s1 = e2 + 1;
                e1 = s1 + gap - 1;
                s2 = e1 + 1;
                e2 = s2 + gap - 1 == len ? len - 1 : len;
            }
        }
        System.arraycopy(temp, 0, arr, 0, len);
    }
}

class TestMeage {
    public static void main(String[] args) {
        MeageSort s = new MeageSort();
        int[] arr = new int[]{4, 2, 3, 12, 34, 23, 42, 43, 55, 63, 31, 26, 7, 6, 43};
        s.meragSort(arr, 0, arr.length - 1);
        s.meragSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
