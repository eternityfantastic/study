#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<string.h>
int panduan(int len1, int len2, char str1[], char str2[])
{
	if (len1 != len2)
	{
		return 0;
	}
	for (int n = 0; n < len1; n++)
	{
		int i;
		char temp;
		temp = str2[len1 - 1];
		for (i = 0; i < n; i++)//�����ƶ�n��
		{
			char temp;
			//βԪ���ȼĴ�����
			temp = str2[len1 - 1];
			//ǰ���ͳһ�����һ��
			int j;
			for (j = len1 - 2; j >= 0; j--)
			{
				str2[j + 1] = str2[j];
			}
			str2[0] = temp;
		}
		//�ƶ����˱Ƚ�һ��
		if (0 == strcmp(str1, str2))
		{
			return 1;
		}
	}
	return 0;
}
int Fun(char str1[], char str2[])
{
	char temp[100]= strcat(str1, str1);
	//��temp�в���str2
}
int main()
{ 
	char str1[] = "abcdef";//ԭ����
	char str2[] = "defabc";//Ŀ������
	char str3[] = "defbc";//Ŀ������
	char str4[] = "defabc";//Ŀ������
	char str5[] = "defabc";//Ŀ������
	char str6[] = "deuabc";//Ŀ������

	int len1 = strlen(str1);
	int len2 = strlen(str2);
	int len3 = strlen(str3);
	int len4 = strlen(str4);
	int len5 = strlen(str5);
	int len6 = strlen(str6);
	printf("%d\n", panduan(len1, len2, str1, str2));
	printf("%d\n", panduan(len3, len4, str3, str4));
	printf("%d\n", panduan(len5, len6, str5, str6));
	system("pause");
	return 0;
}