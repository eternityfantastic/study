import java.util.Arrays;
import java.util.Stack;

public class SortTest {


    /**
     * 最坏情况下： 时间复杂度为O(n^2)   无序的时候
     * 最好情况下： 时间复杂度为O(n)    有序的时候
     * 越有序越快
     * 稳定性：稳定
     *
     * @param array
     */
    public static void insertSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //如果加== 他就是一个不稳定的排序
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    //gap->组数  进行组内直接插入排序
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i += 1) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                //如果加== 他就是一个不稳定的排序
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public static void adjustDown(int[] elem, int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            //判断是否有右孩子 且谁最大
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child = child + 1;
            }
            //child肯定是左右孩子的最大值下标
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public static void heapSort(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
        //每次调整的结束位置  9
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 1  2  3  4  5  6
     * 空间复杂度：O(1)
     * 稳定的排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        //i->趟数
        for (int i = 0; i < array.length - 1; i++) {
            flg = false;
            //j->下标
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
    }

    public static int partion(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if (low >= high) {
                break;
            } else {
                array[low] = array[high];
            }

            while (low < high && array[low] <= tmp) {
                low++;
            }
            if (low >= high) {
                break;
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void threeNumMid(int[] array, int low, int high) {
        //array[low]     array[high]    array[mid]    2   7   5
        //array[mid] <= array[low] <= array[high]
        int mid = (low + high) / 2;
        if (array[mid] > array[low]) {
            swap(array, low, mid);//  7   2     5
        }
        if (array[mid] > array[high]) {
            swap(array, high, mid);//  5   2    7
        }
        if (array[low] > array[high]) {
            swap(array, low, high);// 5   2    7
        }
    }

    public static void insertSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= low; j--) {
                //如果加== 他就是一个不稳定的排序
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * n*log2n         空间复杂度：log2n
     * 1 2 3 4 5 6 7   最坏情况：有序的时候-》O(n^2)
     * O(n)
     *
     * @param array
     * @param low
     * @param high
     */
    public static void quick(int[] array, int low, int high) {
       /*if(high-low+1 <= 100) {
            insertSort(array,low,high);
            return;
        }
        threeNumMid(array,low,high);*/
        int par = partion(array, low, high);
        if (par > low + 1) {
            quick(array, low, par - 1);
        }
        if (par < high - 1) {
            quick(array, par + 1, high);
        }
    }

    public static void quickSort1(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        int par = partion(array, low, high);
        if (par > low + 1) {
            stack.push(low);
            stack.push(par - 1);
        }
        if (par < high - 1) {
            stack.push(par + 1);
            stack.push(high);
        }
        while (!stack.empty()) {
            //1、取出数对
            high = stack.pop();
            low = stack.pop();
            //2.par
            par = partion(array, low, high);
            if (par > low + 1) {
                stack.push(low);
                stack.push(par - 1);
            }
            if (par < high - 1) {
                stack.push(par + 1);
                stack.push(high);
            }
        }

    }

    public static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] tmp = new int[len];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            } else {
                tmp[i++] = array[s2++];
            }
        }
        //判断两个归并段 中 是否还有归并段有数据
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        //两个归并段 归并结束-》tmp[]
        for (int j = 0; j < tmp.length; j++) {
            array[low + j] = tmp[j];
        }
    }

    public static void mergeSort1(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort1(array, low, mid);
        mergeSort1(array, mid + 1, high);
        //合并
        merge(array, low, mid, high);
    }

    //非递归版本
    public static void merge1(int[] array) {
        int len = array.length;
        int[] tmp = new int[len];

        for (int gap = 1; gap < array.length; gap *= 2) {
            int i = 0;
            int s1 = 0;
            int e1 = s1 + gap - 1;
            int s2 = e1 + 1;
            int e2 = s2 + gap - 1 >= len ? len - 1 : s2 + gap - 1;
            //当有两个归并段的时候
            while (s2 < len) {
                while (s1 <= e1 && s2 <= e2) {
                    if (array[s1] <= array[s2]) {
                        tmp[i++] = array[s1++];
                    } else {
                        tmp[i++] = array[s2++];
                    }
                }
                while (s1 <= e1) {
                    tmp[i++] = array[s1++];
                }
                while (s2 <= e2) {
                    tmp[i++] = array[s2++];
                }
                //重新确定s1  e1  s2  e2 的位置
                s1 = e2 + 1;
                e1 = s1 + gap - 1;
                s2 = e1 + 1;
                e2 = s2 + gap - 1 >= len ? len - 1 : s2 + gap - 1;
            }
//           // 判断s1是否有数据-》上面第一个循环进不来，只有一个归并段的情况是只有一个数据；
//            while (s1 <= len - 1) {
//                tmp[i++] = array[s1++];
//            }
           // 拷贝tmp到array
            System.arraycopy(tmp,0,array,0,len);
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 6, 5, 9,7, 8};
        merge1(array);
        System.out.println(Arrays.toString(array));
    }
}