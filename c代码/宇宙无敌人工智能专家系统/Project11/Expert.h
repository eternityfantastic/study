#pragma once
#include <string>
#include <vector>
using namespace std;
//������Ϣ����
typedef struct
{
	string name;
	vector<string> symptomList;
} Disease;
//�������ר��ϵͳ
class Expert
{
protected:
	vector<Disease> m_DiseaseList;//�����б�
	bool readFile();//��ȡ�ļ�
	bool optionSelect(const string &question);//��ʾ�û�ѡ��
public:
	static void ShowInfo();//��ʾ��Ϣ
	bool initDiseaseList();//��ʼ�������б�
	Disease* addDisease(const string &name);//��Ӽ���
	void addSymptom(Disease *disease, const string &symptom);//��Ӽ�����֢״
	void diagnosis();//���
};
