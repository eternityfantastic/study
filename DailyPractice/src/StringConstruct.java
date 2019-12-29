public class StringConstruct {
    public static int toLittleEndian(int a) {
        return (((a & 0xFF) << 24) | (((a >> 8) & 0xFF) << 16) | (((a >> 16) & 0xFF) << 8) | ((a >> 24) & 0xFF));
    }

    public static final void main(String[] args) {
//        String s0 = "abc";
//        String s1 = new String("abc");
//        System.out.println(s0==s1);
//        String str1 =new String("ab");
//        String str2 = new String("str1");
//        System.out.println(str1==str2);
        //String s1=new String("A")+new String("B");
        //System.out.println(s1==s1.intern());
        String s1 = "A" + "B";
        System.out.println(s1 == "AB");


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


//        /**
//         * String​(byte[] bytes)构造方法演示；
//         */
//        String s = new String(new byte[]{98,99},"utf8");
//        System.out.println(s);
    }
}
