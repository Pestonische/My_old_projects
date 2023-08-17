#include <stdio.h>
#include <math.h>
#pragma warning(disable : 4996)
int main(int argc, char* argv[])
{
	double a = 0, b = 0, c = 0;

	sscanf(argv[1], "%lf", &a);
	sscanf(argv[2], "%lf", &b);
	sscanf(argv[3], "%lf", &c);
	double medianA = 0;
	double medianB = 0;
	double medianC = 0;
	double sum = 2 * b * b + 2 * c * c - a * a;
	medianA = 0.5 * sqrtf(sum);
	sum = 2 * a * a + 2 * c * c - b * b;
	medianB = 0.5 * sqrtf(sum);
	sum = 2 * a * a + 2 * b * b - c * c;
	medianC = 0.5 * sqrtf(sum);
	printf("medianA= %lf\n", medianA);
	printf("medianB= %lf\n", medianB);
	printf("medianC= %lf\n", medianC);
}