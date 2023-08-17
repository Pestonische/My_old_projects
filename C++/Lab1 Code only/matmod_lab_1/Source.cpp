#include <iostream>
#include <fstream>
#include <limits.h>
#include <math.h>

#define K 128

int a0 = 32771;
int b = a0;
unsigned int M = 2147483648 * 10079;

unsigned int curr_rand = a0;
double rand1(){
	curr_rand = (curr_rand*b) % M;
	return (double)curr_rand / M;
}


double V[K];

void init() {
	for (int i = 0; i < K; ++i)
		V[i] = rand1();
}

double rand2() {
	int s = rand() % K;
	double res = V[s];
	V[s] = rand1();
	return res;
}

bool pirson_test(int X, int L, double(*f)(), double C) // L - число разбеий интервала (0, 1) | X - обьем выборки
{
	int* div = new int[L];
	for (int i = 0; i < L; ++i)
		div[i] = 0;
	for (int i = 0; i < X; ++i)
		div[lround(f()*L)]++;
	
	double hi = 0;
	for (int i = 0; i < L; ++i)
		hi += pow((div[i] - (double)X/L), 2) / ((double)X / L);
	return hi < C;
}

bool kolgomorov_test(int X, int L, double(*f)(), double C)  // L - число разбеий интервала (0, 1) | X - обьем выборки
{
	double sup = 0;
	for (int i = 0; i < L; ++i) {
		int hits = 0;

		for (int j = 0; j < X; ++j)
			if (f() < (double)i / L) hits++;

		std::cout << i << ": " << hits << std::endl;
		double F = (double)hits / X;
		std::cout << abs(F - (double)i / L) << std::endl;
		if (sup < abs(F - (double)i / L))
			sup = abs(F - (double)i / L);
	}

	return sqrt(X) * sup < C;
}

int main() {
	init();

	std::ofstream fout1("output1.txt");
	std::ofstream fout2("output2.txt");
	for (int i = 0; i < 10000; ++i) 
		fout1 << rand1() << std::endl;
	for (int i = 0; i < 10000; ++i)
		fout2 << rand2() << std::endl;
	std::cout << "Pirson test: " << pirson_test(1000, 25, rand2, 37.6525) << std::endl;  // Достоверность
	std::cout << "Kolmogorov test: " << kolgomorov_test(20000, 250, rand2, 1.36) << std::endl;

	std::system("pause");
}

/*
квантиль уровня 1 - а дли хи квадрат распределения с L-1 степенью свободы
*/