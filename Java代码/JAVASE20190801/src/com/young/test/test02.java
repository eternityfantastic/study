package com.young.test;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class test02 {

	static void add()
	{
		System.out.println(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 0);

	}
//数据类型的转换 短赋值给长不用管
	static double PI() {
		long length = 0x7fffffff;
		double result = 0;
		double temp;
		for (double i = 1; i < length; i += 4) 
		{
			temp=1/i;//刚开始中间过渡没啥用；
			result +=temp;
			//System.out.println(result);
		}
		for (double i = 3; i < length; i += 4)
		{
			result -= 1 / i;
			//System.out.println(result);
		}
		return  4*result;
	}

	static void printf() {
		System.out.println((double) (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
		System.out.printf("%10.16f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));// 宽度至少为10
		System.out.printf("%17.16f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
		System.out.printf("%18.16f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
		System.out.printf("%19.16f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));// 当宽度大于实际值时整数位应该是补了0，不显示
		System.out.printf("%20.16f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
		System.out.printf("%-20.16f\n", (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));// 左对齐

	}
	static void num(int num)//计算数字的各个位
	{
		int a0=num/1%10;//个位
		int a1=num/10%10;//十位
		int a2=num/100%10;//百位
		
	}
	static char   method01()//数字转换成ASCII码
	{
		char c;
		System.out.println("请输个数");
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		//System.out.println((char)a);
		c=(char) a;		
		return c;
	}
	static double method02()//计算BMI
	{	
		//System.out.println("把体重写上");
		Scanner input =new Scanner(System.in);
		System.out.println("把体重写上");
		double weighe=input.nextDouble();
		System.out.println("把身高写上");
		double heigh=input.nextDouble();
		double BMI=weighe/Math.pow(heigh, 2);
		//System.out.println(BMI);
		return BMI;
	}
    static int    method03()//对话框输入
    {
		String a=JOptionPane.showInputDialog("请输一个数");
		int b=Integer.parseInt(a);
		return b;
    }
	static void method04()//Math类
	{
		System.out.println(Math.toDegrees(Math.PI));
		System.out.println(Math.toRadians(180));
		System.out.println(Math.sin(Math.PI/6));
		//double result=Math.cos(Math.PI/3);
	//	System.out.println(Math.exp(a));
	}
    
    
    public static void main(String[] args) {
		//int intvalue=Integer.parseInt("s");//并不行
		double accept;
		accept =method03();
		System.out.println(accept);

	}
}
