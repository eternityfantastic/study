#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
void main()
{
	char letter;
	system("color ED");
	/*0 = ��ɫ 8 = ��ɫ
	1 = ��ɫ 9 = ����ɫ
����2 = ��ɫ A = ����ɫ
����3 = ǳ��ɫ B = ��ǳ��ɫ
����4 = ��ɫ C = ����ɫ
����5 = ��ɫ D = ����ɫ
����6 = ��ɫ E = ����ɫ
����7 = ��ɫ F = ����ɫ
*/

	do {
		printf("A Display directory listing\n");
		printf("B Display disk information\n");
		printf("C Change system date\n");
		printf("Q Quit\n");
		printf("Choice: ");

		letter = getch();
		letter = toupper(letter);

		if (letter == 'A')
			system("DIR");
		else if (letter == 'B')
			system("CHKDSK");
		else if (letter == 'C')
			system("DATE");
	} while (letter != 'Q');
	/**/

	system("pause");//����ʵ�ֶ�����Ļ�����ڹ۲�����ִ�н����
	system("CLS");//����ʵ������������������color�������Ըı����̨��ǰ��ɫ�ͱ���
	system("color 0A");// ������color�������Ըı����̨��ǰ��ɫ�ͱ�������color�����0�Ǳ���ɫ���ţ�A��ǰ��ɫ���š�
	//����ɫ�������£�
	//	0 = ��ɫ 1 = ��ɫ 2 = ��ɫ 3 = ����ɫ 4 = ��ɫ 5 = ��ɫ 6 = ��ɫ 7 = ��ɫ 8 = ��ɫ 9 = ����ɫ 
	//A = ����ɫ B = ��ǳ��ɫ C = ����ɫ D = ����ɫ E = ����ɫ F = ����ɫ

}
