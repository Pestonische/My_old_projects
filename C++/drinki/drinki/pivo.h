#pragma once
#include "alkagol.h"
#include <string>
#pragma warning(disable: 4996)
using namespace std;


enum Colour { ������, ������� };
enum Serie { ��������, ���������, �������� };
class pivo :public alkagol
{
protected:

	
	void setSerie(Serie);
	void setColour(Colour);
	
	int serie;
	int cvet;

public:
	
	virtual~pivo();
	
	pivo(const char*, double, double, Serie, Colour);
	
	string getSERIE() const;
	string getColour() const;
	
	void Posto1() const {};
	const void GetInfo() const;
	//friend ostream& operator << (ostream&, const pivo&);
};

