#define _CRT_SECURE_NO_WARNINGS 1
/*�ձ�ĳ�ط�����һ��ıɱ��������ͨ���Ų�ȷ��ɱ�����ֱ�Ϊ4���� 
���ɷ���һ��������Ϊ4�����ɷ��Ĺ��ʡ� 
A˵�������ҡ� 
B˵����C�� 
C˵����D�� 
D˵��C�ں�˵ 
��֪3����˵���滰��1����˵���Ǽٻ��� 
�����������Щ��Ϣ��дһ��������ȷ������˭�����֡� 
*/
//1��ʾ������
#include<stdio.h>
#include<windows.h>

void method1()
{

	for (int a = 0; a < 2; a++)
	{
		for (int b = 0; b < 2; b++)
		{
			for (int c = 0; c < 2; c++)
			{
				for (int d = 0; d < 2; d++)
				{
					if ((a == 1 && c == 1 && d == 1 & d == 0) && (a + b + c + d == 1))//ÿ�μ���һ����˵��
					{
						printf("a��˵��\n");
						if (a== 1)
						{
							printf("a������\n");
						}
						if (b== 1)
						{
							printf("b������");
						}
						if (c== 1)
						{
							printf("c������");
						}
						if (d== 1)
						{
							printf("d������");
						}
					}
					if ((a != 1 && c != 1 && d == 1 & d == 0) && (a + b + c + d == 1))
					{
						printf("b��˵��\n");
						if (a == 1)
						{
							printf("a������");
						}
						if (b == 1)
						{
							printf("b������");
						}
						if (c == 1)
						{
							printf("c������");
						}
						if (d == 1)
						{
							printf("d������");
						}
					}
					if ((a != 1 && c == 1 && d != 1 & d == 0) && (a + b + c + d == 1))
					{
						printf("c��˵��\n");
						if (a == 1)
						{
							printf("a������");
						}
						if (b == 1)
						{
							printf("b������");
						}
						if (c == 1)
						{
							printf("c������");
						}
						if (d == 1)
						{
							printf("d������");
						}
					}
					if ((a != 1 && c == 1 && d == 1 & d != 0) && (a + b + c + d == 1))
					{
						printf("d��˵��\n");
						if (a == 1)
						{
							printf("a������\n");
						}
						if (b == 1)
						{
							printf("b������");
						}
						if (c == 1)
						{
							printf("c������");
						}
						if (d == 1)
						{
							printf("e������");
						}
					}
				}
			}
		}
	}
}
void method2()
{
	char killer;
	for (killer = 'a'; killer <= 'd'; killer++)
	{
		if ((killer!='a')+(killer=='c')+(killer=='d')+(killer!='d')==3)
		{
			printf("������%c\n", killer);
		}
	}

}
int main()
{
	method1();
	putchar('\n');
	method2();
	system("pause");
	return 0;
}
