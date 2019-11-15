import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Arrays;
//
////class Solution {
////    public int arrayPairSum(int[] nums) {
////        Arrays.sort(nums);
////        int sum = 0;
////        for(int i = 1 ; i < nums.length ; i += 2){
////            sum += (nums[i] - nums[i - 1]);
////        }
////        return sum;
//////    }
////}
//class Solution {
//    public int[] sortArrayByParityII(int[] A) {
//        // int left = 0;
//        // int right = A.length;
//        // while(left < right){
//        //     while(left%2 != A[left%2]25)
//        // }
//        int Len = A.length / 2;
//        int[] C = new int[Len];
//        int[] D = new int[Len];
//        int p = 0;
//        int q = 0;
//
//        for (int i = 0; i < A.length; i++) {
//
//            if (A[i] % 2 == 0) {
//                C[p] = A[i];
//                p++;
//            } else {
//                D[q] = A[i];
//                q++;
//            }
//        }
//        int j = 0;
//        for (int i = 0; i < A.length; i += 2) {
//            A[i] = C[j];
//            A[i + 1] = D[j];
//            j++;
//        }
//        return A;
//    }
//}

class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows > 0){

            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(1);
            list.add(objects);

            for (int i = 1; i < numRows; i++) {
                // i+1 行，有i+1个元素
                ArrayList<Integer> obj = new ArrayList<>();
                obj.add(1);
                ArrayList<Integer>prev = (ArrayList<Integer>) list.get(i - 1);
                for (int j = 1; j < i; j++) {
                    // 添加i-1 个元素；
                    obj.add(prev.get(j - 1) + prev.get(j));
                }
                obj.add(1);
                list.add(obj);
            }

        }
        return list;
    }
}

class MyStack{
    String []  str ;
    int size = 0;
    int capicity;
    MyStack(){
        str = new String[100];
        size = 0;
        capicity = 100;
    }

    public void push(String s){
        if(capicity == size ){

        }
        str[size++] = "s";
    }
    public boolean pop(String s){
        if(size == 0 ){
            return  false;
        }
        if(str[--size].equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
class Solution {
    public int rotatedDigits(int N) {

        int count = 0;
        for(int i = 2 ; i <= N; i++) {
            Integer n = i;
            String s = n.toString();

            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) {
                System.out.println(s);
                count++;
            }
        }
        return count;

    }
}
class SolutionTest {
    public static void main(String[] args) {
        String s = new String("ABC");
        String s1 = s.toLowerCase();
        StringBuffer
    }

}