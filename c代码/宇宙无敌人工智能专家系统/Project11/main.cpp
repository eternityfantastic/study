#include "Expert.h"
#include <iostream>
using namespace std;
void main()
{
	Expert::ShowInfo();
	Expert expert;
	if (expert.initDiseaseList()) {
		expert.diagnosis();
	}
	else {
		cout << "��ʼ��ʧ�ܣ�" << endl;
	}
	system("pause");
}
