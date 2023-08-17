#include <iostream>
#include "person.h"
using namespace std;
int main()
{
	setlocale(LC_ALL, "Rus");
	Person adam("Адам", мужской);
	adam.GetI();
	Person eva("Ева", женский);
	eva.GetI();
	
	try {
		Person ecaci("Екакий", мужской, &eva, &adam);
		ecaci.GetI();
		Person mariana("Мариана", женский, &eva, &adam);
		mariana.GetI();
		Person evklid("Евклид", мужской);
		evklid.GetI();
	}
	catch (const my_exception & e)
	{
		cout << e.what() << endl;
	}
}