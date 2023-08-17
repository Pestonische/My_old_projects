#include <iostream>
#include <fstream>

using namespace std;

bool Binary_heap_2(long long* mas, int size)
{
	int i = 1;
	for (i; i <= size; i++)
	{
		if (2 * i <= size)
		{
			if (mas[i] > mas[2 * i])
			{
				return false;
			}
		}
		if (2 * i + 1 <= size)
		{
			if (mas[i] > mas[2 * i + 1] || mas[i] > mas[2 * i])
			{
				return false;
			}
		}
	}
	if (i == size + 1)
	{
		return true;
	}
	else
	{
		return false;
	}		
}

int main()
{
	int size;
	ifstream in;
	ofstream out;
	in.open("input.txt");
	out.open("output.txt");
	in >> size;
	long long* mas = new long long[size+1];
	for (int i = 1; i <= size; i++)
	{
		long long f;
		in >> f;
		mas[i] = f;
	}
	in.close();
	if (Binary_heap_2(mas, size))
	{
		out << "Yes";
	}
	else
	{
		out << "No";
	}
	out.close();
	return 0;
}