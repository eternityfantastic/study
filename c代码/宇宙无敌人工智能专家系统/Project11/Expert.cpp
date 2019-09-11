#include "Expert.h"
#include <iostream>
#include <algorithm>
#include <fstream>
using namespace std;
//��ʾ��Ϣ
void Expert::ShowInfo()
{
	cout << "************************************************" << endl;
	cout << "                �������ר��ϵͳ                " << endl;
	cout << "              by 16060104117 ����              " << endl;
	cout << "************************************************" << endl;
}
//��ʼ�������б������Ƿ��ʼ���ɹ�
bool Expert::initDiseaseList()
{
	__try {
		return readFile();
	}
	__except (true) {
		cout << "֪ʶ���ļ�(Disease.txt)��������" << endl;
		return false;
	}
}
//��ȡDisease.txt�ļ�����ȡ������Ϣ
bool Expert::readFile()
{
	fstream ioFile;
	ioFile.open("Disease.txt", fstream::in);
	if (!ioFile.is_open()) {
		cout << "�޷���֪ʶ���ļ�(Disease.txt)��" << endl;
		return false;
	}
	Disease *pDisease = NULL;
	while (!ioFile.eof()) {
		string strInput;
		ioFile >> strInput;
		if (strInput.size() == 0)
			continue;
		if (strInput.front() == '[' && strInput.back() == ']') {
			//��[]�������Ǽ�������
			strInput = strInput.substr(1, strInput.size() - 2);
			pDisease = addDisease(strInput);
		}
		else {
			//�������֢״����
			addSymptom(pDisease, strInput);
		}
	}
	ioFile.close();
	return true;
}
//���һ�����������ش˼�����Ϣ��ָ��
Disease* Expert::addDisease(const string &name)
{
	Disease disease;
	disease.name = name;
	m_DiseaseList.push_back(disease);
	return &m_DiseaseList.back();
}
//��Ӽ�����֢״
void Expert::addSymptom(Disease *disease, const string &symptom)
{
	disease->symptomList.push_back(symptom);
}
//��Ϻ���
void Expert::diagnosis()
{
	//�û�����ĵ�һ��֢״
	string symptomInput;
	//�û��е�֢״��û�е�֢״
	vector<string> symptomHave, symptomNotHave;
	//�����Ľ���б�
	vector<Disease*> findList;
	cout << "��֢״ѯ�ʡ�" << endl;
	cout << endl << "->������֢״: ����\"��ȷ��\"�Կ�ʼģ��������" << endl;
	cin >> symptomInput;
	if (symptomInput == "��ȷ��") {
		//������м�����findList�б���
		for (unsigned int i = 0; i < m_DiseaseList.size(); ++i) {
			findList.push_back(&m_DiseaseList[i]);
		}
	}
	else {
		//����д�֢״�ļ�����findList�б���
		for (unsigned int i = 0; i < m_DiseaseList.size(); ++i) {
			Disease *pDisease = &m_DiseaseList[i];
			for (unsigned int j = 0; j < pDisease->symptomList.size(); ++j) {
				if (symptomInput == pDisease->symptomList[j]) {
					findList.push_back(pDisease);
				}
			}
		}
		//��������֢״��symptomHave�б���
		symptomHave.push_back(symptomInput);
	}
	for (vector<Disease*>::iterator ite = findList.begin(); ite != findList.end();) {
		bool remove = false;//�Ƿ��findList�б����ų�������
		for (unsigned int j = 0; j < (*ite)->symptomList.size(); ++j) {
			Disease *pDisease = *ite;
			if (find(symptomNotHave.begin(), symptomNotHave.end(), pDisease->symptomList[j]) != symptomNotHave.end()) {
				//��symptomNotHave�б����ҵ���֢״��ֱ���ų�
				remove = true;
				break;
			}
			else if (find(symptomHave.begin(), symptomHave.end(), pDisease->symptomList[j]) == symptomHave.end()) {
				//��symptomHave��symptomNotHave�б��в��������֢״����ѯ��
				if (optionSelect("->�Ƿ���֢״\"" + pDisease->symptomList[j] + "\"?\n(y/n): ")) {
					//ѯ�ʵ�֪�д�֢״�����֢״��symptomHave�б���
					symptomHave.push_back(pDisease->symptomList[j]);
				}
				else {
					//ѯ�ʵ�֪û�д�֢״�����֢״��symptomNotHave�б��У����ų��˼���
					symptomNotHave.push_back(pDisease->symptomList[j]);
					remove = true;
					break;
				}
			}
		}
		if (remove) {
			//��Ҫ�ų��˼���
			ite = findList.erase(ite);
		}
		else {
			//����������
			++ite;
		}
	}
	cout << endl << "��������ϡ�" << endl;
	if (findList.size() == 0) {
		cout << endl << "->֪ʶ����δ�ҵ�ƥ��ļ�¼��" << endl;
	}
	else {
		cout << endl << "->�������е�֪ʶ�⣬���ܵļ���Ϊ��" << endl;
		//�������б�
		for (unsigned int i = 0; i < findList.size(); ++i) {
			cout << findList[i]->name;
			if (i != findList.size() - 1)
				cout << ", ";
			if ((i + 1) % 5 == 0)
				cout << endl;//5������
		}
		cout << endl;
	}
	cout << endl << "����Ͻ�����" << endl << endl;
}
//��ʾ�û�ѡ��Y��N
bool Expert::optionSelect(const string &question)
{
	cout << endl << question;
	char option;
	cin >> option;
	switch (option) {
	case 'Y':
	case 'y':
		return true;
	case 'N':
	case 'n':
		return false;
	}
	return false;
}

