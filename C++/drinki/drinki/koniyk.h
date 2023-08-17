#pragma once
#include "alkagol.h"
#pragma warning(disable: 4996)
using namespace std;
class koniyk : public alkagol
{
protected:

	int vidergka;

public:
	virtual~koniyk();

	void setVidergka(int);
	int getVidergka() const;
	void Posto1() const {};
	koniyk(const char*, double, double, int);
	const void GetInfo() const;
	//friend ostream& operator << (ostream&, const koniyk&);
};

