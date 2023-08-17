#pragma once
#pragma warning(disable: 4996)
using namespace std;
class drinks
{
protected:
	double a;
	const char* imy;
public:
	virtual~drinks();
	void setA(double);
	double getA() const;
	void setIMY(const char*);
	const char* getIMY() const;
	drinks(const char*, double);
	virtual const void GetInfo() const;
	//virtual friend ostream& operator << (ostream&, const drinks&);
	virtual void Posto1() const = 0;
};

