#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

void method(char*str,int n,int len)
{
	int i;
	char temp;
	temp = str[len - 1];
	for ( i = 0; i < n; i++)//�����ƶ�n��
	{
		char temp;
		//βԪ���ȼĴ�����
		temp = str[len - 1];
		//ǰ���ͳһ�����һ��
		int j;
		for (j = len - 2 ; j >= 0; j--)
		{
			str[j + 1] = str[j];
		}
		str[0] = temp;
	}
}
int main()
{
	int n = 3;
	char str[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int len = strlen(str);
	method(str, n, len);
    printf("%s", str);
	system("pause");
	return 0;
}
