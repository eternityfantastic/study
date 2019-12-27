import java.util.Scanner;

public class Solution000 {
    public static void GetSequeOddNum(int m){
        StringBuffer sb = new StringBuffer();
        int seq =(int) Math.pow(m,3);
        int squ = (int)Math.pow(m,2);
        int temp = squ - m + 1 ;
        for(int i = 0  ; i < m ; i++){
            sb.append(temp);
            if(i != m-1){
                sb.append("+");
            }
            temp += 2;
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            GetSequeOddNum(a);
        }
    }



    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        //while (in.hasNextInt()) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            System.out.println("第"+i+"数");
            int n = in.nextInt();
            while (n != 0) {
                sb.append(i);
                n--;
            }
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        if (sb.charAt(i) != '0' && sb.charAt(0) == '0') {
            sb.setCharAt(0, sb.charAt(i));
            sb.setCharAt(i, '0');
        }
        System.out.println(sb.toString());

    }
}