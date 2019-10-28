public class Array {
    int array[];

    public int max() {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public int min() {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min < array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public double average() {
        double ave = 0;
        for (int i = 0; i < array.length; i++) {
            ave += (double) array[i] / array.length;
        }
        return ave;
    }

    public void reverse() {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public int binserch(int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] > key) {
                right = mid - 1;
            }
            if (array[mid] < key) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //降序
    public void bubbsort() {
        for (int i = 0; i < array.length; i++) {
            boolean flg = true;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] > array[j - i]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flg = false;
                }
            }
            if(flg){break;}
        }
    }

    public void jiou() {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public int binSearch(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        } else {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                right = mid - 1;
                int index = binSearch(arr, left, right, key);
                return index;
            } else {
                left = mid + 1;
                int index = binSearch(arr, left, right, key);
                return index;
            }
        }
    }
}
