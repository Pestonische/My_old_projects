#include <iostream>
#include "pivo.h"
#include "drinksexception.h"
#include <string>

using namespace std;

pivo::pivo(const char* _imy, double _a, double _g, Serie _serie, Colour _cvet) : alkagol(_imy, _a, _g)
{
	setColour(_cvet);
	setSerie(_serie);
}
string SERIE[]{ "ячменное", "пшеничное", "имбирное" };
string pivo::getSERIE() const
{
	return SERIE[serie];
}
void pivo::setSerie(Serie _serie)
{
	this->serie = _serie;
}
string Cvet[]{ "темное", "светлое" };
string pivo::getColour() const
{
	return Cvet[cvet];
}
void pivo::setColour(Colour _colour)
{
	this->cvet = _colour;
}
const void pivo::GetInfo() const
{
	cout <<"ПИВО: "<< "Название: " << imy << " " << "Объем: " << a << " " << "Крепость: " << g << " " << getSERIE() << " " << getColour();
}
/*std::ostream& operator<< (std::ostream& out, const pivo& point)
{
out << point.imy << " " << point.a << " " << point.g << " " << point.getSERIE() << " " << point.getColour();
return out;
}*/
pivo::~pivo() {}
