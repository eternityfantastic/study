#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void GetChar()
{
	char c = getchar();//键盘一次性输入大批字符，(注意回车最后也会被录入c中)输入回车后getchar开始从stdin流中每次读入一个字符返回第一个字符,
	while (c!=EOF)
	{
		putchar(c);//一次只能输出第一个字符，但没有回车，所以看起来像一行
		c=getchar();//此时从键盘缓冲区接受剩余的字符；返回第一个字符给C
	}
}
void Fgetc()
{
	/**
		int fputc( int c, FILE *stream );将c写入stream流
		int c=int fgetc( FILE *stream );从straem流中get一个字符
	*/
	FILE*fp = fopen("D:/test.txt", "r");
	if (fp != NULL)
	{
		char c = fgetc(fp);
		while (c != EOF)
		{
			putchar(c);
			c=fgetc(fp);
		}
		putchar('\n');
		fclose(fp);
	}
	else
	{
		printf("%s\n",strerror(errno));
	}
}
void Fgets()
{	/**
		int fputs( const char *string, FILE *stream );把字符串string写入stream流
		char *fgets( char *string, int n, FILE *stream );从stream流获取n个字节，放入string中
	*/
	FILE*fp = fopen("D:/test.txt", "r");
	char arr[100] = {0};
	if (fp != NULL)
	{
		fgets(arr, 1024, fp);
		fputs(arr, stdout);
		putchar('\n');
		fclose(fp);
	}
	else
	{
		printf("%s\n", strerror(errno));
	}
}
void Fwrite()
{
	/**
		size_t fwrite( const void *buffer, size_t size, size_t count, FILE *stream );//buff写入stream流
		size_t fread( void *buffer, size_t size, size_t count, FILE *stream );//stream流读到buffer中
	*/
	FILE*fp = fopen("D:/test.txt", "r");
	if (fp != NULL)
	{
		char arr[100] = { 0 };
		fread(arr, sizeof(char), 1024, fp);
		//fwrite(arr, sizeof(char), 1024, stdout);
		puts(arr);
		putchar('\n');
		fclose(fp);
	}
	else
	{
		printf("%s\n", strerror(errno));
	}
}
/**
		int fprintf( FILE *stream, const char *format [, argument ]...);
		int sprintf( char *buffer, const char *format [, argument] ... );

		int fscanf( FILE *stream, const char *format [, argument ]... );
		int sscanf( const char *buffer, const char *format [, argument ] ... );

		int atoi( const char *string );
		char *_itoa( int value, char *string, int radix );




*/
int main()
{
	//GetChar();
	//Fgetc();
	Fgets();
	//Fwrite();
	system("pause");
	return 0;
}