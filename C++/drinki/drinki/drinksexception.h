#pragma once
#include <exception>
#pragma warning(disable: 4996)
using namespace std;

class drinksexception : public exception
{
public:
	drinksexception(const char* const message)
		: exception(message) {}
	drinksexception(const drinksexception& right)
		: exception(right) {}
};


