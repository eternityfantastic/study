#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
void print_num(unsigned value)
{
	int count = 0;//��������� λ��
	int a[32] = { 0 };
	int i = 0;
	while (value) {
		a[i++] = value % 2;
		value /= 2;
		count++;
	}
	printf("��������\n");
	for (i = count; i >= 0; i -= 2) {
		printf("%d ", a[i]);
	}
	printf("\n");
	printf("ż������\n");
	for (i = count - 1; i >= 0; i -= 2) {
		printf("%d ", a[i]);
	}
	printf("\n");
}
int main()
{
	printf("��ȡһ�������������������е�ż��λ������λ,�ֱ��������������(��������01011)\n");
	int value = 11;//01011
	print_num(value);
	system("pause");
	return 0;
}