#define _CRT_SECURE_NO_WARNINGS 1
//дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮�ͣ�
//���磬����DigitSum(1729)����Ӧ�÷���1 + 7 + 2 + 9�����ĺ���19
#include<stdio.h>
#include<windows.h>

int sum = 0;
int method(int n)
{
	//int sum = 0;
	if (n > 9)
	{
		method(n / 10);
	}
	sum += n % 10;
	
}
int main()
{
	method(11111);
	printf("%d\n",sum);
	system("pause");
	return 0;
}