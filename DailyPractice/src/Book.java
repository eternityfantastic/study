import java.util.Scanner;

public class Book {

    public int[] score(int... score) {
        System.out.println("输入成绩");
        Scanner scanner = new Scanner(System.in);
        int ave = 0;
        score[0] = scanner.nextInt();
        for (int i = 0; score[i] != -1; i++) {
            score[i + 1] = scanner.nextInt();
        }

        for (int i = 0; i < score.length; i++) {
            ave += (double) score[i] / score.length;
        }
        int[] ret = new int[2];
        for (int i = 0; i < score.length; i++) {
            if (score[i] > ave) {
                ret[0]++;
            } else {
                ret[1]++;
            }
        }
        return ret;
    }
}
