#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<windows.h>

void swap(int *num1,int *num2)
{
	int temp;
	temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}
//ѡ������
void selectSort(int arr[],int length) {
	for (int i = 0; i < length; i++){
		int max = arr[i];//j�����һ��Ϊ�����
		for (int j = i + 1; j < length; j++)//��ʣ��δ�ź���������
		{
			if (max<arr[j])
			{
				swap(&max, &arr[j]);//����max �� arr[j];
			}
		}
		arr[i] = max;//���ҵ��������������������
	}
}
void selectSort2(int a[], int len)
{
	int max ;
	for (int i = 0;  i < len;  i++)
	{
		max = a[i];
		for (int j = i; j < len; j++)
		{
			if (max < a[j])
			{
				swap(&max, &a[j]);
				/*
				 * int temp = a[j];
				 * a[j] = max;
				 * max = temp;
				 */
			}
		}
		a[i] = max;
	}
}
void selectSort3(int a[],int len)
{
	for (int i = 0; i < len; i++)
	{
		int max = a[i];
		for (int j = i+1; j < len; j++)
		{
			if (max<a[j])
			{
				swap(&a[j], &max);
			}
		}
		a[i] = max;
	}
}

//��������
//������ֳ��������δ�����������䣬�������һ��Ԫ�ص������������䣬ʣ�µļ�������δ�������䣬
//ÿ�ζ���δ�����������ҳ�һ��Ԫ�����������������е�Ԫ�رȽϣ������뵽�����������еĺ���λ�ã�
//ֱ��δ��������Ԫ��Ϊ 0 ��


void insertSort(int arr[], int length) {
	for (int i = 1; i < length; i++) {
		int insert = arr[i];//����������
		int j;
		for (j = i - 1; j >= 0&&insert >arr[j]; j--)//����������ֱ�ǰһ�����ִ�
		{
			arr[j + 1] = arr[j];		//���������ƶ��ڳ���λ��
		}
		arr[j + 1] = insert;//�����λ
	}
}
void insertSort2(int a[], int len)
{
	for (int i = 1; i < len; i++)
	{
		int insert = a[i];
		int j;
		for ( j = i-1; j >= 0; j--)
		{
			if (insert>a[j])
			{
				a[j + 1] = a[j];//jλ�ñ��ճ���
			}
			else
			{
				break;//��insertС��a[j]ʱ������Сa[j]ǰ��������������������j--��
							//����ѭ��ʱ�ͻ�ѣ�insert����a[0]λ�ã�//�㷨����
			}
		}
		//�˳�ѭ��ʱjָ��Ų�����Ŀ�λ�õ�ǰһ��λ��
		a[j + 1] = insert; 
	}

}
void insertSort3(int a[], int len)
{
	for (int i = 1; i < len; i++)
	{
		int max = a[i];
		int j;
		for ( j = i-1; j >=0; j--)
		{
			if (max > a[i])
			{
				a[j + 1] = a[j];
			}
			else
			{
				break;
			}
		}
		a[j + 1] = max;
	}
}

//
void bubbleSort(int arr[],int length)
{
	int end = length - 1;
	for (int end = length-1; end > 0; end--)
	{
		for (int i = 0; i < end; i++)
		{
			if (arr[i] < arr[i + 1])//����
			{
				swap(&arr[i], &arr[i + 1]);
			}
		}
	}
}
void bubbleSort1(int a[], int len)
{
	for (int j = 0; j < len; j++)
	{
		int i = 0;
		for ( ; i < len - 1; i++)
		{
			if (a[i] < a[i + 1])
			{
				swap(&a[i], &a[i + 1]);
			}
		}
	}
}


//print����������ӡ����
void print(int arr[],int length)
{
	for (int i = 0; i < length; i++) {
		printf("%d  ", arr[i]);
	}
}
int main()
{

	int a[] = {1,2,7,3};
	int b[] = { 1,21,3,21,33,22,0,21};
	int c[] = { 1,21,3,21,33,22,0,21};
	int length1 = sizeof(a) / sizeof(a[0]);
	int length2 = sizeof(b) / sizeof(b[0]);
	int length3 = sizeof(c) / sizeof(c[0]);

	selectSort2(a, length1);
	insertSort2(b, length2);
	bubbleSort1(c, length3);
	print(a, length1);//print����������ӡ����
	printf("\n");
	print(b, length2);//print����������ӡ����
	printf("\n");
	print(c, length3);//print����������ӡ����
	system("pause");
	return 0;
}
