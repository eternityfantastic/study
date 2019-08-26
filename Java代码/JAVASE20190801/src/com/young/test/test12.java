package com.young.test;

import java.util.Scanner;

public class test12 {
	public static Scanner input=new Scanner(System.in);
	//接受数组数据并求和
	public static double sumMatrix(double [][] m) {
		double sum=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j]=input.nextDouble();
				sum+=m[i][j];
			}
		}
		return sum;
	}
	//员工工时排序
	public static void sumMajorDiagonal(int [][]m)
	{
		int [][]arr=new int[8][2];
		for (int i = 0; i < m.length; i++) {
			arr[i][0]=i;//员工号
			int sum=0;
			for (int j = 0; j < m[i].length; j++) {
				sum+=m[i][j];
			}
			arr[i][1]=sum;//员工工时
		}
		//排序选择排序;
		for (int i = 0; i < arr.length; i++) {
			int maxId=arr[i][0];
			int max=arr[i][1];
			for (int j = i+1; j < arr.length; j++) {
				if (max<arr[j][1]) {
					int tempId;
					int temp;
					tempId=arr[j][0];
					temp=arr[j][1];
					arr[j][0]=maxId;
					arr[j][1]=max;
					maxId=tempId;
					max=temp;
				}
				arr[i][0]=maxId;
				arr[i][1]=max;
			}
		}
		//输出
		for (int i = 0; i < arr.length; i++) {
			System.out.println("第"+(i+1)+"名 是员工Employee"+arr[i][0]+" 总工时是"+arr[i][1]);
		}
	}
public static void main(String[] args) {
//	double [][]m=new double [4][4];
//	System.out.println(sumMatrix(m));
	int [][]n= {
			{2,4,3,4,5,8,8},
			{7,3,4,3,3,4,4},
			{3,3,4,3,3,2,2},
			{9,3,4,7,3,4,1},
			{3,5,4,3,6,3,8},
			{3,4,4,6,3,4,4},
			{3,7,4,8,3,8,4},
			{6,3,5,9,2,7,9},
	};
	sumMajorDiagonal(n);
}
}
