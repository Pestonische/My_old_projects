#pragma once
#include "drinks.h"
#pragma warning(disable: 4996)
using namespace std;
class bezalkagol : public drinks
{
protected:

public:
	virtual~bezalkagol();
	//friend ostream& operator << (ostream&, const bezalkagol&);
	bezalkagol(const char*, double);
	virtual const void GetInfo() const;
	virtual void Posto1() const = 0;
};
