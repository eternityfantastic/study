import java.util.Arrays;

public class SelectSort {

    public void selectSort(int [] arr){
        int len = arr.length;
        for(int i = 0 ; i < len ; i++){
            for (int j = i+1; j < len; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void select(int[] arr){
        int len = arr.length;
        for(int i = 0 ; i < len ; i ++){
            for (int j = i + 1; j < len; j++) {
                if(arr[j] < arr[i]){
                    swap(arr,i,j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
class TestSelectSort {
    public static void main(String[] args) {
        SelectSort s = new SelectSort();
        s.select(new int []{34,3,5,7,8,4,2,5,66,77,46});
    }
}