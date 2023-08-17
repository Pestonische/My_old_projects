#include <iostream>
#include <deque>
#include <fstream>
#include <algorithm>

using namespace std;

int main()
{
	setlocale(LC_ALL, "rus");

	cout << "Введите число для сортировки: ";

	int number_to_divide;
	for (;;)
	{

		cin >> number_to_divide;

		if (number_to_divide == 0)
		{
			cout << "На ноль делить нельзя" << endl;
		}
		else
			break;
	}
	deque <int> deq;

	ifstream numbers("numbers.txt");

	if (!numbers.is_open())
	{
		cout << "Не возможно открыть файл!" << endl;
		return 2;
	}
	if (numbers.peek() == EOF)
	{
		cout << "Файл пуст!" << endl;
		return 1;
	}

	int helpnumbers;

	while (numbers >> helpnumbers)
	{
		deq.push_back(helpnumbers);
	}

	cout << "Дек до сортировки: " << endl;

	for (int i = 0; i < deq.size(); i++)
	{
		cout << deq[i] << " ";
	}
	cout << endl;
	cout << "Количество элементов до сортировки:" << deq.size() << endl;

	deque<int>::iterator number;
	
	number = unique(deq.begin(), deq.end(), [number_to_divide](int a, int b)
		{
			int n = number_to_divide;
			if (a % n == 0 && b % n == 0)
				return true;
			else
				return false;
		});

	int size = 0;

	for (deque <int>::iterator j = deq.begin(); j != number; j++)
	{
		cout << *j << " ";
		size++;
	}
	cout << endl;
	deq.resize(size);
	cout << "Количество элементов после сортировки: " << deq.size() << endl;

}