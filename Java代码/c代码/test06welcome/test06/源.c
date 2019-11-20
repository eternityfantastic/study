#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<string.h>
int main()
{
#if 0
	char a[] = "welcome to bit";
	int len = (sizeof(a) / sizeof(a[0]));
	for (int n = 1; n <= len/2+1; n++)//n代表要输出几行
	{
		Sleep(300);
		for (int i = 1; i <= n; i++)
		{
			putchar('*');
		}
		for (int i = n; i <= len-n; i++)
		{
			putchar(a[i]);
		}
		for (int i = 0; i < n; i++)
		{
			putchar('*');
		}
		putchar('\n');
	}
#endif

	char a1[] = "welcome to bat";
	char a2[] = "**************";
	int left = 0;
	int right = strlen(a1)-1;
	while (left<=right)
	{
		Sleep(200);
		a2[left] = a1[left]; 
		a2[right] = a1[right];
		left++;
		right--;
		printf("%s\n",a2);
	}

	system("pause");
	return 0;
}