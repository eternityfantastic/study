import java.util.ArrayList;
import java.util.List;

public class Day03 implements 插入选择冒泡排序 {
    @Override
    public void insertSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {

            int j = i;
            int insert = array[j + 1];
            while (j >= 0 && insert < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insert;
        }
    }

    @Override
    public void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

    }


    @Override
    public void shellSort(int[] array) {
        int[] gap = {5, 3, 1};
        int len = array.length;
        for (int i = 0; i < 3; i++) {
            int g = gap[i];
            for (int j = 0; j < len - g; j += g) {
                int k = j;
                int insert = array[k + g];
                while (k >= 0 && insert < array[k]) {
                    array[k + g] = array[k];
                    k -= g;
                }
                array[k + g] = insert;
            }
        }
    }

    @Override
    public void adjustDown(int[] elem, int root, int len) {
        int p = root;
        int c = 2 * p + 1;
        while (c < len) {
            if (c + 1 < len && elem[c] < elem[c + 1]) {
                c = c + 1;
            }
            if (elem[p] < elem[c]) {
                int temp = elem[c];
                elem[c] = elem[p];
                elem[p] = temp;
                p = c;
                c = 2 * p + 1;
            } else {
                break;
            }
        }
    }

    @Override
    public void heapSort(int[] array) {


        int len = array.length;
        for (int i = (len - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, len);
        }

        for (int i = 0; i < len; i++) {
            int temp = array[0];
            array[0] = array[len - 1 - i];
            array[len - 1 - i] = temp;
            adjustDown(array, 0, len - i);
        }
    }

    @Override
    public void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            boolean flg = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flg = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flg) {
                break;
            }
        }
    }
}
