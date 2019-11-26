public class HeapTest {
    int[] arr;
    int usedSize;

    public HeapTest(int[] arr) {
        this.arr = arr;
        this.usedSize = arr.length;
    }

    public void adjust() {
        int p = 0, c = 2 * p + 1;
        int len = arr.length;
        while (c < len) {
            int max = c;
            if (c + 1 < len) {
                max = arr[c] < arr[c + 1] ? c + 1 : c;
            }
            if (arr[p] > arr[max]) {
                int temp = arr[p];
                arr[p] = arr[max];
                arr[max] = temp;
                p = c;
                c = 2 * p + 1;
            } else {
                break;
            }
        }
    }

    public void adjustUp(int c) {
        int p = (c - 1) / 2;
        int len = this.usedSize;
        while (c > 0) {
            int max = c;
            if (c + 1 < len) {
                max = arr[c] < arr[c + 1] ? c + 1 : c;
            }
            if (arr[p] > arr[max]) {
                int temp = arr[p];
                arr[p] = arr[max];
                arr[max] = temp;
                c = p;
                p = (c - 1) / 2;
            } else {
                break;
            }
        }
    }


    public void pushHeap(int val) {
        this.arr[this.usedSize] = val;
        this.usedSize++;//11

        adjustUp(usedSize - 1);

    }

    public void pop() {
        swap(0, usedSize--);

        int p = 0;
        while (p < usedSize) {
            int c = 2 * p + 1;
            int max = c;
            if (c + 1 < usedSize) {
                max = arr[c] < arr[c + 1] ? c + 1 : c;
            }
            if (arr[max] > arr[p]) {
                swap(p, max);
                p = c;
            } else {
                break;
            }
        }
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void adjustDown() {
        int p = 0, c = 0, max = c;
        while (c < usedSize) {
            c = 2 * p + 1;
            if (c + 1 < usedSize) {
                max = arr[c] < arr[c + 1] ? c + 1 : c;
            }
            if (arr[max] > arr[p]) {
                swap(max, p);
            }else{
                break;
            }
            p = max;
        }
    }

    public void heapSort() {
        for (int i = this.usedSize - 1; i > 0; i--) {
            swap(i, 0);
            adjustDown();
        }
    }
}
class TestHeep{
    public static void main(String[] args) {
        int arr[] = {1,3,4,5,67,77,86,78,23};
        HeapTest h = new HeapTest(arr);
        //adjust;
        h.heapSort();
    }

}