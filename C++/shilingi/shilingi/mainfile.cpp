#include <iostream>
#include "shilingi.h"
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");

	long long   pd1=0, pd=0;
	int sh = 0, sh1 = 0;
	double  pn = 0, pn1 = 0;
	
		cout << "Введите первое количество фунтов" << endl;
		cin >> pd;
		cout << "Введите первое количество шилингов" << endl;
		cin >> sh;
		cout << "Введите первое количество пенсов" << endl;
		cin >> pn;
		cout << "Введите количество фунтов для проведения проверки" << endl;
		cin >> pd1;
		cout << "Введите количество шилинговдля проведения проверки" << endl;
		cin >> sh1;
		cout << "Введите количество пенсовдля проведения проверки" << endl;
		cin >> pn1;
	
	shilingi* g = NULL;
	
	
	shilingi* f = NULL; 
	
	
	try {
		g=new shilingi(pd, sh, pn);

		f= new shilingi(pd1, sh1, pn1);
	}
	catch (my_exception excep)
	{
		g = nullptr;
		delete g;
		f = nullptr;
		delete f;
		cout << excep.what();
	}
	
	if (g != NULL && f != NULL)
	{
		cout << *g << endl;

		try {
			cout << (*g += *f) << endl;

			cout << (*g -= *f) << endl;

			cout << (*g + *f) << endl;

			cout << (*g - *f) << endl; 

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
		catch (my_exception excep1)
		{
			g = nullptr;
			delete g;
			f = nullptr;
			delete f;
			cout << excep1.what();
		}
	}
}
