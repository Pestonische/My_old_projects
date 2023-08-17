#include <iostream>
#include <functional>
#define _USE_MATH_DEFINES
#include <math.h>

using namespace std;

using ff = std::function <double(double)>;

double simpson(double a, double b, double eps, ff f, double n)
{
	
	double I = 1.0, I1 = 0.0;

		for (double N = 2.0; ; N *= 2.0)
		{
			double  h,h2, sum2 = 0.0, sum4 = 0.0, sum = 0.0,sum1=0.0;

			h = (b - a) / (2.0 * N);

			h2 = (b - a) / (4.0 * N);

			for (double i = 1.0; i <= 2.0 * N - 1; i += 2.0)
			{
				sum4 += f(a + h * i);

				sum2 += f(a + h * (i + 1.0));
			}
			sum = f(a) + 4.0 * sum4 + 2.0 * sum2 - f(b);


			I = I1;

			I1 = (h / 3.0) * sum;

			n += N;

			if (abs((I1 - I) / 15) < eps)
			{
				break;
			}
		}
		cout <<"Количество шагов:  "<< n <<endl;

	return I1;
}


double f1(double x)
{
	return exp(x) * sin(x);
}
double f2(double x)
{
	return (x * x - 1) * pow(10, -2 * x);
}
double f3(double x)
{
	return pow((exp(x)) - 1, (0.5));
}

int main()
{
	setlocale(LC_ALL, "Rus");

	double eps, n1 = 0.0, n2 = 0.0, n3 = 0.0;

	cout << "Введите погрешность: ";

	cin >> eps;

	double l = M_PI_2;

	cout << "Втарая функция: " << simpson(0, l, eps, f1, n1) << endl;

	cout << "Третия функция: " << simpson(0, 0.5, eps, f2, n2) << endl;

	cout << "Первая функция: " << simpson(0.2, 2.1, eps, f3, n3) << endl;

	return 0;
}