#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
//�ȼ���length;
int length(const char*str)
{
	if (*str != '\0')
	{
		return 0;
	}
	return 1 + length(str + 1);
}
//
void reverse_string(char * string)
{
	if (*string != '\0')
	{
		char tmp;
		int  end = length(string);
		tmp = *string;//����ĸ������
		*string = string[end];//β��ĸ����滻 
		string[end]='\0';//β��������Ƶݹ���Ĺ���
		reverse_string(string + 1);//
		string[end] = tmp;//�ݹ�Ĺ���̣�����������ǰ��طŻغ���
	}
}
int main()
{
	char * string = "abcde";
	reverse_string(string);
	system("pause");
	return 0;
}