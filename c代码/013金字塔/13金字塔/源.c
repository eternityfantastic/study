#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

	void method(int n)
	{
		for (int i = 1; i <= n; i++) {//ѭ�����n��
			for (int j = 0; j < n - i; j++) {//ѭ�����n-i���ո�
				putchar(' ');
				putchar(' ');
			}
			for (int j = 0; j < 2*i-1; j++) {//���*Ϊ1��3��5��
				putchar('*');
				putchar(' ');

			}
			
			putchar('\n');
		}
		for (int i = n-1; i >=0; i--) {//ѭ�����n��
			for (int j = 0; j < n - i; j++) {//ѭ��������ո�
				putchar(' ');
				putchar(' ');
			}
			for (int j = 0; j < 2 * i - 1; j++) {//���*
				putchar('*');
				putchar(' ');

			}
			putchar('\n');
		}
		//for (int i = 1; i < n; i++) {
		//	for (int j = 1; j <= i; j++) {//ѭ�����i���ո�
		//		putchar(' ');
		//		putchar(' ');
		//	}
		//	for (int j = 1; j <= 2*n-1 - 2*i; j++) {//���*��Ϊ
		//		putchar('*');
		//		putchar(' ');
		//	}		
		//	putchar('\n');
	 //   }

    }

int main()
{
	int n=0;
	printf("����������");
	scanf("%d", &n);
	method(n);
	system("pause");
	return 0;

}
