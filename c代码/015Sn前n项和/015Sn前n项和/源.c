#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

void method(int s)
{
	int n;
	int b=1;
	int result = 0;
	int si = 0;
	int sn = 0;

	printf("Ҫ�������֮��");
	scanf("%d", &n);

	for (int i = 0; i < n; i++)//ѭ��N��
	{
		si = s * b;//Sn��ĳһλ
	//2	si = s * pow(10,i);//Sn��ĳһλ
		sn += si;//Sn
		result += sn;//Sn�ĺ�
		b *= 10;
	}
	printf("%d\n", result);
}
int main()
{
	int s;
	printf("������S1");
	scanf("%d", &s);
	method(s);
	system("pause");
	return 0;
}