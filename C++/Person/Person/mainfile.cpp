#include <iostream>
#include "person.h"
using namespace std;
int main()
{
	setlocale(LC_ALL, "Rus");
	Person adam("����", �������);
	adam.GetI();
	Person eva("���", �������);
	eva.GetI();
	
	try {
		Person ecaci("������", �������, &eva, &adam);
		ecaci.GetI();
		Person mariana("�������", �������, &eva, &adam);
		mariana.GetI();
		Person evklid("������", �������);
		evklid.GetI();
	}
	catch (const my_exception & e)
	{
		cout << e.what() << endl;
	}
}