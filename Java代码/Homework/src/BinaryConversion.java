public class BinaryConversion {
    public void method(int num, int m) {
        if (num == 0) {
            return;
        } else {
            this.method(num / m, m);
        }
        if (num % m < 10) {
            System.out.print(num % m);
        }
        if (num % m == 10) {
            System.out.print("A");
        }
        if (num % m == 11) {
            System.out.print("B");
        }
        if (num % m == 12) {
            System.out.print("C");
        }
        if (num % m == 13) {
            System.out.print("D");
        }
        if (num % m == 14) {
            System.out.print("E");
        }
        if (num % m == 15) {
            System.out.print("F");
        }
    }
}





























