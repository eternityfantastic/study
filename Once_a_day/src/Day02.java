import java.util.Stack;

public class Day02 implements Sort {
    @Override
    public void insertSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int insert = array[i + 1];
            int j = i;
            for (; j >= 0 && insert < array[j]; j--) {
                array[j] = array[j + 1];
            }
            array[j + 1] = insert;
        }
    }

    @Override
    public void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
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

    }

    @Override
    public void adjustDown(int[] elem, int root, int len) {
        int p = root;
        int c = 2 * p + 1;
        while (c < len) {
            if (c + 1 < len && elem[c + 1] > elem[c]) {
                c += 1;
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
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    @Override
    public void bubbleSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            boolean falg = true;
            for (int j = 0; j <= len - i - 2; j++) {
                if (array[j] > array[j + 1]) {
                    falg = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (falg) {
                break;
            }
        }
    }

    @Override
    public int partion(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[i];
        while (i < j) {
            while (j > i && array[j] >= pivot) {
                j--;
            }
            //此时j处的元素比基准小了;
            array[i] = array[j];
            while (j > i && array[i] <= pivot) {
                i++;
            }
            //此时i处的元素比基大了;
            array[j] = array[i];
        }
//        此时i==j
        array[i] = pivot;
        return i;
    }
    @Override
    public void quickSort(int[] array, int low, int high) {
        //low 和 high 均为合法下标 所以传参为 0 ，array.length -1
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
            if (left >= right) {
                continue;
            }
            int pivot = partion(array, left, right);
            stack.push(right);
            stack.push(pivot + 1);
            stack.push(pivot - 1);
            stack.push(left);
        }
    }

    @Override
    public void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid;
//        不包含high,元素个数为high-low个
//        所以最外层传入的high应该是array.length
        int[] temp = new int[high - low];
        int k = 0;
        while (i < mid && j < high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j < high) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, low, temp.length);
    }

    @Override
    public void mergeSort1(int[] array, int low, int high) {
        if (low >= high - 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort1(array, low, mid);
        mergeSort1(array, mid, high);
        merge(array, low, mid, high);
    }

    @Override
    public void mergeSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len ; i *= 2) {
            for (int j = 0; j < len; j += 2 * i) {
                int low = j;
                int mid = j + i;
                if(mid > len){
                    break;
                }
                int high = j + 2 * i > len ? len : j + 2 * i;
                merge(array,low,mid,high);
            }
        }
    }
}
