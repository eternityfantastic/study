#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void GetChar()
{
	char c = getchar();//����һ������������ַ���(ע��س����Ҳ�ᱻ¼��c��)����س���getchar��ʼ��stdin����ÿ�ζ���һ���ַ����ص�һ���ַ�,
	while (c!=EOF)
	{
		putchar(c);//һ��ֻ�������һ���ַ�����û�лس������Կ�������һ��
		c=getchar();//��ʱ�Ӽ��̻���������ʣ����ַ������ص�һ���ַ���C
	}
}
void Fgetc()
{
	/**
		int fputc( int c, FILE *stream );��cд��stream��
		int c=int fgetc( FILE *stream );��straem����getһ���ַ�
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
		int fputs( const char *string, FILE *stream );���ַ���stringд��stream��
		char *fgets( char *string, int n, FILE *stream );��stream����ȡn���ֽڣ�����string��
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
		size_t fwrite( const void *buffer, size_t size, size_t count, FILE *stream );//buffд��stream��
		size_t fread( void *buffer, size_t size, size_t count, FILE *stream );//stream������buffer��
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