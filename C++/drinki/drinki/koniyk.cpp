#include <iostream>
#include "koniyk.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

koniyk::koniyk(const char* _imy, double _a, double _g, int _vidergka) : alkagol(_imy, _a, _g)
{
	setVidergka(_vidergka);
}
void koniyk::setVidergka(int _vidergka)
{
	if (0 < _vidergka)
		this->vidergka = _vidergka;
	else
		throw drinksexception("Неверные данные\n");
}

int koniyk::getVidergka() const
{
	return vidergka;
}
const void koniyk::GetInfo() const
{
	cout <<"КОНЬЯК: "<< "Название: " << imy << " " << "Объем: " << a << " " << "Крепость: " << g << " " << "Выдержка: "<< vidergka;
}
/*std::ostream& operator<< (std::ostream& out, const koniyk& point)
{
	out << point.imy << " " << point.a << " " << point.g << " " << point.vidergka;
	return out;
}*/
koniyk::~koniyk() {}