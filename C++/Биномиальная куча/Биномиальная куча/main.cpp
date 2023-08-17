#include <iostream>
#include <fstream>
#include <vector> 

using namespace std;

int main()
{
	ifstream in;
	ofstream out;
	in.open("input.txt");
	out.open("output.txt");

	long long n;

	in >> n;

	in.close();

	long long size = n;
	int quantity_tree = 0;

	for (; size >= 1;)
	{
		size /= 2;
		quantity_tree++;
	}
	vector<int> mas = vector<int>();
	long long two = 0;
	for (int i = quantity_tree; i >= 0; i--)
	{
		two = (long long)pow(2, i);
		if (n / two == 1)
		{
			n -= two;
			mas.push_back(i);
		}
	}
	if (n == 0)
	{
		for (int i = mas.size()-1; i >=0; i--)
		{			
			out << mas[i] << endl;
		}
	}
	else
	{
		out << -1;
	}
	out.close();
}