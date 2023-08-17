#include <iostream>
#include "drinks.h"
#include <exception>
#include "drinksexception.h"
using namespace std;

drinks::drinks(const char* _imy, double _a)
{
	setA(_a);
	setIMY(_imy);
}

void drinks::setA(double _a)
{
	if (_a >= 0)
		this->a = _a;
	else
		throw drinksexception("Неверные данные\n");
}
void drinks::setIMY(const char* _imp)
{
	this->imy = _imp;
}
double drinks::getA() const
{
	return a;
}
const char* drinks::getIMY() const
{
	return imy;
}
const void drinks::GetInfo() const
{
	cout << "Название: " << imy << " " << "Объем: " << a;
}
/*std::ostream& operator<< (std::ostream& out, const drinks& point)
{
	out << point.imy << " " << point.a ;
	return out;
}*/
drinks::~drinks()
{
	delete[] imy;
}

