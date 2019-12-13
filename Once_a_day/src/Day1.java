import java.util.Arrays;
import java.util.Stack;

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
        int len = array.length;
        int index = ((len - 1) - 1) / 2;
        for (int i = index; i >= 0; i--) {
            adjustDown(array, i, len);
        }
        int end = len - 1;
        while (end >= 0) {
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            adjustDown(array, 0, end);
            end--;
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

    @Override
    public int partion(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int povit = array[low];
        while (j > i) {
            while (j > i && povit <= array[j]) {
                j--;
            }
            array[i] = array[j];
            while (j > i && povit >= array[i]) {
                i++;
            }
            //此时i出的值比povit大
            array[j] = array[i];
        }
        //此时j==i
        array[i] = povit;
        return i;
    }

    @Override
    public void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partion(array, low, high);
        if (pivot > low + 1) {
            quickSort(array, low, pivot - 1);
        }
        if (pivot < high - 1) {
            quickSort(array, pivot + 1, high);
        }
    }

    @Override
    public void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {   //一定是>=
                continue;
            }
            int mid = partion(array, left, right);
            stack.push(right);
            stack.push(mid + 1);
            stack.push(mid - 1);
            stack.push(left);
        }

    }

    @Override
    public void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int[] temp = new int[high - low];
        int k = 0;
        while (i < mid && j < high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (j < high) {
            temp[k++] = array[j++];
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        System.arraycopy(temp, 0, array, low, temp.length);
    }

    @Override
    public void mergeSort1(int[] array, int low, int high) {
        if (low >= high - 1) {
            return;
        }
        int mid = (high + low) / 2;
        mergeSort1(array, low, mid);
        mergeSort1(array, mid, high);
        merge(array, low, mid, high);


    }


    @Override
    public void mergeSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i *= 2) {
            for (int j = 0; j < len; j += 2 * i) {
                int low = j;
                int mid = j + i;
                if(mid > len){
                    break;
                }
                int hight = j + 2 * i;
                if(hight > len){
                    hight = len;
                }

                merge(array,low,mid,hight);
            }
        }

    }
}