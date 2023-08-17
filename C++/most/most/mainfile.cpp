#include <iostream>
#include <cstdio>
using namespace std;
#pragma warning (disable: 4996)

int main()
{
	freopen("bridge.in", "r", stdin);
	freopen("bridge.out", "w", stdout);

	int* p, b;

	for (;;)
	{
		cin>>b;

		if (b >= 1 && b <= 5000)

			break;
	}

	p = new int[b];

	for (int i = 0; i < b; ++i)
	{
		cin >> p[i];
	}
	
	int min = p[0], nomer = 0;


	for (int i = 0; i < b; ++i)
	{
		if (p[i] < min)
		{
			min = p[i];

			nomer = i;
		}
	}
	int c = 0;
	if (b > 1)
	{
		for (int i = 0; i < b; ++i)
		{
			c += p[i] + p[nomer];
		}
		c -= p[nomer] * 3;
	}
	else
	{
		c += p[0];
	}
	cout << "\n" << c << endl;
	delete[] p;
}