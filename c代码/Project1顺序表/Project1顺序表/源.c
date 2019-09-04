#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<malloc.h>

typedef int SLDateType;
typedef int Size_t;
typedef struct SeqList {
	SLDateType * array;//ָ��̬���ٵĿռ�
	Size_t size;	//��Ч���ݸ���
	Size_t capicity;//�����ռ��С
} SeqList;
//��ʼ��˳���
void SeqListInit(SeqList *psl, size_t capicity)
{
	assert(psl);//����ô��a������ô�������ʾ
	psl->array = (SLDateType*)malloc(capicity * sizeof(SLDateType));
	//if (psl->array!=NULL)
	assert(psl->array);//ȷ��ָ��
	psl->capicity = capicity;//��ʼ��capital���ռ�
	psl->size = 0;

}
//����ȫ��
void SeqListDestory(SeqList*psl)
{
	assert(psl);
	if (psl->array)	  //�ж�˳����Ƿ�Ϊ��
	{
		free(psl->array);
		psl->array = NULL;
		psl->size = 0;
		psl->capicity = 0;
		/* assert(psl || psl->array);  //�ж�˳����Ƿ�Ϊ��
			free(psl->array);
			psl->array = NULL;
			psl->size = 0;
			psl->capicity = 0;   */
	}
}
//�����ض�Ԫ��
int SeqListFind(SeqList *psl, SLDateType x)
{
	for (int i = 0; i < psl->size; i++)
	{
		if (psl->array[i] == x)
		{
			return i;
		}
	}
	return -1;
}
//�Ƿ�����
void CheckCapacity(SeqList*psl)
{
	assert(psl->array);
	if (psl->size == psl->capicity)
	{
		//����

		psl->capicity *= 2;
		psl->array = (SLDateType*)realloc(psl->array, psl->capicity * sizeof(SLDateType));
		//assert(psl->array);
	}
}
//β��
void SeqListPushBack(SeqList*psl, SLDateType x)
{
	//���Ƿ����
	assert(psl->array);
	//���Ƿ��������˻Ὺ�ٿռ�
	CheckCapacity(psl);
	psl->array[psl->size] = x;
	psl->size++;
}
//ͷ��
void SeqListPushFront(SeqList*psl, SLDateType x)
{
	assert(psl);
	if (psl->array)//���鲻Ϊ��
	{
		//���鲻Ϊ��
		CheckCapacity(psl);
		//����ƶ�
		for (int i = psl->size; i > 0; i--)
		{
			psl->array[i] = psl->array[i - 1];
		}
		psl->array[0] = x;
		psl->size++;
	}
	else
	{
		SeqListInit(psl, psl->capicity);//��������
		psl->array[0] = x;
		psl->size++;
	}
}
//��ͨ����
void SeqListInsert(SeqList*psl, Size_t pos, SLDateType x)
{
	assert(psl && pos <= psl->size && pos > 0);
	for (int i = psl->size; i > pos; i--)
	{
		psl->array[i] = psl->array[i - 1];
	}
	psl->array[pos] = x;
	psl->size++;
}
//βɾ��
void SeqListPopBack(SeqList*psl)
{
	assert(psl || psl->size);
	//psl->array[psl->size-1]=?
	psl->size--;

}
//ͷɾ��
void SeqListPopFront(SeqList*psl)
{
	assert(psl || psl->array);
	for (int i = 0; i < psl->size -1; i++)
	{
		psl->array[i] = psl->array[i + 1];
	}
		psl->size--;
}
//��ͨɾ��
void SeqListErase(SeqList*psl, Size_t pos)
{//λ�úϷ���
	assert(psl && pos < psl->size && pos>0);

	for (int i = pos; i < psl->size -1; i++)
	{
		psl->array[i] = psl->array[i + 1];
	}
	psl->size--;
}
//ɾ��ָ��Ԫ��
void SeqListRemove(SeqList*psl, SLDateType x)
{
	assert(psl);
	if (SeqListFind(psl, x) != -1)
	{
		SeqListErase(psl, SeqListFind(psl, x));
	}
	else
	{
		printf("Ԫ��%d������\n", x);
	}

}
//ɾ����������xԪ��
void SeqListAll(SeqList*psl, SLDateType x)
{
	for (size_t i = 0; i < psl->size; i++)
	{
		if (psl->array[i]==x)
		{
			for (size_t j = i; j < psl->size-1; j++)
			{
				psl->array[j] = psl->array[j + 1];
			}
			psl->size--;
			--i;
		}
	}
}
//�޸�
void SeqListModify(SeqList*psl, Size_t pos, SLDateType x)
{
	assert(psl && psl->size >pos && pos>=0);
	psl->array[pos] = x;
}
//��ӡ
void SeqListPrinnt(SeqList*psl)
{
	assert(psl);
	for (int i = 0; i < psl->size; i++)
	{
		printf("%d  ", psl->array[i]);
	}
	putchar('\n');
}
int main()
{
	SeqList test;
	SeqListInit(&test, 100);
	//β�弸����
	SeqListPushBack(&test, 1);//1
	SeqListPushBack(&test, 12);//1 12
	SeqListPushBack(&test, 123);//1 12 123
	SeqListPushBack(&test, 1234);//1 12 123 1234
	////ͷ�弸����
	SeqListPushFront(&test, 5678);//5678 1 12 123 1234
	SeqListPushFront(&test, 567);//567 5678 1 12 123 1234
	SeqListPushFront(&test, 56); //56 567 5678  1 12 123 1234
	SeqListPushFront(&test, 5); //5 56 567 5678  1 12 123 1234
	////βɾ��������
	SeqListPopBack(&test);//5 56 567 5678 1 12 123
	SeqListPopBack(&test);//5 56 567 5678 1 12
	SeqListPopBack(&test);//5 56 567 5678 1
	//////ͷɾ��������
	SeqListPopFront(&test);// 56 567 5678 1 
	SeqListPopFront(&test);//567 5678 1 

	//1λ���������123
	SeqListInsert(&test, 1, 123);//567 123 5678 1
	//2λ���������1234
	SeqListInsert(&test, 2, 1234);//567 123 1234 5678 1
	//ɾ��123
	SeqListRemove(&test, 123);//567 1234 5678 1
	//ɾ��2�±�Ԫ��
	SeqListErase(&test, 2);//567 1234 1
	//2λ���������567
	SeqListInsert(&test, 2, 567);//567 1234 567 1
	SeqListInsert(&test, 2, 567);//567 1234 567 567 1
	SeqListInsert(&test, 2, 567);//567 1234 567 567 567 1
	SeqListInsert(&test, 6, 2);    //567 1234 567 567 567  1 2
	SeqListInsert(&test, 7, 3);	//567 1234 567 567 567   1 2 3
	SeqListInsert(&test, 8, 4);	//567 1234 567 567 567   1 2 3 4
	//ɾ������567	
	SeqListAll(&test, 567);//1234 1 2 3 4
	//�޸�
	SeqListModify(&test, 0, 0);
	//printf("%d", test.size);

	SeqListPrinnt(&test);
	system("pause");
	return 0;
}
