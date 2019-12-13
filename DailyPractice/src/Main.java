import java.util.Scanner;

public class Main {
    public static void method(String A, String B) {
        int len = B.length();
        for (int i = 0; i < len; i++) {
            A = A.replace(B.charAt(i) + "", "");
        }
        System.out.println(A);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            String b = in.next();
            method(a, b);
        }
    }
}