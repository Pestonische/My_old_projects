#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

vector <long long> sort_parallel(vector <long long> vect, int size_p)
{
	long long a = 0;
	for (int i = 0; i < size_p; i++)
	{
		for (int j = 0; j < size_p; j++)
		{
			if (j != size_p-1)
			{
				if (vect[j] > vect[j + 1])
				{
					a = vect[j];
					vect[j] = vect[j + 1];
					vect[j + 1] = a;
				}
			}
		}
	}
	return vect;
}

vector <vector <long long>> sort(vector <vector <long long>> vect, int size_p, int size)
{
	vector <long long> a;
	for (int m = size-1; m > 0; m--)
	{
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < size_p; j++)
			{
				if (vect[i][j] < vect[i + 1][j])
				{
					a = vect[i];
					vect[i] = vect[i + 1];
					vect[i + 1] = a;
					break;
				}
			}
			
		}
	}
	return vect;
}

int max_number(vector <long long> vect1, vector <long long> vect2)
{      
	for (int i = 0; i < (int)vect1.size(); i++) {
		if (vect1[i] > vect2[i]) {
			return 0;
		}
	}
	return 1;
}

int main()
{
	ifstream in;
	ofstream out;
	in.open("input.txt");
	out.open("output.txt");
	
	int size_p = 0, size = 0;

	in >> size_p;
	in >> size;

	vector <vector <long long>> mas_parallel(size, vector <long long>(size_p));


	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size_p; j++)
		{
			in>>mas_parallel[i][j];
		}
	}
	int* mas = new int[size];
	for (int i = 0; i < size; i++)
	{
		mas[i] = 1;
	}
	for (int i = 0; i < size; i++)
	{
		mas_parallel[i] = sort_parallel(mas_parallel[i], size_p);
	}
	
	mas_parallel = sort(mas_parallel, size_p, size);
	
	int s = 0;
	
	for (int k = 0; k < size; k++) {
		for (int i = k - 1; i >= 0; i--) {
			if (max_number(mas_parallel[k], mas_parallel[i]) == 1) {
				if (mas[k] < mas[i] + 1) {
					mas[k] = mas[i] + 1;
				}
			}
		}
	}

	int max = 0;
	for (int i = 0; i < size; i++)
	{
		if (max < mas[i])
			max = mas[i];
	}
	out << max;
	
}
