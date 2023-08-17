#pragma once
#include "drinks.h"
#pragma warning(disable: 4996)
using namespace std;
class alkagol : public drinks
{
protected:
	double g;

public:
	virtual~alkagol();


	void setG(double);
	double getG() const;
	//friend ostream& operator << (ostream&, const alkagol&);
	alkagol(const char*, double, double);
	virtual const void GetInfo() const;
	virtual void Posto1() const = 0;
};

