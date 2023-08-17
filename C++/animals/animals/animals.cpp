#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <algorithm>


using namespace std;

struct animals
{
	double years;
	string name_owner;
	string name_pets;
	string kinds;
};

void first_inquiry(vector<animals>& a)
{
	map<string,map<string, double>> m;
	for (int i = 0; i < a.size() ; i++)
	{
		m[a[i].name_owner][a[i].kinds]++;
	}
	for (auto owner : m)
	{
		for (auto kind : owner.second)
		{
			cout << owner.first << " " << kind.first << " " << kind.second << endl;
		}

	}
}
void two_inquiry(vector<animals>& a)
{
	string kinds;
	pair<set<string>, set<string>> s;
	cin >> kinds;
	
	for (int i = 0; i < a.size(); i++)
	{
		if (a[i].kinds == kinds)
		{
			s.first.insert(a[i].name_owner);
			s.second.insert(a[i].name_pets);
		}
	}
	if (s.first.size() == 0)
		cout << "Такого вида нет" << endl;
	else
	{
		for (auto owner : s.first)
		{
			cout << owner << endl;
		}
		for (auto pets : s.second)
		{
			cout << pets << endl;
		}
	}
}
void three_inquiry(vector<animals>& a)
{
	string pets;
	set<string> s;
	cin >> pets;
	for (int i = 0; i < a.size(); i++)
	{
		if (a[i].name_pets == pets)
		{
			s.insert(a[i].kinds);
		}
	}
	if (s.size() == 0)
		cout << "Такой клички нет" << endl;
	else
	{
		for (auto kinds : s)
		{
			cout << kinds << endl;
		}
	}
}
void last_inquiry(vector<animals>& a)
{
	map<string, pair<double, double>> m;
	
	for (const auto& pets : a)
	{
		const string& kinds = pets.kinds;
		m[kinds].first = min(m[kinds].first, pets.years);
		m[kinds].second = max(m[kinds].second, pets.years);
	}
	cout << "Kind"<<"\t"<<"Young"<<"\t"<<"Old" << endl;
	for (const auto& kinds : m) {
		cout << kinds.first << "\t";
		cout << kinds.second.first << "\t" << kinds.second.second << endl;
	}
}

int main()
{
	setlocale(LC_ALL, "rus");

	ifstream in("input.txt");
	animals data_pets;
	vector<animals> mypets;
	string a;
	while (!in.eof())
	{
		getline(in, data_pets.name_owner, ',');
		getline(in, data_pets.kinds, ',');
		getline(in, data_pets.name_pets, ',');
		in >> data_pets.years;
		in.ignore();	
		mypets.push_back(data_pets);

	}
	int num;
	cout << "Введите 0 для вывода из программы" << endl;
	cout << "Введите 1 для вывода информации о питомцах владельцев" << endl;
	cin >> num;
	if(num ==1)
	first_inquiry(mypets);
	cout << "Введите 2 для вывода информации о владельцев питомцев" << endl;
	cin >> num;
	if (num == 2)
	{
		cout << "Введите вид животного" << endl;
		two_inquiry(mypets);
	}
	cout << "Введите 3 для вывода информации о питомцах владельцев" << endl;
	cin >> num;
	if (num == 3)
	{
		cout << "Введите кличку животного" << endl;
		three_inquiry(mypets);
	}
	cout << "Введите 4 для вывода информации о питомцах владельцев" << endl;
	cin >> num;
	if (num == 4)
	last_inquiry(mypets);
	cout << "Введите 0 для вывода из программы" << endl;
	cin >> num;
	cout << "Вывод из программы" << endl;
	return 0;
}