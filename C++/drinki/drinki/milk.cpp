#include <iostream>
#include "milk.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

milk::milk(const char* _imy, double _a, Celnost _celnost, double _girnost) : bezalkagol(_imy, _a)
{
	setCelnost(_celnost);
	set_girnost(_girnost);
}

void milk::set_girnost(double _girnost)
{
	if (0 <= _girnost && _girnost < 10)
		this->girnost = _girnost;
	else
		throw drinksexception("Неверные данные\n");
}
double milk::get_girnost() const
{
	return girnost;
}
string CELNOST[]{ "ячменное", "пшеничное", "имбирное" };
string milk::getCelnost() const
{
	return CELNOST[celnost];
}
void milk::setCelnost(Celnost _celnost)
{
	this->celnost = _celnost;
}
const void milk::GetInfo() const
{
	cout <<"МОЛОКО: "<< "Название: " << imy << " " << "Объем: " << a << " " << getCelnost() << " " << "Жирность: "<< girnost;
}
/*std::ostream& operator<< (std::ostream& out, const milk& point)
{
	out << point.imy << " " << point.a << " " << point.getCelnost() << " " << point.girnost;
	return out;
}*/
milk::~milk() {}