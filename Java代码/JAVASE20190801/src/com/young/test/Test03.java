package com.young.test;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Test03 {//金字塔
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("写个行数");
		int n=input.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <n-i; j++) {
				System.out.print("  ");
			}
			for (int j = i; j >0; j--) {
				System.out.print(j);
				System.out.print(" ");
			}
			for (int j = 2; j <=i; j++) {
				System.out.print(j);
				System.out.print(" ");
			}
			for (int j = 0; j <n-i; j++) {
				System.out.print("  ");
			}
			System.out.println();
		}
		
	}

}
