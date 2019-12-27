import java.math.BigInteger;

public class 异常 {


            public int add(int a, int b) {
                try {
                    return a + b;
                } catch (ArithmeticException e) {

                    System.out.println("catch语句块");

                   // return a + b;
                } finally {
                    System.out.println("finally语句块");

                }
                return a ;
            }

            public static void main(String argv[]){

                异常 test =new 异常();
                System.out.println("和是："+test.add(9, 0));
                String s = "c";
            }


}
