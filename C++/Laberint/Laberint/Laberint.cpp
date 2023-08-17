#include <iostream>
#include <deque>
#pragma warning (disable : 4996)

using namespace std;

int main()
{
	//freopen("maze.in", "r", stdin);
	//freopen("maze.out", "w", stdout);
	int a, b;
	cin >> a >> b;
	int c;
	int f, g;
	cin >> f >> g;
	int h, k;
	cin >> h >> k;
	
	int** mas = new int* [(a+2)];
	for (int i = 0; i < (a + 2); i++)
		mas[i] = new int[(b+2)];
	for(int i = 0; i < (a + 2); i++)
		for (int j = 0; j < (b + 2); j++)
		{
			mas[i][j] = 0;
		}
	
	for (int i = 1; i < (a + 1); i++)
		for (int j = 1; j < (b + 1); j++)
		{
			cin >> mas[i][j];
		}
	
	if (f != h || g != k)
	{
		int** dop_mas = new int* [(a + 2)];
		for (int i = 0; i < (a + 2); i++)
			dop_mas[i] = new int[(b + 2)];
		for (int i = 0; i < (a + 2); i++)
			for (int j = 0; j < (b + 2); j++)
			{
				dop_mas[i][j] = -1;
			}
		dop_mas[f][g] = 0;
		mas[f][g] = 0;
		dop_mas[h][k] = -1;
		int d, m;


		deque<int> mydeque;
		mydeque.push_front(f);
		mydeque.push_back(g);
		for (;;)
		{
			d = mydeque[0];
			mydeque.pop_front();
			m = mydeque[0];
			mydeque.pop_front();
			if (mas[d][(m + 1)] == 1)
			{
				dop_mas[d][(m + 1)] = dop_mas[d][m] + 1;
				mas[d][(m + 1)] = 0;
				mas[d][m] = 0;
				if (mydeque.size() == 0)
					mydeque.push_front(d);
				else mydeque.push_back(d);
				mydeque.push_back((m + 1));
			}
			if (mas[(d + 1)][m] == 1)
			{
				dop_mas[(d + 1)][m] = dop_mas[d][m] + 1;
				mas[(d + 1)][m] = 0;
				mas[d][m] = 0;
				if (mydeque.size() == 0)
					mydeque.push_front((d + 1));
				else mydeque.push_back((d + 1));
				mydeque.push_back(m);
			}
			if (mas[d][(m - 1)] == 1)
			{
				dop_mas[d][(m - 1)] = dop_mas[d][m] + 1;
				mas[d][(m - 1)] = 0;
				mas[d][m] = 0;
				if (mydeque.size() == 0)
					mydeque.push_front(d);
				else mydeque.push_back(d);
				mydeque.push_back((m - 1));
			}
			if (mas[(d - 1)][m] == 1)
			{
				dop_mas[(d - 1)][m] = dop_mas[d][m] + 1;
				mas[(d - 1)][m] = 0;
				mas[d][m] = 0;
				if (mydeque.size() == 0)
					mydeque.push_front((d - 1));
				else mydeque.push_back((d - 1));
				mydeque.push_back(m);
			}

			if (d == h && m == k)
			{
				break;
			}
			if (mydeque.size() == 0)
			{
				break;
			}
		}
		cout << dop_mas[h][k] << endl;

		if (dop_mas[h][k] != -1)
		{
			d = h;
			m = k;
			c = dop_mas[d][m];
			mydeque.push_front(m);
			mydeque.push_front(d);
			for (int i = 0; i < dop_mas[h][k]; i++)
			{
				c -= 1;
				if (dop_mas[d][(m + 1)] == c)
				{
					mydeque.push_front(m + 1);
					mydeque.push_front(d);
					m++;
				}
				else if (dop_mas[(d + 1)][m] == c)
				{
					mydeque.push_front(m);
					mydeque.push_front(d + 1);
					d++;
				}
				else if (dop_mas[d][(m - 1)] == c)
				{
					mydeque.push_front(m - 1);
					mydeque.push_front(d);
					m--;
				}
				else if (dop_mas[(d - 1)][m] == c)
				{
					mydeque.push_front(m);
					mydeque.push_front(d - 1);
					d--;
				}
			}
			c = 2 * dop_mas[h][k];
			for (int i = 0; i <= c; i += 2)
			{
				cout << mydeque[i] << " ";
				cout << mydeque[(i + 1)] << endl;
			}
		}
		for (int i = 0; i < (a + 2); i++)
			delete[] mas[i];
		delete[] mas;
		for (int i = 0; i < (a + 2); i++)
			delete[] dop_mas[i];
		delete[] dop_mas;
	}
	else if (f == h && g == k)
	{
    cout << 0<<endl;
	cout << f <<" "<<g << endl;
    }
	return 0;
}