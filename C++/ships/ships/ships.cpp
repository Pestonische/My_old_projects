#include <iostream>
#include <fstream>
#include <string>
#include <deque>
using namespace std;

int main()
{
	setlocale (LC_ALL, "rus");

	ifstream in("SHIPS.IN");
	ofstream out("SHIPS.OUT");
	if (!in.is_open())
	{
		cout << "Невозможно открыть файл" << endl;

		out << "Невозможно открыть файл" << endl;

		return 2;
	}
	if (in.peek() == EOF)
	{
		cout << "Входной файл не содержит строк" << endl;

		out << "Входной файл не содержит строк" << endl;

		return 1;
	}
	int a = 0;
	 
	in >> a;
	
	int b = a;

	deque<string> myDeque;

	string* dok= new string[a];

	for (int i = 0; i < a; i++)
	{
		dok[i]="Пусто";
	}

	string s;
	int* mas = new int[a];
	for (int i = 0; i < a; i++)
	{
		
		mas[i] = 0;
		
	}
	while (getline(in, s))
	{
		if (s[0] == '1')
		{
			if (myDeque.size() == 0)
			{
				if (b == 0)
				{
					s[0] = ' ';
					if (myDeque.size() == 0)
						myDeque.push_front(s);
					else if (myDeque.size() > 0)
						myDeque.push_back(s);
				}
				else if (b > 0)
				{
					for (int i = 0; i < a; i++)
					{
						if (mas[i] == 0)
						{
							mas[i] = 1;
							s[0] = ' ';
							dok[i] = s;
							break;
						}
					}
					b -= 1;
				}
			}
			else if (myDeque.size() > 0)
			{
				s[0] = ' ';
				if (myDeque.size() == 0)
					myDeque.push_front(s);
				else if (myDeque.size() > 0)
					myDeque.push_back(s);
				for (int i = 0; i < a; i++)
				{
					if (mas[i] == 0)
					{
						mas[i] = 1;
						dok[i] = myDeque[0];
						myDeque.pop_front();
						break;
					}
				}

			}
		}

		else if (s[0] == '2')
		{
			
			if (b < a)
			{
				s[0] = ' ';
				int l = atoi(&s[0]) - 1;
				mas[l]=0;
				dok[l] = "Пусто";
				b += 1;
			}
		}
		else if (s[0] == '3')
		{
			out << "Информация о текущем состоянии очереди на рейде:" << endl;
			if (myDeque.size() > 0)
			{
				for (int i = 0; i < myDeque.size(); i++) {
					out << myDeque[i] << endl;
				}
			}
			if (myDeque.size() == 0)
				out << "Пусто" << endl;
		}
		else if (s[0] == '4')
		{
			out << "Информация о текущем состоянии причалов:" << endl;
			for (int i = 0; i < a; i++) {
				out << i+1 << " "<< dok[i] << endl;
			}
		}
	}	
	delete[] dok;
	delete[] mas;
	return 0;
}