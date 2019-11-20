#include<stdio.h>
#include<windows.h>
#include<string.h>

//int main()
//{
//	char arr1[] = "bit";
//	char arr2[] = { 'b','i','t'};
//	char arr3[] = { 'b','i','t','\0'};
//	printf("%s\n", arr1);
//	printf("%s\n", arr2);
//	printf("%s\n", arr3);
//	system("pause");
//	return 0;
//}
//int Fun(int n)
//{
//	n=n - 2;
//	int sum = 0;
//	sum += 3;
//	while (n)
//	{
//		n--;
//		sum += 2;
//	}
//	return sum;
//}
//int Fun2(int money,int num)
//{
//	
//	money = money - num;
//	int sum = 0;
//	sum += num+1;
//	while (money)
//	{
//		money-=(num-1);
//		sum += num;
//	}
//	return sum;
//}
//
//char*FunX(char arr1[], char arr2[],char arr3[])
//{
//	int i = 0;
//	int j = 0;
//	while (arr1[i] != '\0')
//	{
//		arr3[i] = arr1[i];
//		++i;
//	}
//	while (arr2[j] != '\0')
//	{
//		arr3[i] = arr2[j];
//		++j;
//		++i;
//	}
//	arr3[i] = '\0';
//	return arr3;
//}
//struct test
//{
//	int n;
//	char*pc;
//	short S;
//	char c[2];
//	short sb[4];
//};
//void fun(int x)
//{
//	printf("%d", x);
//}
//void(*p)(int);
// void(* fun1(int x))(int a)
//{
//	return fun1(3);
//}
//void  Strcpy(char* dest, char * src)
//{
//	dest = src;
////	printf("%s",)
//}
char* fun1()
{
	char p[] = "asasds";
	return p;
}
char* fun2()
{
	char* p = "asasds";
	return p;
}
int main()
{	//对于数组越界,C编译器；
	//用数组名加下标访问和用指针都能访问到对应地址的内容，只是：看下一行……
	//当把超出字符数组长度的位置赋值为'\0',如果用数组名下标（arr[]）时,RangeChecks 检测代码检测到超出范围的数组访问。
	//莫名把一个位置写为‘\0’……
	//sizeof在预编译时已经确定，不会因为后面字符的越界增加而改变（否则真就没办法确定数组的大小了，（数组名后面的都是数组内容了，哈哈哈））

	//char arr[] = "abcdef";
	//char*p = arr;
	//*(p + 6) = 'A';
	//*(p + 8) = '\0';
	//printf("%s", arr);



	//for (int i = 0; i < 6; i++)
	////{
	//int a[] = { 1,2,3,4 };
	//int*p = a;
	//*(p + 4) = 5;
	////printf("%d", sizeof(a) / sizeof(a[0]));//4
	//a[5] = 6;//
	//a[8] = 0;//
	//printf("%d\n",a[8]);//6;
	/*for (int i = 0; i < 10; i++)
	{
		printf("%d ", a[i]);
	}
*/

	//char arr[] = "abcdef";
	//arr[6] = 'A';//可以
	//arr[7] = '\0';//崩溃
	//printf("%s", arr);

	/*char arr[] = "abcdef";
	*(arr + 6) = 'A';
	*(arr + 7) = 'B';
	*(arr + 8) = '\0';//成功
	printf("%s",arr);//成功输出
	*///printf("%c",arr[7]);//输出A;
	

	 
/*
	int a[3][8] = { 0 };
	printf("??=\n%d", sizeof(a[0]));*/
	//printf("%d", Fun2 (20,2));

	/*char arr1[] = "AAAA";
	char arr2[] = "BBB";
	char arr3[10] = { 0 };
	printf("%s",FunX( arr1,  arr2,arr3));
	*/
//	printf("%d", sizeof(p));
	/*printf("%p\n",p);
	printf("%p\n",p+0x1);
	printf("%p\n",(unsigned long)p+0x1);
	printf("%p\n",(unsigned int*)p+0x1);*/

	//char src[] = "abcd";
	//char dest[5];
	//dest = src;//dest是常量
	//printf("%c\n",dest[0]);
	//printf("%c\n",dest[1]);
	//printf("%c\n",dest[2]);
	//printf("%c\n",dest[3]);
	//printf("%c",dest[4]);

	/*double x = 5.16894;
	printf("%f\n",(int)(x*1000+0.5)/1000.0);*/
	/*
	void(*p)(int);
	p = fun1;
	p(8);*/
	char*str = NULL;
	str = fun2();
	printf("%s", str);
	putchar('\n');
	system("pause");
	return 0;

}
