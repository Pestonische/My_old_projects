#include <iostream>
#include <vector>
#include <ctime>     
#include <chrono>
#include <random>
using namespace std;

int main()
{
	srand(time(0));

	setlocale(LC_ALL, "rus");

	int n = 0;
	cout << "n: " << endl;
	cin >> n;
	
	long double** A = new long double* [n];
	long double** L = new long double* [n];
	long double** U = new long double* [n];
	long double** D = new long double* [n];
	long double** G = new long double* [n];
	long double** E = new long double* [n];
	long double** NG = new long double* [n];
	long double* b = new long double[n];
	long double* x = new long double[n];
	long double* y = new long double[n];

	for (int i = 0; i < n; i++)
	{
		A[i] = new long double[n];
		L[i] = new long double[n];
		U[i] = new long double[n];
		D[i] = new long double[n];
		G[i] = new long double[n];
		NG[i] = new long double[n];
		E[i] = new long double[n];
		b[i] = 0;
		x[i] = 0;
		y[i] = 0;
	}
	/*for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			A[i][j] = rand() % RAND_MAX;
		}
	}
	for (int i = 0; i < n; i++)
	{
	    b[i] = rand() % RAND_MAX;		
	}*/
	cout << endl << "A: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> A[i][j];
			L[i][j] = 0;
			D[i][j] = 0;
			G[i][j] = 0;
			NG[i][j] = 0;
			E[i][j] = 0;
		}
		L[i][i] = 1;
	}
	cout << endl << "b: " << endl;

	for (int i = 0; i < n; i++)
	{
		cin >> b[i];
	}

	U = A;

	auto start = chrono::system_clock::now();

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = i+1; j < n; j++)
		{
			if (U[i][i] != 0)
			{
				L[j][i] = U[j][i] / U[i][i];
			}
			for (int g = i; g < n; g++)
			{
				U[j][g] -= L[j][i] * U[i][g];
			}
		}
	}
	for (int i = 0; i < n; i++)
	{
		D[i][i] = sqrt(abs(U[i][i]));
		if (U[i][i] != 0)
		{
			E[i][i] = U[i][i] / abs(U[i][i]);
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				G[i][j] += L[i][k]*D[k][j];
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				NG[i][j] += G[i][k] * E[k][j];
			}
		}
	}
	long double ll = 0;
	for (int i = 0; i < n; i++)
	{
		if (NG[i][i] == 0)
		{
			y[i] = 0;
		}
		else {
			ll = b[i];
			for (int j = 0; j < n; j++)
			{
				ll -= NG[i][j]*y[j];
			}
			y[i] = ll / NG[i][i];
		}
	}
	for (int i = n - 1; i >= 0; i--)
	{
		if (G[i][i] == 0)
		{
			x[i] = 0;
		}
		else {
			ll = y[i];
			for (int j = 0; j < n; j++)
			{
				ll -= G[j][i]*x[j];
			}
			x[i] = ll / G[i][i];
		}
	}

	auto end = chrono::system_clock::now();
	chrono::duration<double> elapsed_seconds = end - start;
	cout <<endl <<"time: " << elapsed_seconds.count() << "s\n";
	cout << endl << "x: " << endl;
	for (int i = 0; i < n; i++)
	{
		cout << x[i] << " ";
	}
	
	cout << endl;
	cout << endl;
	cout << "G: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << G[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	cout << "H: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << D[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	cout << "L: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << L[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	cout << "U: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << U[i][j] << " ";
		}
		cout << endl;
	}
	
}