public interface Sort {

    void insertSort(int[] array);
    void selectSort(int[] array);

    void shellSort(int[] array);



    void adjustDown(int[] elem, int root, int len);


    void heapSort(int[] array);

    void bubbleSort(int[] array);


    int partion(int[] array, int low, int high);


    void threeNumMid(int[] array, int low, int high);

    void insertSort(int[] array, int low, int high);

    void quick(int[] array, int low, int high);

    void quickSort1(int[] array);

    void quickSort(int[] array);


    void merge(int[] array, int low, int mid, int high);

    void mergeSort1(int[] array, int low, int high);


    //非递归版本
    void merge1(int[] array, int gap);


    void mergeSort(int[] array);

}
