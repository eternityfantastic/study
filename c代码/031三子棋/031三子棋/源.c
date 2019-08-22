#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
void showmenu()
{
	printf("**********************************\n");
	printf("*********   1.play    ************\n");
	printf("*********   0.exit    ************\n");
	printf("**********************************\n");
}
//ʵ�ִ�ӡ���ƺ���
void Print_che(char arr[3][3], int row, int col) //��ӡ����
{
	int i, j;
	for (i = 0; i < row; i++)
	{
		//ѭ���������һ���е�Ԫ�أ�����|����
		for (j = 0; j < col; j++)
		{
			printf(" %c ", arr[i][j]);
			if (j < col - 1)
				putchar('|');
		}
		putchar('\n');
		//ѭ���������һ���е�Ԫ�أ�����|����
		for (j = 0; j < col; j++)
		{
			if (i < row - 1)
				printf("___");
			else
			{
				printf("   ");
			}
			if (j < col - 1)
				putchar('|');
		}
		putchar('\n');
	}
}

//ʵ�����Ϊ������
int Isfull(char arr[3][3])//δ������0
{
	int i;
	for (i = 0; i < 3; i++)
	{
		int j;
		for (j = 0; j < 3; j++)
		{
			if (arr[i][j] ==' ')//���ڿհ׵㣬δ��
			{
				return 0;
			}
		}
	}
	return  1;

}

//ʵ���ж����ӵ�(x,y)�Ϸ����жϺ���
int Isok(char arr[3][3], int x, int y)//�Ϸ�����1
{
	if (x >= 1 && x <= 3 && y >= 1 && y <= 3)
	{
		if (arr[x - 1][y - 1] == ' ')//���ڿհ׵�
		{
			return 1;//OK
		}
	}
	return 0;
}
//ʵ��ģ��������Ӻ���
void computer(char arr[3][3], int row, int col)
{
	while (1)
	{
		int x,y;
		//�������
		x = rand() % row + 1;//3  [0-3)   [1-3]
		y = rand() % col + 1;
		//�ж�λ�úϷ���
		if (Isok(arr, x, y) == 1)
		{
			arr[x-1][y-1] = 'o';
			break;
		}
	}
}
//ʵ��������Ӻ���
void player(char arr[3][3])
{
	//���������������λ�ã�
	while (1)
	{
		int x, y;
		printf("���������������ӵ����꣺");
		scanf("%d %d", &x, &y);
		//�ж�λ�úϷ���
		if ( Isok(arr, x, y) == 1 )
		{
			arr[x - 1][y - 1] = 'x';
			break;
		}
		else
		{
			printf("���겻�Ϸ���������\n");
		}
	}
}

char Iswin(char board[][3], int row, int col)
{
	int i = 0;
	for (i = 0; i < row; i++)
    {
		//��
		if (board[i][0] == board[i][1]
			&& board[i][1] == board[i][2]
			&& board[i][0] != ' ')
		{
			return board[i][0];
		}
		//��
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i]
			&& board[0][i] != ' ')
		{
			return board[0][i];
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
			&& board[0][0] != ' ')
		{
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]
			&& board[0][0] != ' ')
		{
			return board[0][2];
		}
		//ƽ��
		if (Isfull(board) == 1)
		{
			return 'Q';
		}
	}
	//��û��Ӯ��Ҳû��ƽ�ּ�����Ϸ
	return '0';

}
//���к����������
void referee(char  flag)
{
	if (flag == 'x')
	{
		printf("���ʤ��\n");
	}
	else if (flag == 'o')
	{
		printf("����ʤ��\n");
	}
	else if (flag == 'Q')
	{
		printf("ƽ��\n");
	}
}
//��ֳ�ʼ��Ϊ�հ׸�
void InitBoard(char board[3][3], int row, int col)
{
	int i = 0;
	for (i = 0; i < row; i++)
	{
		int j = 0;
		for (j = 0; j < col; j++)
		{
			board[i][j] = ' ';
		}
	}
	//memset(board,' ',row*col*sizeof(char));
}

void game()
{
	char flag='0';
	char arr[3][3];
	//��ʼ���հ����״̬
	InitBoard(arr, 3, 3);
	while (flag == '0')
	{
		//��ӡ��ǰ����״̬
		Print_che(arr, 3, 3);
		//�������
		player(arr);
		//��������
		computer(arr, 3, 3);
		//�ж���Ӯ
		flag = Iswin(arr, 3, 3);
	}
	//���ò��к����ж�flag�����������
	referee(flag);
}
int main()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do
	{
		showmenu();
		printf("��������Ĳ�����");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("��Ϸ�˳�\n");
			break;
		default:
			printf("��������ȷ������\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}