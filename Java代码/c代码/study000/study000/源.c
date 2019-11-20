#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//数位便利
void method1()
{
	int n;//数字number
	int m;//进制，权
	int temp1=0;
	int temp2=0;
	for (int i = n; n; n/=m)
	{
		temp1=n%m;//求出每一位，完成进制转化//temp+=n%m; 求出每一位并求和
		temp2 += temp2 * m + n % m;//反转
	}
}
int main()
{
}