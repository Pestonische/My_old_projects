#include <iostream>
#include <string>
#include <stack>
using namespace std;
#pragma warning (disable : 4996)

int main()
{
	setlocale(LC_ALL, "ru");
	//freopen("smiles.in", "r", stdin);
	//freopen("smiles.out", "w", stdout);


	stack <char> scobki;

	int  n, l = 0;

	(cin >> n).get();

	for (int i = 0; i < n; i++)
	{
		string s;
		getline(cin, s);

		for (int g = 0; g < (int)s.size(); g++)
		{
			if (s[g] == ':' && s[g + 1] != ':')
			{
				s[g] = 'a';

				s[g + 1] = 'a';
			}
			if (s[g] == '[' || s[g] == '{' || s[g] == '(')
			{
				scobki.push(s[g]);
			}

			if (s[g] == ']' || s[g] == '}' || s[g] == ')')
			{
				if (scobki.empty())
				{
					l = 1;

					break;
				}
				if ((s[g] != ']' && scobki.top() == '[') || (s[g] != ')' && scobki.top() == '(') || (s[g] != '}' && scobki.top() == '{'))
				{
					l = 2;
					break;
				}
				else
				if ((s[g] == ']' && scobki.top() == '[') || (s[g] == ')' && scobki.top() == '(') || (s[g] == '}' && scobki.top() == '{'))
				{
			    	l = 0;
				}
				scobki.pop();
			}
		}
		if (l != 1 && l != 2 && l == 0 && !scobki.empty())
		{
			l = 3;
		}
		if (l == 0)
		{
			printf("0\n");
		}
		if (l == 2)
		{
			printf("2\n");
		}
		if (l == 1)
		{
			printf("1\n");
		}
		if (l == 3)
		{
			printf("3\n");
		}
		for (; !scobki.empty();)
		{
			scobki.pop();
		}
		l = 0;
	}
}