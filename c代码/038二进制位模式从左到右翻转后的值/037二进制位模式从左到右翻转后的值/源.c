#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
unsigned int reverse_bit(unsigned int value)//Ī������д�����ˣ��治֪����ʱզ���
{
	unsigned int result=0;
	for (int  i = 0; i < 32; i++)
	{
		result = (result << 1) + ((value >> i) & 1);
	}
	return result;
}

int main()
{
	unsigned int value = 25;
	system("title value�Ķ�����λģʽ�����ҷ�ת���ֵ");
	system("color ED");

	printf("%u\n", reverse_bit(value));
	system("pause");
	return 0;
}

