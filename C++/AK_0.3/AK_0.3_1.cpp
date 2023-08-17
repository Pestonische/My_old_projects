#include <omp.h> 
#include <iostream> 
#include <vector> 
#include <time.h>

using namespace std;
double f(double x) {
	return pow(x, 3);
}
double sec_der(double x, double _x, double x_, double h) {
	return (f(_x) - 2 * f(x) + f(x_)) / pow(h, 2);
}
double real_sec_der(double x) {
	return 6 * x;
}

int main(int argc, char* argv[]) {
	const int ThreadsCount = atoi(argv[1]);

	const double a = -1;
	const double b = 3;
	const int N = atoi(argv[2]) + 1;


	double max = -INT_MAX;
	double point = a;
	double size = (b - a) / N;

	clock_t start = clock();

#pragma omp parallel for num_threads(ThreadsCount)
	for (int i = 0; i < N; i++)
	{
		double  y = a + i * size;
		double x = sec_der(y, y - size, y + size, size);
#pragma omp critical
		{
			if (max < x)
			{
				max = x;
				point = y;
			}
		}
	}

	double real_der = real_sec_der(point);
	cout << "For " << N << " points \nMaximum of Second derivative is " << max << " in point " << point;
	cout << "\nError of calculus is " << real_der - max << endl;

	clock_t end = clock();
	double seconds = (double)(end - start) / CLOCKS_PER_SEC;
	printf("The time: %f seconds\n", seconds);
}