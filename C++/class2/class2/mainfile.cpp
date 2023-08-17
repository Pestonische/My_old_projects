#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main()
{
	//freopen("smiles.in", "r", stdin);
	//freopen("smiles.out", "w", stdout);

	/*stack <char> scobki;

	int n, a = 0, b = 0, c = 0, tip1 = 0, tip2 = 0;

	char q;

	(cin >> n).get();

	for (int i = 0; i < n; ++i)
	{
		string s;

		getline(cin, s);

		if (s[0] == ' ')
			s[0] = 'a';
		if (s[(int)s.size()] == ' ')
			s[0] = 'a';
		for (int b = (int)s.size(); b >= 0; --b)
		{

			if ((s[b] == ')' || s[b] == '}' || s[b] == ']') && s[b - 1] == ':')
			{

				s[b - 1] = 'a';

				s[b] = 'a';
			}
			q = s[b];

			scobki.push(q);
		}
		if (scobki.empty())

			break;

		for (int g = 0; g < (int)s.size(); ++g)
		{

			if (scobki.top() == '(')
			{
				a++;
				tip1 = 1;
			}
			else
				if (scobki.top() == ')')
				{
					tip2 = 1;

					if (b > 0)
					{
						break;
					}
					if (c > 0)
					{
						break;
					}
					if (--a < 0)
					{
						break;
					}
				}
			if (scobki.top() == '{')
			{
				b++;
				tip1 = 2;
			}
			else
				if (scobki.top() == '}')
				{
					tip2 = 2;
					if (a > 0)
					{
						break;
					}
					if (c > 0)
					{
						break;
					}
					if (--b < 0)
					{
						break;
					}
				}
			if (scobki.top() == '[')
			{
				c++;
				tip1 = 3;
			}
			else
				if (scobki.top() == ']')
				{
					tip2 = 3;

					if (a > 0)
					{
						break;
					}
					if (b > 0)
					{
						break;
					}
					if (--c < 0)
					{
						break;
					}
				}
			scobki.pop();
		}
		if ((a == 1 || b == 1 || c == 1) && (tip1 != tip2 && (tip2 != 0)))
		{
			printf("2\n");
		}
		if (a == 0 && b == 0 && c == 0)
		{
			printf("0\n");
		}
		if (a < 0 || b < 0 || c < 0)
		{
			printf("1\n");
		}
		if ((a > 0 || b > 0 || c > 0) && (tip1 == tip2 || tip2 == 0))
		{
			printf("3\n");
		}
		a = 0, b = 0, c = 0, tip1 = 0, tip2 = 0;
	}
}
#include <iostream>
#include <string>

using namespace std;
#pragma warning (disable : 4996)

int main()
{
	//freopen("smiles.in", "r", stdin);
	//freopen("smiles.out", "w", stdout);

	setlocale(LC_ALL, "rus");

	int n, a = 0, b = 0, c = 0, tip1 = 0, tip2 = 0, nomer1 = 0, nomer2 = 0, nomer3 = 0;

	(cin >> n).get();

	for (int i = 0; i < n; ++i)
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
			if (s[g] == '(')
			{
				a++;
				tip1 = 1;
				nomer1 = g;
			}
			else
				if (s[g] == ')')
				{
					tip2 = 1;

					if (tip1 == tip2)
					{
						s[g] = 'a';
						s[nomer1] = 'a';
						a = 0, b = 0, c = 0, g = (-1);
					}
					else
					{
						if (b > 0)
						{
							break;
						}
						if (c > 0)
						{
							break;
						}
						if (--a < 0)
						{
							break;
						}
					}
				}
				else
					if (s[g] == '{')
					{
						b++;
						tip1 = 2;
						nomer2 = g;
					}
					else
						if (s[g] == '}')
						{
							tip2 = 2;
							if (tip1 == tip2)
							{
								s[g] = 'a';
								s[nomer2] = 'a';
								a = 0, b = 0, c = 0, g = (-1);
							}
							else
							{
								if (a > 0)
								{
									break;
								}
								if (c > 0)
								{
									break;
								}
								if (--b < 0)
								{
									break;
								}
							}
						}
						else

							if (s[g] == '[')
							{
								c++;
								tip1 = 3;
								nomer3 = g;
							}
							else
								if (s[g] == ']')
								{
									tip2 = 3;

									if (tip1 == tip2)
									{
										s[g] = 'a';
										s[nomer3] = 'a';
										a = 0, b = 0, c = 0, g = (-1);
									}
									else
									{
										if (a > 0)
										{
											break;
										}
										if (b > 0)
										{
											break;
										}
										if (--c < 0)
										{
											break;
										}
									}
								}
		}
		if ((a == 1 || b == 1 || c == 1) && (tip1 != tip2 && (tip2 != 0)))
		{
			printf("2\n");
		}
		if (a == 0 && b == 0 && c == 0)
		{
			printf("0\n");
		}
		if (a < 0 || b < 0 || c < 0)
		{
			printf("1\n");
		}
		if ((a > 0 || b > 0 || c > 0) && (tip1 == tip2 || tip2 == 0))
		{
			printf("3\n");
		}
		a = 0, b = 0, c = 0, tip1 = 0, tip2 = 0, nomer1 = 0, nomer2 = 0, nomer3 = 0;
	}*/
}