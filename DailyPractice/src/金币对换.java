import java.util.Scanner;

public class 金币对换 {
    public static String helper(long ret , StringBuilder sb){
        sb.append(ret / 17 / 19).append(".");
        ret %= (17 * 19);
        sb.append(ret / 19).append(".");
        ret %= 19;
        sb.append(ret);
        return sb.toString();
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String P = in.next();//应付
            String A = in.next();//实付
            String[] ps = P.split("\\.");
            String[] as = A.split("\\.");
            StringBuilder sb = new StringBuilder();

            long m = Long.parseLong(ps[0]) * 17 * 19 + Long.parseLong(ps[1]) * 19 + Long.parseLong(ps[2]);
            long n = Long.parseLong(as[0]) * 17 * 19 + Long.parseLong(as[1]) * 19 + Long.parseLong(as[2]);

            if (n > m) {
                long ret = n - m;
                String s = helper(ret ,sb);
                System.out.println(s);
            } else {
                long ret = m - n;
                String s = helper(ret ,sb);
                System.out.println("-"+s);
            }
        }
    }
}