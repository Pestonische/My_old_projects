#include <iostream>
#include "shilingi.h"
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");

	long long   pd1=0, pd=0;
	int sh = 0, sh1 = 0;
	double  pn = 0, pn1 = 0;
	
		cout << "������� ������ ���������� ������" << endl;
		cin >> pd;
		cout << "������� ������ ���������� ��������" << endl;
		cin >> sh;
		cout << "������� ������ ���������� ������" << endl;
		cin >> pn;
		cout << "������� ���������� ������ ��� ���������� ��������" << endl;
		cin >> pd1;
		cout << "������� ���������� ����������� ���������� ��������" << endl;
		cin >> sh1;
		cout << "������� ���������� ��������� ���������� ��������" << endl;
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
			cout << "������� �����: " << (-*g) << endl;
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
