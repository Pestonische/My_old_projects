#include <iostream>


using namespace std;
int l = 0, v = 0;
char* ltrim(const char* string, int n)
{
	int k = (n-1);
	for (; k >= 0; k--)
	{
		if (string[k - 1] != ' ')
		{
			break;
		}
	}
	char* s1 = new char[k+1];
		
	//s1 = (char*)string;
	for (int i = 0; i < k; i++)
		s1[i] = string[i];
	s1[k] = NULL;
	l = k;
	return s1;
}
char* longestpalin(char* str, int n)
{
	bool** table;
	table = new bool* [n];
	for (int i = 0; i < n; i++)
	{
		table[i] = new bool[n];
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			table[i][j] = NULL;
		}
	}

	int maxLength = 0;
	for (int i = 0; i < n; i++) 
	{
		table[i][i] = true; 
	}

	int start = 0;

	for (int i = 0; i < n - 1; i++) 
	{
		if (str[i] == str[i + 1])
		{
			table[i][i + 1] = true;  
			maxLength = 2;
			start = i;
		}
	}

	for (int k = 3; k <= n; k++) 
	{
		for (int i = 0; i < n - k + 1; i++) 
		{
			int j = i + k - 1;
			if (table[i + 1][j - 1] && str[i] == str[j]) 
			{ 
				table[i][j] = true;
				if (k > maxLength)
				{
					maxLength = k;
					start = i;
				}
			}
		}
	}
	
	for (int i = 0; i < maxLength; i++)
	{
		str[i] = str[start];
		start++;
	}
	str[maxLength] = NULL;
	v = maxLength;
	for (int i = 0; i < n; i++)
		delete[] table[i];
	delete[] table;
	return str;
}
int main()
{
	setlocale(LC_ALL, "RUS");
	int n;
	(cin >> n).get();
	n++;
	char * s= new char[n];

	cin.getline(s, n);
	cout <<"С отступами: "<< s << "'" << endl;
	
	cout <<"Без отступов: "<< ltrim(s,n)<<"'"<<endl;
	longestpalin(ltrim(s, n), l);
	if (v != 0)
	{
		cout <<"Самый большой палиндром: " << longestpalin(ltrim(s, n), l);
	}
	else
	{
		cout << "Нет палиндрома" << endl;
	}
	delete[] s;

	return 0;
}