import java.util.Arrays;

public class Test {
    public String toString(int [] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str +=array[i];
            if(i != array.length-1){
                str += ",";
            }
        }
        str+= "]";
        return str;
    }
    public static void main(String[] args) {
        Test test = new Test();
        int[] array1 ;
        array1 = new int[] {1,2,3};
        //String string =test.toString(array1);
        //System.out.println(string);
        char[] a = {'A','B','C'};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        int[] array2 = new int[array1.length+1];
        System.arraycopy(array1,0,array2,1,array1.length-1);
//        System.out.println(Arrays.toString(array2));
//        System.out.println(Arrays.toString(array1));
        array2 = array1.clone();
        array2[2]= 15;
        System.out.println(Arrays.toString(array2));
    }
}
