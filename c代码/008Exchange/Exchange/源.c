#include<stdio.h>
#include<Windows.h>
//�����ò����ķ�ʽ��ʵ���������Ľ���
void exchange0(int *num1, int* num2) {
	int temp;
	temp = *num1;
	*num1 = *num2;
	*num2 = temp;
	printf("a=%d,b=%d\n", *num1,*num2);
}
int exchange1(int a, int b)
{
	printf("�ٽ���a=%d,b=%d\n", a + b - a, a + b - b); return 0; 
}
void exchange2(int *a, int *b)
{
	*a = *a ^ *b;
	*b = *a ^ *b;
	*a = *a ^ *b;
	printf("��ٻ�a=%d,b=%d\n", *a, *b);
}


int main()
{
	int a = 10;
	int b = 12;
	exchange0(&a, &b);//���������ַ����
	exchange1(a,b);//����������ٽ���
	exchange2(&a, &b);//����������潻��
   	system("pause");
	return 0;
}
