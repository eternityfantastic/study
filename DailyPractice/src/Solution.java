import java.util.Arrays;

//class Solution {
//    public int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for(int i = 1 ; i < nums.length ; i += 2){
//            sum += (nums[i] - nums[i - 1]);
//        }
//        return sum;
////    }
//}
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        // int left = 0;
        // int right = A.length;
        // while(left < right){
        //     while(left%2 != A[left%2]25)
        // }
        int Len = A.length / 2;
        int[] C = new int[Len];
        int[] D = new int[Len];
        int p = 0;
        int q = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] % 2 == 0) {
                C[p] = A[i];
                p++;
            } else {
                D[q] = A[i];
                q++;
            }
        }
        int j = 0;
        for (int i = 0; i < A.length; i += 2) {
            A[i] = C[j];
            A[i + 1] = D[j];
            j++;
        }
        return A;
    }
}