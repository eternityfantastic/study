#include<stdio.h>
#include<math.h>

int prime(int n)//����һ���ж������ĺ���
{
	int i;
	for (i = 2; i <= sqrt(n); i++)
	{
		if (n%i == 0)
		{
			printf("��������");
			break;
		}
	}
	if (i > sqrt(n))
	{
		printf("%d������\n",n);
	}
}

int main()
{
	for (int i = 100; i < 201; i++)
	{
		prime(i);
	}

}