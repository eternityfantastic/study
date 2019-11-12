import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringIsNum {
    public static boolean IsNum(String str){
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) >= '9' ||str.charAt(i) <= '0' ){
                return false;
            }
        }
        return true;
    }
    public static String reserve(String str){
        char[] ch = new char[str.length()];
        int j = 0;
        for (int i = str.length()-1; i >= 0  ; i--) {
            ch[j]=str.charAt(i);
            j++;
        }
        String retStr = new String(ch);
        return  retStr;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(IsNum("1224324"));
        "abc".length();
        "abc".charAt(1);
        byte[] bytes = "abc".getBytes();
        byte[] gbks = "abc".getBytes("GBK");
        System.out.println(Arrays.toString(gbks));
        String str = reserve("abc");
        System.out.println(str+"1111111111111111111111111111111111");
        char [] ch = {'a',101,102,103};
        StringBuffer sb = new StringBuffer(10);
        sb.append(ch ,0 ,3);
        System.out.println(sb.toString());
    }
}
