#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<windows.h>

int method1(int arr[][3], int row, int col, int value)
{
	int ret = 0;

	// i,jΪ���Ͻ�����
	int i = 0;
	int j = col - 1;
	while (i < row && j >= 0)
	{
		if (value == arr[i][j])//�ҵ���
		{
			ret = 1;
			break;
		}
		else if (arr[i][j] > value)//���ϽǴ�������
		{
			--j;
		}
		else//���Ͻ�С������������һ��
		{
			++i;
		}
	}
	return ret;
}
int method2(int a[][3], int row, int col, int **returnrow, int **returncol, int key)
{
	int i = 0;
	int j = col-1;
		while ((i>=0&&i<=row-1)&&(j >= 0 && j <= col - 1))
		{
			if (a[i][j] == key)
			{
				printf("�ҵ���");
				/**returnrow =i;  
				*returncol = j;*/
				/*returnrow = &i;  ��ʱָ���ں�����������������ڽ��������ܸı�������������ֵ��
				returncol = &j;*/
				*returnrow = &i;  
				*returncol = &j;
				break;
			}
			else if (a[i][j] < key)
			{
				i++;//����һ��
			}
			else if (a[i][j] > key)
			{
				j--;
			}
		}
		//�ж�һ������ı�û�иı��˷���1���򷵻���
		if (true)
		{

		}
}

int main()
{
	//t1();
	int arr[][3] =
	{
		{1,2,3},
		{4,5,6},
		{7,8,9}
	};
		int key = 5;
	/*int a = 0;
		int b = 0;*/
		int returnrow;
		int returncol;
		int *returnrow1=NULL;
		int *returncol1=NULL;
		int **returnrow2 = NULL;
		int **returncol2= NULL;

		method2(arr, 3, 3, &returnrow1, &returncol1, key);
		returncol2 = &returncol1;
		returnrow2 = &returnrow1;

	//if (method1(arr, 3, 3, 1))//�ҵ���
	//{
	//	printf("1\n");
	//}
	//else
	//{
	//	printf("0\n");
	//}
	printf("%d��������(%d,%d)\n", key, **returnrow2, **returncol2);
	system("pause");
	return 0;
}

