#include<stdio.h>
#include<windows.h>
int main()
{
	// �ж�1000��---2000��֮������� 
	//if(i % 400 == 0 || (i % 100 != 0 && i % 4 == 0 ))
	 
	for (int i = 1000; i <= 2000; i++)
	{
		if (i % 100 == 0)
		{
			if (i % 400 == 0)
			{
				printf("%d������  ", i);

			}
		}
		else
		{
			if (i % 4 == 0)
			{
				printf("%d������  ", i);

			}
		}
	}
	system("pause");
	return 0;
	

}