#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<math.h>

void method()
{
	int num;//������жϵ���
	int sum = 0;
	printf("������һ����");
	scanf("%d", &num);
	if (num>0x7fffffff)
	{
		printf("��̫���жϲ���");

	}
	else {
		//�ж��м�λ���Ӷ�ȷ����ֵ��0x7fff=32767
		int n = 10;
		for (int i = 1000000000; i > 0; i /= 10)
		{
			if (num / i != 0)
			{
				break;
			}
			--n;
		}
		
		/*��λͳ��
		int n=0;
		for (int i = num; i ; i /= 10)
		{
			n++;
		}*/
		//��λ�ݴηż�����
		for (int i = 1; i < pow(10, n); i *= 10)
		{
			int a = num / i % 10;
			//int a2 = pow(a, n);
			sum += pow(a, n);
		}
		//�ж��ǲ���ˮ�ɻ���
		if (num == sum)
		{
			printf("��ˮ�ɻ���\n");
		}
		else {
			printf("����ˮ�ɻ���\n");

		}
	}
}
int main()
{
	method();
	system("pause");
	return 0;
}