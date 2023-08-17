#include "Person.h"
using namespace std;
int Person::next_ID = 0;

void Person::clone(const Person& p) 
{
	name = new char[strlen(p.name) + 1];
	strcpy(name, p.name);
}
Person::Person(const char* aname, Pol agender, Person* amother, Person* afather) :ID(++next_ID) 
{
	
	if (strlen(aname) == 0)
		throw my_exception("Некоректное имя!");
	this->name = new char[strlen(aname) + 1];
	strcpy(this->name, aname);
	if (aname == NULL)
		throw "Неверный параметр";
	if (aname[0] == '\0')
		throw "Первая буква это пробел";
	giveBirth(amother, afather);
	SetPol(agender);
}
Person::Person(const Person& p) :ID(++next_ID)
{
	clone(p);
}
void Person::erase() 
{
	delete[] name;
}
const char* Person::GetName() const
{
	return name;
}

int Person::GetID() 
{
	return ID;
}

Person& Person::operator=(const Person& p)
{
	if (this == &p)
		return *this;
	delete[] name;
	name = new char[strlen(p.name) + 1];
	strcpy(name, p.name);
	return *this;
}
bool Person::promother = false;

int Person::GetID() const
{
	return ID;
}
string Pol1[]{ "мужской","женский" };
string Person::GetPol() const
{
	return Pol1[gender];
}
void Person::SetPol(Pol agender)
{
	this->gender = agender;
	if (agender == женский)
		promother = true;
}
void Person::giveBirth(Person* amother, Person* afather)
{
	if (promother && amother == nullptr)
		throw my_exception("У человека должна быть мать");
	if (promother)
	{
		SetMother(amother);
		SetFather(afather);
	}
}
void Person::SetMother(Person* amother)
{
	if (amother->GetPol() == "женский")
		mother = amother;
	else throw my_exception("Мать должна быть женщиной");
}
void Person::SetFather(Person* afather)
{
	if (afather != nullptr)
	{
		if (afather->GetPol() == "мужской")
			father = afather;
		else throw my_exception("Отец не может быть женщиной");
	}
}
const char* Person::GetFather() const
{
		if (father == nullptr)
			return "Неизвестен";
	
	return father->GetName();
}
const char* Person::GetMother() const
{
	return mother->GetName();
}
const void Person::GetI() const
{
	cout << "ID: " << GetID() << endl << "Имя: " << GetName() << endl << "Пол: " << GetPol() << endl;
	cout << "Отец: " << GetFather() << endl;
	if (mother != nullptr)
		cout << "Мать: " << GetMother() << endl;
}
Person::~Person() 
{
	erase();
}