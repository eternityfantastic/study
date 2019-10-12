package com.young.Cuess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessingGame {
    static Scanner in = new Scanner(System.in);
    private int count;//记录猜对字符数量
    private char[] input;//存放用户输入的字符w
    private char[] chs;//存放系统产生的字符
    private int[] result = new int[2];//判断结果z

    @Override
    public String toString() {
        return "GuessingGame{" +
                "count=" + count +
                ", input=" + Arrays.toString(input) +
                ", chs=" + Arrays.toString(chs) +
                ", result=" + Arrays.toString(result) +
                '}';
    }

    public char[] InputChar() {
        String str = in.next();
        System.out.println("请输入5个字符大写");
        str = in.nextLine();
        for (int i = 0; i < 5; i++) {
            chs[i] = str.charAt(i);
            // System.out.print(chs[i] + " ");
        }
        return chs;
    }

    public char[] generate() {//产生随机字符
        char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        boolean[] flag = new boolean[letter.length];
        char[] chs = new char[5];
        for (int i = 0; i < chs.length; i++) {
            int index;
            do {
                index = (int) (Math.random() * (letter.length));

            } while (flag[index]);
            chs[i] = letter[index];
            flag[index] = true;
        }
        System.out.println("系统加载完成");
        return chs;
    }

    public int[] check(char[] input, char[] chs) {//与玩家输入对比;
        //int[] result=new int[2];
        int[] result = {0, 0};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (input[i] == chs[j]) {
                    result[0]++;//字符相同
                    if (i == j) {
                        result[1]++;//位置
                    }
                }
            }
        }
        if (result[1] == 5) {
            System.out.println("大吉大利，今晚吃鸡");
        } else {
            System.out.println("你猜对了" + result[0] + "个，其中位置正确的有" + result[1] + "个字符序列（按键0退出）");
        }
        return result;
    }

    public void showMinu() {
        System.out.println("********************************");
        System.out.println("*********欢迎进入猜字母**********");
        System.out.println("*********1.play******************");
        System.out.println("*********0.exit******************");
        System.out.println("********************************");
    }


}
