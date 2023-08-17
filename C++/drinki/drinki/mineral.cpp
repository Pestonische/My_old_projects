#include <iostream>
#include "mineral.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

mineral::mineral(const char* _imy, double _a, Gaz _gaz) : bezalkagol(_imy, _a)
{
	setGaz(_gaz);
}
string GAZ[]{ "сильеогазированное", "газированное", "слабогазированное" };
string mineral::getGaz() const
{
	return GAZ[gaz];
}
void mineral::setGaz(Gaz _gaz)
{
	this->gaz = _gaz;
}
const void mineral::GetInfo() const
{
	cout <<"МИНЕРАЛКА: "<< "Название: " << imy << " " << "Объем: " << a << " " << getGaz();
}
/*std::ostream& operator<< (std::ostream& out, const mineral& point)
{
	out << point.imy << " " << point.a << " " << point.getGaz();
	return out;
}*/
mineral::~mineral() {}
