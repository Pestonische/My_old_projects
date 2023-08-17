#pragma once
#include "alkagol.h"
#include <string>
#pragma warning(disable: 4996)
using namespace std;
enum  Colour1 { красное, белое };
enum Vid { сладкое, полусладкое };

class vino : public alkagol
{
protected:
	void setVid(Vid);
	void setColour1(Colour1);

	int colour1;
	int vid;
public:
	virtual~vino();
	vino(const char*, double, double, Colour1, Vid);
	
	string getVid() const;
	
	string getColour1() const;
	void Posto1() const {};
	const void GetInfo() const;
	//friend ostream& operator << (ostream&, const vino&);
};