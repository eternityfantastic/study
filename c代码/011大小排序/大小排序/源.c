#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<windows.h>
//ѡ������
void selectSort(int arr[],int length) {
	for (int i = 0; i < length; i++){
		int max = arr[i];//j�����һ��Ϊ�����
		for (int j = i + 1; j < length; j++)//��ʣ��δ�ź���������
		{
			if (max<arr[j])
			{
				//swap(&max, &arr[j]);//����max �� arr[j];
				int temp = max;
				max = arr[j];
				arr[j] = temp;
			}
		}
		arr[i] = max;//���ҵ��������������������
	}
}
//��������
//������ֳ��������δ�����������䣬�������һ��Ԫ�ص������������䣬ʣ�µļ�������δ�������䣬
//ÿ�ζ���δ�����������ҳ�һ��Ԫ�����������������е�Ԫ�رȽϣ������뵽�����������еĺ���λ�ã�
//ֱ��δ��������Ԫ��Ϊ 0 ��

void insertSort(int arr[], int length) {
	for (int i = 1; i < length; i++) {
		int insert = arr[i];
		int j;
		for (j = i - 1; j >= 0&&insert >arr[j]; j--)
		{
			arr[j + 1] = arr[j];
		}
		arr[j + 1] = insert;
	}
}

//void swap(int *num1,int *num2)
//{
//	int temp;
//	temp = *num1;
//	*num1 = *num2;
//	*num2 = temp;
//}

//print����������ӡ����
void print(int arr[],int length)
{
	for (int i = 0; i < length; i++) {
		printf("%d  ", arr[i]);
	}
}
int main()
{

	int a[3] = {1,2,3};
	int b[9] = { 1,21,3,21,33,22,0,21};
	int length1 = sizeof(a) / sizeof(a[0]);
	int length2 = sizeof(b) / sizeof(b[0]);
	selectSort(a, length1);
	insertSort(b, length2);
	print(a, length1);//print����������ӡ����
	printf("\n");
	print(b, length2);//print����������ӡ����
	system("pause");


}
