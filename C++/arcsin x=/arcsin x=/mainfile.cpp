#include <iostream>
#include <cmath>
using namespace std;

double f(double x)
{
	return (x * x - 1) * pow(10, -2 * x);
}

int main()
{
	double  b=0.5,a=0,eps;
	cin >> eps;
	double I = eps+1, I1 = 0.0,I2=0.0;

	for (double N = 2.0; (abs((I1 - I) / 15) > eps); N *= 2.0)
	{
		double  h, sum2 = 0.0, sum4 = 0.0, sum = 0.0,sum1=0.0;

		h = (b - a) / (2.0 * N);//Шаг интегрирования.

		for (double i = 1.0; i <= 2.0 * N - 1; i += 2.0)
		{
			sum4 += f(a + h * i);//Значения с нечётными индексами, которые нужно умножить на 4.

			sum2 += f(a + h * (i + 1.0));//Значения с чётными индексами, которые нужно умножить на 2.
		}
		sum = f(a) + 4.0 * sum4 + 2.0 * sum2 - f(b);
		sum4 = 0, sum2 = 0;
		for (double i = 1.0; i <= 2.0 * N - 1; i += 2.0)
		{
			sum4 += f(a + 2*h * i);//Значения с нечётными индексами, которые нужно умножить на 4.

			sum2 += f(a + 2*h * (i + 1.0));//Значения с чётными индексами, которые нужно умножить на 2.
		}
		sum1 = f(a) + 4.0 * sum4 + 2.0 * sum2 - f(b);//Отнимаем значение f(b) так как ранее прибавили его дважды.

		I2 = (h / 3.0) * sum1;
		
		I = I1;

		I1 = (h / 3.0) * sum;
		

	}
	std::cout << I << endl;

	std::cout << I1 << endl;

	std::cout << I2 << endl;
}


