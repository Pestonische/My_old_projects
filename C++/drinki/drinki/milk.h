#pragma once
#include "bezalkagol.h"
#include <string>
#pragma warning(disable: 4996)
using namespace std;

enum Celnost { цельное, нормализованное };

class milk : public bezalkagol
{
protected:

	void setCelnost(Celnost);

	int celnost;
	double girnost;

public:
	
	virtual~milk();
	milk(const char*, double, Celnost,double );
	
	string getCelnost() const;
	void set_girnost(double);
	double get_girnost() const;
	void Posto1() const {};
	const void GetInfo() const;
	//friend ostream& operator << (ostream&, const milk&);
};
