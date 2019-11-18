import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
class Solution2 {
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
class Solution3 {
    public String toGoatLatin(String S) {
        String[] strArr = S.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < strArr.length ; i++ ){
            String str = strArr[i];
            char ch = str.charAt(0);
            if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o'|| ch == 'u'){
                //str.substring()
                sb.append(str).append("ma").append("a".repeat(i+1)).append(" ");
            }else{
                sb.append(str.substring(1,str.length())).append(ch+"")
                        .append("ma").append("a".repeat(i+1)).append(" ");
            }
        }
        return sb.toString();
    }
}
class Solution {
    public void countBinarySubstrings(String Str) {
        HashSet<String> t = new HashSet<>();
        int num = 0 ;
        char ch = 0;
        int begin = 0;
        for(int j = 0 ; j < Str.length()-1; j++){
            String s = Str.substring(j);
            System.out.println(s);
            for(int i = 0 ; i < s.length(); i++){
                if(num == 0 ){
                    ch = s.charAt(i);
                    begin = i;
                }
                if(s.charAt(i)==ch){
                    num++;
                }else{
                    num--;
                    if(num == 0){
                        System.out.println(s.substring(begin,i+1)+"--");
                        t.add(s.substring(begin,i+1));
                    }
                }
            }
        }
        System.out.println(t);
    }
}
class SolutionTest {
    public static void main(String[] args) {
//        String s = new String("ABC");
//        String s1 = s.toLowerCase();
//        System.out.println(s1.repeat(3));
//        System.out.println("a".repeat(3));
        Solution s1 = new Solution();
        s1.countBinarySubstrings("00110011");
        System.out.println("ABCDEF".substring(0,2));
    }

}