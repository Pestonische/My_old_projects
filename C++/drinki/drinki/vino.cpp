#include <iostream>
#include "vino.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

vino::vino(const char* _imy, double _a, double _g, Colour1 _colour1, Vid _vid) : alkagol(_imy, _a, _g)
{
	setColour1(_colour1);
	setVid(_vid);
}

string VID[]{ "сладкое", "полусладкое" };
string vino::getVid() const
{
	return VID[vid];
}
void vino::setVid(Vid _serie)
{
	this->vid = _serie;
}
string COLOUR1[]{ "красное", "белое" };
string vino::getColour1() const
{
	return COLOUR1[colour1];
}
void vino::setColour1(Colour1 _colour1)
{
	this->colour1 = _colour1;
}
const void vino::GetInfo() const
{
	cout <<"ВИНО: "<< "Название: "<< imy << " "<<"Объем: " << a << " " << "Крепость: "<< g << " " << getColour1() << " " << getVid();
}
/*std::ostream& operator<< (std::ostream& out, const vino& point)
{
	out << point.imy << " " << point.a << " " << point.g << " " << point.getColour1() << " " << point.getVid();
	return out;
}*/
vino::~vino() {}