#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
/*����ˮ��1ƿ��ˮ1Ԫ��2����ƿ���Ի�һƿ��ˮ�� 
��20Ԫ�����Զ�����ˮ�� 
���ʵ�֡�*/
//����һ
int method(int n) {
	int drink = n;//��һ�κȵ�//drink%2û�����
	int empty = n;//
	int remainder;
	while (empty > 1) {
		drink += empty / 2;//


		//remainder += drink % 2;//����ʣ��
		//empty = drink + remainder;//��ƿ�������һ�κȵ�����+����һ��û�һ���ƿ��//
		//drink = empty % 2;//������������

		empty = empty / 2 + empty % 2;//��ƿ�������һ�κȵ�����+����һ��û�һ���ƿ�ӣ�
	}
	return drink;
}
//������
int num (int n)
{
	if (n != 0)//��Ԫ������ƿ
	{
		if (n != 1)//һԪ����һƿ
		{
			if (n%2 == 0)//ż��
			{
				return n + num(n/2);//ż��ֱ�ӷ��ص�n�еĸ����ӵ�n-1�еĸ���

;
			}
			else//����
			{
				return (n - 1) + num((n/2) + 1);//����ʱ�ɵ�n�����µ�һ��Ų����n-1�У���n-1�еĽ��м���
			}
		}
		else
		{
			return 1;
		}
	}
	else
	{
		return 0;
	}
}
//������
int Fun2(int money,int num)
{
	
	money = money - num;
	int sum = 0;
	sum += num+1;
	while (money)
	{
		money-=(num-1);
		sum += num;
	}
	return sum;
}
int main()
{

	int n = 20;
	printf("%d", method(n));
	system("pause");
	return 0;
}
