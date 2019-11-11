public class ContinueAndBreak {
    public static void main(String[] args) {
        out:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == 1) {
                        continue out;
                       // continue;
                    }
                    System.out.println(k);
                }
            }
        }
        System.out.println("break");
    }
}
