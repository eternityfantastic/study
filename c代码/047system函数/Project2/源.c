#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int print()
{
	printf(" �n�n�n�n�n�n�k�k�k�k�k�k�k�k�n�n�n�n�n�n\n");
	printf("�X�T�T�T�k�kC���Թػ����� �k�k�T�T�T�[\n");
	printf("�U��1.ʵ��10�����ڵĶ�ʱ�رռ����  �U\n");
	printf("�U��2.�����رռ������              �U\n");
	printf("�U��3.ע���������                  �U\n");
	printf("�U��0.�˳�ϵͳ��                    �U\n");
	printf("�^�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�a\n");
	return 0;
}
int main()
{
	system("title C���Թػ�����");//����cmd���ڱ���
	system("mode con cols=48 lines=25");//���ڿ�ȸ߶�
	system("color 0B");
	system("date /T");
	system("TIME /T");
	char cmd[20] = "shutdown -s -t ";
	char t[5] = "0";
	print();
	int c;
	scanf("%d", &c);
	getchar();
	switch (c)
	{
	case 1:
		printf("�����ڶ�������Զ��رռ��������0~600��\n"); 
		scanf("%s", t);
		system(strcat(cmd, t)); break;
	case 2:
		system("shutdown -p"); break;//shutdown -r ������shutdown -aȡ���ػ���shutdown -h���� shutdown -i ��ʾԶ�̹ػ��Ի��� 
		//shutdown -shutdown -shutdown -
	case 3:
		system("shutdown -i"); break;//ע����ǰ�û�
	case 0:
		break;
	default:
		printf("Error!\n");
		break;
	}
	system("pause");
	exit(0);
}