package com.young.test;

import java.util.Scanner;

public class test04 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("恁先输个数");
		int n=input.nextInt();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n-i; j++) {//循环输出n-1个空格
				System.out.print(" ");
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {//输出数字数和行数相等
				System.out.print((int)Math.pow(2, j));
				System.out.print(" ");
			}
			for (int j = i-2; j >= 0; j--) {
				System.out.print((int)Math.pow(2,j));
				System.out.print(" ");
			}
			for (int j = 0; j < n-i; j++) {
				System.out.print(" ");
				System.out.print(" ");
			}
			System.out.println();
			
			
		}
	}

}
