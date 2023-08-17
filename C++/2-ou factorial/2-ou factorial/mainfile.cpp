#include <iostream>
#include <cmath>
#include <ctime>
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");
	
	long double e;

	cout << "Введите точность вычеслений: ";

	cin >> e;

	cout << endl;

	srand((int)time(NULL));

	long double x=0.0;
	
	
	x = (((double)rand())/5 / 10000) - (1.0);

	

	cout <<"Значение х: "<< x << endl;

	long double a0 = x,  a=0.0, sum = 0.0, n = 0.0;

	sum = x;

	for(;;)
	{
		a = (2 * n + 2.0) * pow(2 * n + 1, 2) * pow(x, 2) / (4 * pow(n + 1, 2) * (2 * n + 3.0));

		n++;

		if (abs(a0) <= e)
		{
			break;
		}

		a0 *= a;

		sum += a0;
	}
	cout <<"Значение из формулы: "<< sum << endl;

	cout <<"Значение arcsin(x): "<<asin(x) << endl;
}