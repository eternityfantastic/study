import java.util.Arrays;

public class Day1 implements Sort {
    @Override
    public void insertSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int insert = array[i];
            int j = i - 1;
            for (; j >= 0 && insert < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = insert;
        }
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    @Override
    public void shellSort(int[] array) {
        int[] gap = {5, 3, 1};
        for (int i = 0; i < gap.length; i++) {

            for (int j = gap[i]; j < array.length; j += gap[i]) {
                int insert = array[j];
                int k = j - gap[i];
                for (; k >= 0 && insert < array[k]; k -= gap[i]) {
                    array[k + gap[i]] = array[k];
                }
                array[k + gap[i]] = insert;
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
            if (elem[c] > elem[p]) {
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
            if(flg){
                break;
            }
        }

    }

    @Override
    public int partion(int[] array, int low, int high) {
        return 0;
    }

    @Override
    public void threeNumMid(int[] array, int low, int high) {

    }

    @Override
    public void insertSort(int[] array, int low, int high) {

    }

    @Override
    public void quick(int[] array, int low, int high) {

    }

    @Override
    public void quickSort1(int[] array) {

    }

    @Override
    public void quickSort(int[] array) {

    }

    @Override
    public void merge(int[] array, int low, int mid, int high) {

    }

    @Override
    public void mergeSort1(int[] array, int low, int high) {

    }

    @Override
    public void merge1(int[] array, int gap) {

    }

    @Override
    public void mergeSort(int[] array) {

    }
}