#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
void print(int n)
{
	int i;
	for (  i = 0; i < 32; i++)
	{
		if ((n>>i)&1)//���ƺ�ĩβΪ1
		{
			putchar('1');
			if ((n>>(i+1))==0)//�ٴ����ƺ�Ϊ0����ֹͣ
			{
				break;
			}
		}
		else if ((n >> i) > 0)//�����Ժ�ĩβΪ0�������ƺ�Ϊ0
		{
			putchar('0');
		}
		else
		{
			break;
		}
	}
}
void method(int n)
{
	int odd;//����
	int even;//ż��
	printf("��������λ��");
	for (int i = 31; i >=1; i-=2)//����ȡ��������λ
	{
		odd = (n >> i) & 1;
		//odd <<= odd;
		printf("%d", odd);
	}
	putchar('\n');
	printf("��������λ��");
	for (int i = 30; i >= 0; i -= 2)//����ȡ����ż��λ
	{
		even = (n >> i) & 1;
		//even <<= even;
		printf("%d", even);
	}
	putchar('\n');
}
void Fun(int n)
{
	int sum1 = 0;
	int sum2 = 0;
	int length = 0;
	for (int i = n; n; n >>= 2)
	{
		sum1 = (sum1 <<1 )+ (n & 1);//��������λ
		sum2 = (sum2 << 1)+ (n >> 1 & 1);//ż��λ
		length++;
	}
	//��ӡ
	//printf("%d",sum2);
	for (int i = 0; i <length ; i++)
	{
		printf("%d", sum1>>i&1);
	}
	putchar('\n');
	for (int i = 0; i < length; i++)
	{
		printf("%d", sum2 >> i & 1);
	}
}
int main()
{
	//printf("%d", method(n));
	//method(13); 8+4+1   1101
	Fun(13);
	system("pause");
	return 0;
}