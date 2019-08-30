#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define Cols 9
#define Rows 9
//��ӡ�˵�
void showmenu()
{
	printf("************************************\n");
	printf("************1.play******************\n");
	printf("************0. exit******************\n");
	printf("************************************\n");
}
//��ʼ���ױ�ȫ������
void initnime(char mine[][Rows])
{
	for (int i = 0; i <= Cols; i++)
	{
		for (int j = 0; j <= Rows; j++)
		{
			mine[i][j] = '0';
		}
	}
}
//�����ױ�
void designmine(char mine[][Rows], int minenum)
{
	int count = 0;
	while (count < minenum)
	{
		int x = rand() % Cols + 1;
		int y = rand() % Rows + 1;
		mine[x][y] = '1';
		count++;
	}
}
//��ʼ��������Ϣ��ȫ��ʾΪ*
void initmineInfo(char mineinfo[][Rows])
{
	for (int i = 0; i <= Cols; i++)
	{
		for (int j = 0; j <= Rows; j++)
		{
			mineinfo[i][j] = '*';
		}
	}
}
//��ӡ������������꣩���������Ϣ��
void showmineinfo(char mineinfo[][Rows])
{
	for (int i = 0; i <= Rows; i++)
	{
		printf("%d ", i);
	}
	putchar('\n');
	for (int i = 1; i <= Rows; i++)
	{
		printf("%d ", i);
		for (int j = 1; j <= Cols; j++)
		{
			printf("%c ", mineinfo[i][j]);
		}
		putchar('\n');
	}
}
void showmine(char mine[][Rows])
{
	for (int i = 0; i <= Rows; i++)
	{
		printf("%d ", i);
	}
	putchar('\n');
	for (int i = 1; i <= Rows; i++)
	{
		printf("%d ", i);
		for (int j = 1; j <= Cols; j++)
		{
			printf("%c ", mine[i][j]);
		}
		putchar('\n');
	}
}
void calculate(char mineinfo[][Rows], char mine[][Rows], int x, int y,int* count)
{
	mineinfo[x][y] = mine[x - 1][y - 1] + mine[x - 1][y] + mine[x - 1][y + 1] + mine[x][y - 1] +
		mine[x][y + 1] + mine[x + 1][y - 1] + mine[x + 1][y] + mine[x + 1][y - 1] - 8 * '0' + '0';
	if (mineinfo[x][y] == '0')
	{
		calculate(mineinfo, mine, x - 1, y - 1,count);
		calculate(mineinfo, mine, x - 1, y,count);
		calculate(mineinfo, mine, x - 1, y + 1,count);
		calculate(mineinfo, mine, x, y - 1,count);
		calculate(mineinfo, mine, x, y + 1,count);
		calculate(mineinfo, mine, x + 1, y - 1,count);
		calculate(mineinfo, mine, x + 1, y,count);
		calculate(mineinfo, mine, x + 1, y + 1,count);
	}
	else
	{		//չʾ��λ��
		*count++;
		showmineinfo(mineinfo);
		return;
	}
}
//
void game()
{
	int x;
	int y;
	int count = 0;
	char mine[Cols][Rows];
	char mineinfo[Cols][Rows];
	int minenum = 10;
	//��ʼ���ױ�
	initnime(mine);
	//����ױ�������������λ��
	designmine(mine, minenum);
	//��ʼ����Ϣ��Ϊ*
	initmineInfo(mineinfo);
	//
	showmineinfo(mineinfo);
	do
	{
		printf("����������\n");
		scanf("%d%d", &x, &y);
	} while (x < 0 && x >= Cols && y < 0 && y >= Rows);//����Ϸ����ж�,�Ƿ������������
	//�Ƿ����
	if (mine[x][y] == '1')
	{//�״β��׽����ƿ���
		mine[x][y] = '0';
		int x1;
		int y1;
		do
		{
			x1 = rand() % Cols + 1;
			y1 = rand() % Rows + 1;
			mine[x1][y1] = '1';
		} while (mine[x1][y1] == '1');
	}
	else
	{//������Χ����
		calculate(mineinfo, mine, x, y,&count);
		/*mineinfo[x][y] = mine[x - 1][y - 1] + mine[x - 1][y] + mine[x - 1][y + 1] + mine[x][y - 1] +
			mine[x][y + 1] + mine[x + 1][y - 1] + mine[x + 1][y] + mine[x + 1][y - 1] - 8 * '0' + '0';*/
			//չʾ��Χ������Ϣ��
			//mineinfo[x][y]=result+
		showmineinfo(mineinfo);
		count++;
	}

	do
	{
		do
		{
			printf("����������\n");
			scanf("%d%d", &x, &y);
		} while (x < 0 && x >= Cols && y < 0 && y >= Rows);//����Ϸ����ж�,�Ƿ������������
		//�Ƿ����
		if (mine[x][y] == '1')
		{
			printf("ը����\n");
			showmine(mine);
		}
		else
		{//������Χ����
		    //	calculate(mineinfo, mine, x, y);
			//չʾ��Χ������Ϣ��
			//mineinfo[x][y]=result+
			calculate(mineinfo, mine, x, y,&count);
		}
	} while (count = (Cols - 1)*(Rows - 1) - minenum);//������
		if (count == (Cols - 1)*(Rows - 1) - minenum)
		{
			printf("ʤ��");
		}
	}
	int main()
	{
		/*char mine[Cols][Rows];
		int mineInfo[Cols][Rows];*/
		int input = 0;
		srand((unsigned int)time(NULL));
		do
		{
			showmenu();
			scanf("%d", &input);
			switch (input)
			{
			case 1:
				game();
				break;
			case 0:
				printf("�˳��ɹ�");
				break;
			default:
				break;
			}
		} while (input);
		system("pause");
		return 0;
	}
