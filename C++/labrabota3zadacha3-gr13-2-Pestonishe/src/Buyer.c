#include "../include/Buyer.h"
#include <string.h>

void printingBuyer(struct Buyer* buyers)
{
	printf("First name : %s\nSecond name : %s\nThird name : %s\nGender : %s\nNationality : %s\n",
		&buyers->firstName, &buyers->secondName, &buyers->thirdName, &buyers->gender,
		&buyers->nationality);
	printf("Height : %d\nWeight : %d\nBirth date : %d.%d.%d\nPhone number : %s\n",
		buyers->height, buyers->weight, buyers->birthYear,
		buyers->birthMonth, buyers->birthDay, &buyers->phoneNumber);
	printf("Postcode : %d\nCountry : %s\nRegion : %s\nDistrict : %s\nCity : %s\nStreet : %s\n",
		buyers->postCode, &buyers->country, &buyers->region, &buyers->district,
		&buyers->city, &buyers->street);
	printf("Home : %d\nApartment : %d\nCredit card : %s\nBank account : %s\n",
		buyers->homeNumber, buyers->apartmentNumber, &buyers->creditCard,
		&buyers->bankAccount);
}

void printBrest(struct Buyer* people[], int size)
{
	for (int i = 0; i < size; i++)
	{
		if (strcmp(people[i]->city, "Brest") == 0||
			strcmp(people[i]->city, "Брест") == 0)
		{
			printingBuyer(people[i]);
		}
	}
}