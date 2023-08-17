#include <iostream>
#include "pivo.h"
#include "drinks.h"
#include "alkagol.h"
#include "bezalkagol.h"
#include "vino.h"
#include "milk.h"
#include "koniyk.h"
#include "limonad.h"
#include "mineral.h"
#include <exception>
#include "drinksexception.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "rus");
	pivo* Pivo = nullptr;
	milk* Milk = nullptr;
	vino* Vino = nullptr;
	koniyk* Koniyk = nullptr;
	limonad* Limonad = nullptr;
	mineral* Mineral = nullptr;

	try {
		Pivo = new pivo("Балтика0", 1.5, 1.5, имбирное, светлое);
		Milk = new milk("Бабушкина крынка", 1, цельное, 3.2);
		Vino = new vino("Вино", 1.5, 5, белое, полусладкое);
		Koniyk = new koniyk("Коньяк", 1.5, 45, 10);
		Limonad = new limonad("Сочный", 1, 90);
		Mineral = new mineral("Дарида", 1, газированное);
		drinks* Drinks[6] = {Pivo, Vino, Milk, Koniyk, Limonad, Mineral};
		for (int i = 0; i < 6; i++)
		{
			Drinks[i]->GetInfo();
			cout<<endl;
		}

	}
	catch (const drinksexception & e)
	{		
	    delete Pivo;
		Pivo = nullptr;
		delete Milk;
		Milk = nullptr;
		delete Vino;
		Vino = nullptr;
		delete Limonad;
		Limonad = nullptr;
		delete Koniyk;
		Koniyk = nullptr;
		delete Mineral;
		Mineral = nullptr;
		cout << e.what();
	}
	
	Pivo = nullptr;
	delete Pivo;	
	Milk = nullptr;
	delete Milk;
	Vino = nullptr;
	delete Vino;
	Limonad = nullptr;
	delete Limonad;
	Koniyk = nullptr;
	delete Koniyk;
	Mineral = nullptr;
	delete Mineral;

	return 0;
}