#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//#include<windows.h>
#include<stdlib.h>
#include<string.h>
#include<malloc.h>
#include<assert.h>
#define SLDateType int

struct student {
	int id;
	int age;
	char name[10];
} stu1;
typedef struct Node
{
	SLDateType*p;
	int size;
	int used;
}Node;

void init(Node *node,int size)
{
	assert(node);
	node->p = (SLDateType)melloc(size*sizeof(SLDateType));
	node->size = size;
}
void addFront(Node*node, int size)
{
	assert(node);

}
int main()
{
	system("color ED");
	#if 0
	float price = 525.75;
	float sales_tax = 0.06;

	printf("The item cost is %f\n", price);//525.750000
	printf("Sales tax on the item is %f\n", price * sales_tax);

	float value = 1.23456;

	printf("%8.1f\n", value);//     1.2
	printf("%8.3f\n", value);//   1.234
	printf("%8.5f\n", value);// 1.23456
	// %g�������ʵ������������ֵ�Ĵ�С���Զ�ѡf��ʽ��e��ʽ��ѡ�����ʱռ��Ƚ�С��һ�֣���
	//�Ҳ�����������0����%g�Ǹ��ݽ���Զ�ѡ���ѧ����������һ���С��������
	printf("Displaying 0.1234 yields %g\n", 0.1234);//0.1234
	printf("Displaying 0.00001234 yields %g\n", 0.00001234);//1.234e-5

	int i;
	int result = 0;
	int value = 1;

	for (i = 0; i < 100; i++)
	{
		printf("%d ", i);
		result = value * --i;   //--i����i=i-1;Ǳ��ʶ�и�i�����i-1������ѭ����
	}

	printf("Result %d\n", result);
	int neg_int = -5;
	int pos_int = 5;

	float neg_flt = -100.23;
	float pos_flt = 100.23;

	printf("The integer values are \n%3d and %+d\n",
		neg_int, pos_int);

	printf("The floating point values are %+f %+f\n",
		neg_flt, pos_flt);



	printf("Variables of type int use %d bytes\n", sizeof(int));//4
	printf("Variables of type float use %d bytes\n", sizeof(float));//4
	printf("Variables of type double use %d bytes\n", sizeof(double));//8
	printf("Variables of type unsigned use %d bytes\n", sizeof(unsigned));//4
	printf("Variables of type long use %d bytes\n", sizeof(long int));//4

	//int c = 2;
	//printf("%d",c + --c);//��׼δ���壬���Ϊ2
	/*int i = 1;
	int ret = (++i) + (++i) + (++i);
	printf("%d", ret);*///12
	//printf("%d", sizeof( void));//error
	char letter;  // Letter typed by the user

	printf("Do you want to continue? (Y/N): ");

	letter = getch();          // Get the letter  
	letter = toupper(letter);  // Convert letter to uppercase

	while ((letter != 'Y') && (letter != 'N'))
	{
		putch(7);                  // Beep the speaker
		letter = getch();          // Get the letter  
		letter = toupper(letter);  // Convert letter to uppercase
	}
	printf("\nYour response was %c\n", letter);
	int value = 5;

	printf("%01d\n", value);//5
	printf("%02d\n", value);//05
	printf("%03d\n", value);//005
	printf("%04d\n", value);//0005


///*
//	stu1.id = 12;
//	printf("%d",stu1.id);
//	system("pause");
//	return 0;*/
	//putch();
	//putchar(1);
	//printf("����һ�б���");
	//putchar(10);//����
	//putchar(2);
	//printf("����һ������");
	//putchar(10);//����
	/*
	int i;
	char a[1000];
	for (i = 0; i< 1000; i++)
	{
		a[i] = -1 - i;
		printf("%d  ",a[i]);
	}
	printf("%d",strlen(a));
	*/
	/*unsigned char i;
	for ( i = 0; i < 256; i++)//��ѭ��
	{
		printf("%d  ",i);
	}*/
	//int a[3][4] = { 1,2,3,4,
	//					  5,6,7,8,
	//					  9,10,11 };
	//printf("%d\n",sizeof(a));						//48     ������������������
	//printf("%d\n",sizeof(a[0][0]));				//4	
	//printf("%d\n",sizeof(a[0]));					//16     4*4���ֲ���������
	//printf("%d\n",sizeof(a[0]+1));				//4      ��ַ     & a[0][1];
	//printf("%d\n",sizeof(*(a[0] + 1)));		   //4         a[0][1]
	//printf("%d\n",sizeof(a+1));				   //4       ��ַ    &a[1]
	//printf("%d\n",sizeof(*(a + 1)));			   //16     a[1]
	//printf("%d\n",sizeof(&a[0]+1));			//4		��ֵָ�룻&a[1]
	//printf("%d\n",sizeof(*(&a[0] + 1)));		//16		a[0]��ʾһά���顣&a[0]�õ���ַ��+1�õ�&a[1],������4*4
	//printf("%d\n",sizeof(*a));						//16		a[0]
	//printf("%d\n",sizeof(a[3]));					//16		a[][]
	/*int a[5] = { 1,2,3,4,5 };
	int *p = (int*)(&a + 1);
	printf("%d,%d", *(a + 1), *(p - 1));*///2 ,5
//
//	int a[4] = { 1,2,3,4 };
//	int*p1 = (int*)(&a + 1);
//	int*p2 = (int*)((int)a + 1);
//	printf("%X,%X", p1[-1],*p2);
	//int a[5][5];
	//int(*p)[4];
	//p = a;
	////printf("%p,%d\n",&p[4][2]-&a[4][2],&p[4][2]-&a[4][2]);
	//char*c[] = {"ENTER","NEW","POINT","FIRST"};
	//char** cp[] = {c+3,c+2,c+1,c};
	//char***cpp = cp;
	//printf("%s\n",**++cpp );
	//printf("%s\n",*--*++cpp+3 );
	//printf("%s\n",*cpp[-2]+3 );
	//printf("%s\n",cpp[-1][-1]+1 );
#endif
	
	system("pause");
	return 0;
}