import java.io.UnsupportedEncodingException;

public class StringConstruct {
    public static  final synchronized void main(String[] args) throws UnsupportedEncodingException {
//        String s1=new String("A")+new String("B");
//        System.out.println(s1==s1.intern());
//        System.out.println(s1=="AB");
//        String S1 = "A";
//        String S2 = "B";
//        String s1=S1+S2;
//
//        System.out.println(s1==s1.intern());
//        System.out.println(s1=="AB");
//
//        String s = new String("A");
//        s.intern();
//        String s2 = "A";
//        System.out.println(s == s2);
//
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);
//
//        byte[] arr = {98,99,100};
//        String str = new String(arr);
//        String s = "ABCD";
//        String s2 = new String("A");


        /**
         * String​(byte[] bytes)构造方法演示；
         */
        String s = new String(new byte[]{98,99},"utf8");
        System.out.println(s);
    }
}
