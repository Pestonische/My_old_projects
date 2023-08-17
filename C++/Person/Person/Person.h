#pragma once
#include <cstring>
#include <string>
#include <exception>
#include <iostream>
using namespace std;
#pragma warning(disable: 4996)
enum Pol { мужской, женский };

class Person {
private:

	char* name;
	const int ID;
	static int next_ID;
	void erase();
	void clone(const Person&);
	int gender;
	Person* father;
	Person* mother;
	static bool promother;
	void SetPol(Pol);
	void SetFather(Person*);
	void SetMother(Person*);
public:
	int GetID();
	Person(const char*, Pol, Person* = nullptr, Person* = nullptr);
	Person(const Person&);
	int GetID() const;
	const char* GetMother() const;
	const char* GetFather() const;
	string GetPol() const;
	const char* GetName() const;
	Person& operator = (const Person&);
	void giveBirth(Person*, Person* = nullptr);
	const void GetI() const;
	virtual ~Person();
};
class my_exception : public exception
{
public:
	my_exception(const char* const message)
		: exception(message) {}
	my_exception(const my_exception& right)
		: exception(right) {}
};