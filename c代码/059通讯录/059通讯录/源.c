#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include<malloc.h>
#define SLDateType Information
/*ʵ��һ��ͨѶ¼��
ͨѶ¼���������洢1000���˵���Ϣ
*/
//typedef struct Information {
//	char name[1024];
//	char adress[1024];
//	char sex[3];
//	size_t age;
//	char tel[11];
//}Information;
typedef struct Information {
	char* name;
	char* adress;
	char* sex;
	char* age;
	char* tel;
}Information;
typedef struct List {
	SLDateType ** array;//ָ��̬���ٵĿռ䣬����array��Žṹ��ĵ�ַ
	size_t used;	//��Ч���ݸ���(ʹ�õ�)
	size_t capicity;//�����ռ��С
} List;

void initList(List* list,size_t capicity)
{
	list->capicity = capicity;
	list->used = 0;
	list->array = (Information**)malloc(capicity * sizeof(Information*));
}
//1. �����ϵ����Ϣ
List* add(List* list, Information* x)
{
	assert(list&&x);
	if (list->used < list->capicity)
	{
		list->array[list->used] = x;
		list->used++;
		return list;
	}
	else
	{
		//���ݣ������
		return list;
	}
}
//3. ����ָ����ϵ����Ϣ(�����±�)
int Selelect(List*list, Information*x)
{
	assert(list&&x);
	for (size_t i = 0; i < list->used; i++)
	{
		if (list->array[i]->name == x->name)//(����name������)//�ַ�����������ֻ��ȡ�����Ե�ַӦ��һ��
		{
			return i;
		}
	}
		return -1;
}
//2. ɾ��ָ����ϵ����Ϣ
List* del(List* list, Information*x)
{
	assert(list&&x);
	//����
	int index = Selelect(list, x);
		if (index!=-1)
		{
			//ɾ�����������ǰǨ�Ƹ��ǵ���
			list->used--;//1
			for (size_t  j = index; j < list->used; j++)
			{
				list->array[j] = list->array[j + 1];
			}
			//�粻����Selsct������ѭ���������˴�break��ɾ����һ��;����del���з��������
		}
	return list;
}
//4. �޸�ָ����ϵ����Ϣ
List* Change(List*list, Information*x)
{
	assert(list&&x);
	//����
	int index = Selelect(list, x);
	if (index != -1)
	{
		list->array[index]->adress = x->adress;
		list->array[index]->age = x->age;
		list->array[index]->tel = x->tel;
		list->array[index]->sex = x->sex;
		//list->array[index] = x;
	}
	return list;

}
//5. ��ʾ������ϵ����Ϣ
void show(List*list)
{
	assert(list);
	printf("����%d������\n",list->used);
	printf("--------------------------------\n");
	for (size_t i = 0; i < list->used; i++)
	{
		printf("����:%s\n", list->array[i] ->name);
		printf("�Ա�:%s\n",  list->array[i] ->sex);
		printf("����:%s\n", list->array[i] ->age);
		printf("�绰:%s\n", list->array[i] ->tel);
		printf("��ַ:%s\n",list->array[i]->adress);
		printf("--------------------------------\n");
	}
}
//6. ���������ϵ��
void Destory(List* list)
{
	assert(list);
	if (list->array)	  //�Ƿ�Ϊ��
	{
		free(list->array);
		list->array = NULL;
		list->used = 0;
		list->capicity = 0;
	}
}
//7. ����������������ϵ��


//8. ������ϵ�˵��ļ�
void saveAsFile(List*list)
{
	FILE* fp = fopen("D:\test.TXT", "wt+");
	if (fp != NULL)
	{
		for (size_t i = 0; i < list->used; i++)
		{
			fwrite(&list->array[i]->name, sizeof(Information), 1, fp);
		}
		fclose(fp);
	}
	else
	{
		printf("%s", strerror(errno));
	}
}
//9. ������ϵ��

int main()
{
	List *list=(List*)malloc(sizeof(List));
	Information* x=(Information*)malloc(sizeof(Information));
	x->adress = "����";
	x->age=19;
	x->name="С��";
	x->sex="��";
	x->tel="11133332222";

	Information* y = (Information*)malloc(sizeof(Information));
	y->adress = "����";
	y->age = 18;
	y->name = "С��";
	y->sex = "Ů";
	y->tel = "11122223333";

	/**
		char* name;
	char* adress;
	char* sex;
	size_t age;
	char* tel;
	*/
	Information x1={ "С��","����","��","18","12233334444" };
	Information x2={ "СǮ","�Ϻ�","Ů","18","13344445555" };
	Information x3={ "С��","����","��","18","14455556666" };
	Information x4={ "С��","����","Ů","18","15566667777" };
	Information x5={ "С��","����","��","18","16677778888" };
	Information x6={ "С��","�Ĵ�","Ů","18","17788889999" };
	Information x7={ "С֣","����","��","18","18899990000" };
	Information x8={ "С��","����","Ů","18","10011112222" };

	initList(list,100);
	add(list, &x1);
	add(list, &x2);
	add(list, &x3);
	add(list, &x4);
	add(list, &x5);
	add(list, &x6);
	add(list, &x7);
	add(list, &x8);
	del(list, &x1);
	show(list);
	saveAsFile(list);
	system("pause");
	return 0;
}