public interface Sort {

    void insertSort(int[] array);
    void selectSort(int[] array);

    void shellSort(int[] array);

    void adjustDown(int[] elem, int root, int len);


    void heapSort(int[] array);

    void bubbleSort(int[] array);


    int partion(int[] array, int low, int high);


    void quickSort(int[] array, int low, int high);

    void quickSort(int[] array);


    void merge(int[] array, int low, int mid, int high);

    void mergeSort1(int[] array, int low, int high);


    void mergeSort(int[] array);

}
