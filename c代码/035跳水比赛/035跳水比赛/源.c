#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
/*5λ�˶�Ա�μ���10��̨��ˮ����������������Ԥ�������� 
Aѡ��˵��B�ڶ����ҵ����� 10 a=b=~e=~d=c
Bѡ��˵���ҵڶ���E���ģ� 10 c=~d
Cѡ��˵���ҵ�һ��D�ڶ���    d=~a
Dѡ��˵��C����ҵ����� 
Eѡ��˵���ҵ��ģ�A��һ�� 
����������ÿλѡ�ֶ�˵����һ�룬����ȷ�����������Ρ� 
*/
void method()
{ 
	int a, b, c, d, e;
	for ( a = 1; a < 6; a++)
	{
		for ( b = 1; b < 6; b++)
		{
			for ( c = 1; c < 6; c++)
			{
				for ( d = 1; d < 6; d++)
				{
					for ( e = 1; e < 6; e++)//10
					{
						if ( a*b*c*d*e==120)
						{ 
							if ((2 == b && 3 != a) +(2 != b && 3 == a) == 1)
							{
								if ((2 == b && 4 != e) + (2 != b && 4 == e) == 1)
								{
									if ((1 == c && 2 != d) + (1 != c && 2 == d) == 1)
									{
										if ((5 == c && 3 != d) + (5 != c && 3 == d) == 1)
										{
											if ((4 == e && 1 != a) + (4 != e && 1 == a) == 1)
											{
												printf("a= %d, b= %d,c= %d,d= %d,e= %d\n", a, b, c, d, e);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
		
}
int main()
{
	method();
	system("pause");
	return 0;
}