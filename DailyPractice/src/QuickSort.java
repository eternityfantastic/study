import java.util.Stack;

public class QuickSort {
    public int partion(int[] arr, int low, int high) {
        return low;
    }

    public void quiclkSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int low = 0, high = arr.length - 1;
        int par = partion(arr, low, high);
        if (par > low) {
            stack.push(low);
            stack.push(par - 1);
        }
        if (par < high - 1) {
            stack.push(par+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            par = partion(arr, low, high);
            if (par > low) {
                stack.push(low);
                stack.push(par - 1);
            }
            if (par < high - 1) {
                stack.push(par+1);
                stack.push(high);
            }
        }
    }
}
