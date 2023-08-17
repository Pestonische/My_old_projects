#pragma once
#include "bezalkagol.h"
#pragma warning(disable: 4996)
using namespace std;
class limonad : public bezalkagol
{
protected:

	int sok;

public:
	virtual~limonad();
	limonad(const char*, double, int);
	void set_sok(int);
	void Posto1() const {};
	int get_sok() const;
	const void GetInfo() const;
	//friend ostream& operator << (ostream&, const limonad&);
};