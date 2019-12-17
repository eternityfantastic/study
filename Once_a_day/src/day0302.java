import java.io.OutputStreamWriter;

public class day0302 implements QuickSortMethods{
    @Override
    public int partion(int[] array, int low, int high) {
        int pivot = low;
        while (low < high){

            while(array[high] >=  pivot){
                high--;
            }
            array[low] = array[high];
            while(array[low] <= pivot){
                low++;
            }
            array[high] = array[low];
        }
        array[high] = pivot;
        return high;
    }

    @Override
    public void quickSort(int[] array) {

    }

    @Override
    public void quickSort(int[] array, int low, int high) {

    }
}
