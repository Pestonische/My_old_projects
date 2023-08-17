#include <iostream>
using namespace std;
#include "drobi.h"
int main()
{
	setlocale(LC_ALL, "rus");
	//cout << "Введите чеслитель и знаменатель" << endl;
	drobi* g = nullptr;
	drobi* f = nullptr;
	long p, q, o, n;
	for (;;) 
	{
		try
		{
			cout << "Введите чеслитель и знаменатель" << endl;
			cin >> p >> q;
			g = new drobi(p, q);
			cout << "Введите чеслитель и знаменатель для проверки" << endl;
			cin >> o >> n;
			f = new drobi(o, n);
		}
		catch (const my_exception & e)
		{
			g = nullptr;
			delete g;
			f = nullptr;
			delete f;
			cout << e.what();
			continue;
		}
		break;
	}
	
	cout << "Сокращенный первый чеслитель: " << g->getP() << endl;
	cout << "Сокращенный первый знаменатель: " << g->getQ() << endl;
	cout << "Сокращенный второй чеслитель: " << f->getP() << endl;
	cout << "Сокращенный второй знаменатель: " << f->getQ() << endl;
	cout << "Сокращение дроби g :" << g->getdrobi() << endl;
	cout << "Сокращение дроби f :" << f->getdrobi() << endl;
	cout << "Сумма g и f :" << *g + *f << endl;
	cout << "Разность g и f : " << *g - *f << endl;
	cout << "Умножение g на f : " << *g * *f << endl;
	cout << "Деление g / f = ";

	try
	{
		cout << *g / *f << endl;
	}
	catch (const my_exception & e)
	{
		g = nullptr;
		delete g;
		f = nullptr;
		delete f;

		cout << e.what();
		
	}
	if (*g == *f)
	{
		cout << "g = f" << endl;
	}
	if (*g != *f)
	{
		cout << "g != f" << endl;
	}
	if (*g <= *f)
	{
		cout << "g <= f" << endl;
	}
	if (*g >= *f)
	{
		cout << "g >= f" << endl;
	}
	if (*g > * f)
	{
		cout << "g > f" << endl;
	}
	if (*g < *f)
	{
		cout << "g < f" << endl;
	}
	cout << "Унарный минус: " << (-*g) << endl;


}