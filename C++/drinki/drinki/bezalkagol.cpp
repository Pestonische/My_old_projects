#include <iostream>
#include "bezalkagol.h"

using namespace std;

bezalkagol::bezalkagol(const char* _imy, double _a) :drinks(_imy, _a) {}
const void bezalkagol::GetInfo() const
{
	cout << "Название: " << imy << " " << "Объем: " << a;
}
bezalkagol::~bezalkagol() {}
