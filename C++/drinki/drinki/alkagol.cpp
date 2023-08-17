#include <iostream>
#include "alkagol.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

alkagol::alkagol(const char* _imy, double _a, double _g) :drinks(_imy, _a)
{
	setG(_g);
}

void alkagol::setG(double _g)
{
	if (_g <= 100 && _g > 0)
		this->g = _g;
	else
		throw drinksexception("Неверные данные\n");
}
double alkagol::getG() const
{
	return g;
}
const void alkagol::GetInfo() const
{
	cout << "Название: " << imy << " " << "Объем: " << a << " "  << "Крепость: " << g;
}
alkagol::~alkagol() {}
