#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include<malloc.h>
#define NAME_MAXE_SIZE 1024
#define ADERSS_MAXE_SIZE 1024
#define SEX_MAXE_SIZE 10
#define TEL_MAXE_SIZE 100
#define LEN 1024
#define SLDateType Information

typedef struct Information {
	char name[NAME_MAXE_SIZE];
//	char adress[ADERSS_MAXE_SIZE];
//	char sex[SEX_MAXE_SIZE];
//	int age;
	char tel[TEL_MAXE_SIZE];
}Information;
typedef struct List {
	SLDateType*  array;//array��Žṹ��ĵ�ַ
	size_t used;	//��Ч���ݸ���(ʹ�õ�)
	size_t capicity;
} List;
void initList(List* list, size_t capicity)
{
	list->capicity = capicity;
	list->used = 0;
	list->array = (Information*)malloc(capicity * sizeof(Information));
}
//1. �����ϵ����Ϣ
void add(List*list)
{
	printf("������");
	scanf("%s", &(list->array[list->used].name));
	printf("�绰��");
	scanf("%s", &(list->array[list->used].tel));
	list->used++;
	//char name[NAME_MAXE_SIZE];
	//char tel[TEL_MAXE_SIZE];
	//char sex[SEX_MAXE_SIZE];
	//char file_name[30] = "D:\\test.txt";
	//FILE *fp;
	//fp = fopen(file_name, "a+");
	//if (NULL == fp)
	//{
	//	printf("%s\n", strerror(errno));
	//	exit(0);
	//}
	//printf("¼����ϵ����Ϣ\n");
	//printf("����:");
	//getchar();
	//fgets(name, NAME_MAXE_SIZE, stdin);//�Ӽ��������ַ���������name������
	//fputs(name, fp);//��str���ַ��������fp��ָ�ļ���
	//printf("�Ա�:");
	//fgets(sex, SEX_MAXE_SIZE, stdin);//�Ӽ��������ַ���������name������
	//fputs(sex, fp);//��str���ַ��������fp��ָ�ļ���
	//printf("�绰:");
	//fgets(tel, TEL_MAXE_SIZE, stdin);//�Ӽ��������ַ���������name������
	//fputs(tel, fp);//��str���ַ��������fp��ָ�ļ���
	////rewind(fp); //��fp��ָ�ļ��Ķ�дλ�õ���Ϊ�ļ���ʼ��
	//while (fgets(str, MAX_SIZE, fp) != NULL)
	//{
	//	fputs(str, stdout); //���ַ����������Ļ
	//}
	//fclose(fp);
}
//3. ����ָ����ϵ����Ϣ
void Selelect(List*list)
{
	assert(list);
	char name1[NAME_MAXE_SIZE] = {0};
	printf("������Ҫ���ҵ���ϵ��������\n");
	scanf("%s", name1);
	for (size_t i = 0; i < list->used; i++)
	{
		if (strcmp(list->array[list->used].name , name1)==0)
		{
			printf("[%d] ,������%s,�绰��%s\n", i, list->array[i].name, list->array[i].tel);
		}
	}
}
//2. ɾ��ָ����ϵ����Ϣ
void del(List*list)
{
	size_t input = 0;
	printf("��ѡ��Ҫɾ�ı��");
	scanf("%d", &input);
	if (input >= 0 && input < list->used)
	{
		list->array[input] = list->array[list->used - 1];
		--list->used;
	}
	else
	{
		printf("�޴˱��\n");
	}
}
//4. �޸�ָ����ϵ����Ϣ
void update(List*list)
{
	size_t input = 0;
	printf("��ѡ��Ҫɾ�ı��");
	scanf("%d", &input);
	if (input >= 0 && input < list->used)
	{
		printf("�������޸ĺ������\n");
		scanf("%s", &list->array[input].name);
		printf("�������޸ĺ�ĵ绰\n");
		scanf("%s", &list->array[input].tel);
	}
	else
	{
		printf("�޴α��\n");
	}	
}
//5. ��ʾ������ϵ����Ϣ
void show(List*list)
{
	assert(list);
	char arr[1024] = { 0 };
	int c;
	FILE* fp = fopen("D:/test.txt", "rt");
	if (fp != NULL)
	{
		printf("--------------------------------\n");

		/**����1
			while ((c=fgetc(fp))!=EOF )
			{
				fputc(c, stdout);
				//putchar(c);
			}
			putchar('\n');
			fclose(fp);
		*/
		//����2
			fgets(arr, LEN, fp);
			fputs(arr, stdout);
			putchar('\n');
			fclose(fp);
		

		/**����3
			fread(arr, sizeof(char), LEN, fp);//��fp�ж�����¼��arr
			fwrite(arr, sizeof(char), LEN, stdout);//��fpд��stdout
			putchar('\n');
			//printf("%s\n", arr);
			fclose(fp);
		*/

	//	fprintf(stdout, "%s", list->array->name);
	//	fprintf(stdout, "%s", list->array->tel);
		//fscanf(stdout,"%s", list->array->name);
		//fscanf(stdout,"%s", list->array->tel);
		printf("--------------------------------\n");
	}
	else
	{
		printf("%s\n", strerror(errno));
	}
}
//6. ���������ϵ��
void Destory(List* list)
{
	assert(list);
}
//7. ����������������ϵ��

//8. ������ϵ�˵��ļ�
void saveAsFile(List*list)
{
	FILE* fp ;
	char file_name[30] = "D:\\test.txt";
	fp = fopen(file_name, "a+");
	if (fp != NULL)
	{
		for (size_t i = 0; i < list->used; i++)
		{
		//	fwrite(list->array+i, sizeof(Information), 1, fp);
			fputs(list->array[i].name, fp);
			fputs(list->array[i].tel, fp);
		}
		fclose(fp);
	}
	else
	{
		printf("%s\n", strerror(errno));
	}
}

//9. ������ϵ��

int showminu()
{
	printf("****************************\n");
	printf("**********1.�� *************\n");
	printf("**********2.ɾ *************\n");
	printf("**********3.�� *************\n");
	printf("**********4.�� *************\n");
	printf("**********5.show**********\n");
	printf("**********0.exit ************\n");
	printf("****************************\n");
	int input = 0;
	printf("��ѡ��");
	scanf("%d", &input);
	return input;
}
int main()
{
	typedef void(*Fun)(List*);
	List list;
	initList(&list, 300);
	Fun arr[] = { add,del,update,Selelect,show };
	while (1)
	{
		char input = showminu();
		if (input == 0)
		{
			printf("GoodBye\n");
			break;
		}
		else
		{
			arr[input - 1](&list);
		}
	}
	saveAsFile(&list);
	system("pause");
	return 0;
}