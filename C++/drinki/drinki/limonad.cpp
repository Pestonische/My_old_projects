#include <iostream>
#include "limonad.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

limonad::limonad(const char* _imy, double _a, int _sok) : bezalkagol(_imy, _a)
{
	set_sok(_sok);
}

void limonad::set_sok(int _sok)
{
	if (0 <= _sok && _sok <= 100)
		this->sok = _sok;
	else
		throw drinksexception("Неверные данные\n");

}

int limonad::get_sok() const
{
	return sok;
}

const void limonad ::GetInfo() const
{
	cout <<"ЛИМОНАД: "<< "Название: " << imy << " " << "Объем: " << a << " " << "Процент содержания сока: "<< sok;
}
/*std::ostream& operator<< (std::ostream& out, const limonad& point)
{
	out << point.imy << " " << point.a << " " << point.sok;
	return out;
}*/
limonad::~limonad() {}
