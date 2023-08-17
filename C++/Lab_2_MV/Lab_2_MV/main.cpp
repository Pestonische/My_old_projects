#include <iostream>

using namespace std;

int main()
{
	setlocale(LC_ALL, "rus");

	int n = 0;
	cout << "n: " << endl;
	cin >> n;

	long double** A = new long double* [n];
	long double** startA = new long double* [n];
	long double* b = new long double[n];
	long double* start_b = new long double[n];
	long double* x = new long double[n];
	long double* r = new long double[n];
	long double sin = 0, cos = 0, rAnswer = 0;

	for (int i = 0; i < n; i++)
	{
		A[i] = new long double[n];
		startA[i] = new long double[n];
	}
	cout << endl << "A: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> A[i][j];
			startA[i][j] = A[i][j];
		}
	}
	
	cout << endl << "b: " << endl;
	
	for (int i = 0; i < n; i++)
	{
		cin >> b[i];
		start_b[i] = b[i];
		x[i] = 0;
		r[i] = 0;
	}

	cout << endl;

	long double num_1 = 0, num_2 = 0;

	for (int i = 0; i < n - 1; i++)
	{
		sin = A[i + 1][i] / (sqrt(A[i][i] * A[i][i] + A[i + 1][i] * A[i + 1][i]));
		cos = A[i][i] / (sqrt(A[i][i] * A[i][i] + A[i + 1][i] * A[i + 1][i]));
		for (int j = i; j < n; j++)
		{
			num_1 = cos * A[i][j] + sin * A[i + 1][j];
			num_2 = cos * A[i + 1][j] - sin * A[i][j];
			A[i][j] = num_1;
			A[i + 1][j] = num_2;
		}
		A[i + 1][i] = 0;
		num_1 = cos * b[i] + sin * b[i + 1];
		num_2 = cos * b[i + 1] - sin * b[i];
		b[i] = num_1;
		b[i + 1] = num_2;
	}

	num_1 = 0;

	for (int k = 0; k < n; k++)
	{
		for (int i = k; i >= 0; i--)
		{
			if (A[i][i] == 0)
			{
				x[i] = 0;
			}
			else {
				num_1 = b[i];
				for (int j = 0; j <= k; j++)
				{
					num_1 -= A[i][j] * x[j];
				}
				x[i] = num_1 / A[i][i];
			}
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= k; j++)
			{
				r[i] += startA[i][j]*x[j];				
			}
			r[i] -= start_b[i];
			rAnswer += r[i] * r[i];
		}
		cout << "x" << k << " ";
		for (int j = 0; j < n; j++)
		{
			cout << x[j] << " ";
			x[j] = 0;
			r[j] = 0;
		}
		cout << endl;
		cout << "r" << k << " " << sqrt(rAnswer) << endl;
		rAnswer = 0;
	}
}

