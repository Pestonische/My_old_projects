#include <iostream>
#include <string>
#include <thread>
#include <vector>
#include <Windows.h>
#include "dad_mom.h"

using namespace std;

int dad_mom::total_number_of_repeats;

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	setlocale(LC_ALL, "RUS");
	int total;
	cout << "Введите общее количество повторений" << endl;
	cin >> total;
	dad_mom::total_number_of_repeats = total;
	cout << "Введите число потоков." << endl;
	int n;
	cin >> n;
	dad_mom* a = new dad_mom[n];
	vector <thread> threads;

	int times;
	int repeats;
	string message;

	for (int i = 0; i < n; i++)
	{
		cout << "Введите сообщение для потока "<<i+1 << endl;
		cin.ignore();
		getline(cin, message);
		cout << "Введите количество повторений" << endl;
		cin >> repeats;
		cout << "Введите задержку между сообщениями" << endl;
		cin >> times;
		a[i] = dad_mom(message, times, repeats);
	}
	for (int i = 0; i < n; i++)
	{
		threads.push_back(thread(&dad_mom::Set, a[i]));
	}

	for (int i = 0; i < n; i++)
	{
		if (threads[i].joinable())
			threads[i].join();
	}
	delete[] a;
}





