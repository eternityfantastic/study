#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>


//����һ�������������飻
void Bianli(int a[], int len)
{
	printf("���ڵ�������");
	int i;
	for (i = 0; i < len; i++)
	{
		printf("%d ", a[i]);
	}
	putchar('\n');

}

//ʵ�ֺ���init������ʼ������
void init(int a[],int len) 
{
	int i;
	char c;
	for ( i = 0; i < len; i++)
	{
		printf("�����������a[%d]Ԫ��", i);
		scanf("%d", &a[i]);
		//printf("�������� y or n");
		//getchar();
		//scanf("%c", &c);
		////getchar();
		//if (c=='y')
		//{
		//	break;
		//}
	}
	printf("ִ�г�ʼ�����\n");

}
//ʵ��empty����������顢
void empty(int a[],int len)
{
	printf("ִ������������\n");
	int i;
	for (i = 0; i < len; i++)
	{
		memset(a, 0, sizeof(a[0]) * len);//string.h
	}
}
//ʵ��reverse���������������Ԫ�ص����á�
void reverse(int a[], int len)
{
	printf("ִ������Ԫ�ص��������\n");

	int i=0;
	int l = 0;
	int r = len-1;
	while (l < r)
	{
		int temp;
		temp = *(a + r);
		*(a + r) = *(a + l);
		*(a + l) = temp;
		l++;
		r--;
	}
}
int main()
{
	int a[] = {0};
	int len;
	printf("��ʼ��������");
	scanf("%d", &len);
	//int len = sizeof(a)/sizeof(a[0]);
	init(a , len);
	Bianli(a , len);
	reverse(a, len);
	Bianli(a, len);
	empty(a ,len);
	Bianli(a, len);
	system("pause");
	return 0;
}