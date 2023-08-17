#pragma once
#include "bezalkagol.h"

#include <string>
using namespace std;

enum Gaz { сильеогазированное, газированное, слабогазированное };

class mineral : public bezalkagol
{
	
	void setGaz(Gaz);

	int gaz;

public:
	
	virtual~mineral();
	
	mineral(const char*, double, Gaz);
	void Posto1() const {};
	string getGaz() const;
	const void GetInfo() const;
	//friend ostream& operator << (ostream&, const mineral&);
};
