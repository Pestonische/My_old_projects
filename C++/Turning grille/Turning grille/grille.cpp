#include <iostream>
#include <string>
#pragma warning (disable : 4996)

using namespace std;

int main()
{
	//freopen("grille.in", "r", stdin);
	//freopen("grille.out", "w", stdout);
	int a;
	string s = "YES";
	cin >> a;
	
	char** mas1 = new char* [a];
	char** mas2 = new char* [a];
	char** mas3 = new char* [a];
	char** mas4 = new char* [a];
	for (int i = 0; i < a; i++)
	{
		mas1[i] = new char[a];
		mas2[i] = new char[a];
		mas3[i] = new char[a];
		mas4[i] = new char[a];
	}
	for (int i = 0; i < a; i++)
		for (int j = 0; j < a; j++)
		{
			cin >> mas1[i][j];
			mas2[j][a-i-1]=mas1[i][j];
			mas3[a-i-1][a - j-1] = mas1[i][j];
			mas4[a - j-1][i] = mas1[i][j];
		}
	for (int i = 0; i < a; i++)
		for (int j = 0; j < a; j++)
		{
			if (mas1[i][j] == '*')
			{
				if (mas1[i][j] == mas2[i][j] || mas1[i][j] == mas3[i][j] || mas1[i][j] == mas4[i][j])
				{
					s = "NO";
				}
			}
		}
	cout << s;
	return 0;
}