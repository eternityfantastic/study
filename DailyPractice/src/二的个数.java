public class 二的个数 {
    public static int countNumberOf2s(int n) {
        if (n < 2) {
            return 0;
        } else if (n < 10) {
            return 1;
        }
        Integer N = n;
        String s = N.toString();
        int sum = 0;
        int len = s.length();
        int i = 1;

        while (len > 1) {
            char c = s.charAt(len-1);
            String sub = s.substring(0, len--);
            int temp = Integer.parseInt(sub);
            sum += c < '2' ? temp * i : 1;
            i *= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        for(int i = 0 ; i < 1000 ; i ++){
            System.out.print(i+"    ");
            if(i%10==0){
                System.out.println();
            }
        }
    }
}
