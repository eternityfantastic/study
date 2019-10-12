package com.young.Cuess;

import com.young.Cuess.GuessingGame;

import java.util.Scanner;

public class Test {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args1) {
        GuessingGame a1 = new GuessingGame();
        a1.showMinu();
        //产生随机字符
        char[] chs = new char[5];
        chs = a1.generate();
        int[] result = new int[2];
        System.out.println("选择模式");
        //int choose=in.nextInt();
        int choose;
        do {
            choose = in.nextInt();
            //玩家输入字符；
            char[] input = new char[5];
            input = a1.InputChar();
            //判断
            result = a1.check(input, chs);

        } while (choose == 1 || (result[1] != 5));
    }
}
