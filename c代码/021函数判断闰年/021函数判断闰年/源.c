#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

void method(int n)
{
	if (n % 400 == 0 || n % 100 != 0 && n % 4 == 0)
	{
		printf("%d������\n",n);
	}
	else
	{
		printf("%d��������\n", n);
	}
}
int main()
{
	method(2018);
	system("pause");
	return 0;
}