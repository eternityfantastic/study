#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define N 3 //�ַ�������
#define MAX_SIZE 30 //�ַ������С��Ҫ��ÿ���ַ������Ȳ�����29
int main(void)
{
	char file_name[30] = "D:\\test.txt";
	char str[MAX_SIZE];

	FILE *fp;
	int i;
	fp = fopen(file_name, "a+"); 
	if (NULL == fp)
	{
		printf("Failed to open the file !\n");
		exit(0);
	}
	printf("������%d���ַ�����\n", N);
	for (i = 0; i < N; i++)
	{
		printf("�ַ���%d:", i + 1);
		fgets(str, MAX_SIZE, stdin);//�Ӽ��������ַ���������str������
		fputs(str, fp);//��str���ַ��������fp��ָ�ļ���
	}
	rewind(fp); //��fp��ָ�ļ��Ķ�дλ�õ���Ϊ�ļ���ʼ��
	while (fgets(str, MAX_SIZE, fp) != NULL)
	{
		fputs(str, stdout); //���ַ����������Ļ
	}
	fclose(fp);
	system("pause");
	return 0;
}

int main1()
{
	char file_name[20] = "D:/test.TXT";
	FILE * fp = fopen(file_name, "a"); //���ļ�
	int c; //c:����fgetc�ķ���ֵ������Ϊint������char M
	if (NULL == fp)
	{
		printf("%s", strerror(errno));
		exit(0);
	}
	else
	{
		printf("�������ַ������س���������");
		while ((c = fgetc(fp)) != '\n') //stdin:ָ���׼�����豸�����ļ�//����scanf,��������������ַ���ֵ��c
		{
			fputc(c, stdout); //stdout:ָ���׼����豸��ʾ���ļ�
			fputc(c, fp);
		}
		fputc('\n', stdout);
		fclose(fp); //�ر��ļ�
	}
	//int fgetc(FILE*fp);//��fpλ������һ���ַ�
	//getchar();
	//fgetc(stdin);
	//int fputc(int c,FILE*fp);//��fp��ָ�ļ�������һ���ַ�c
	//char c;
	//putchar(c);
	//fputc(c,stdout);

	system("pause");
	return 0;
}