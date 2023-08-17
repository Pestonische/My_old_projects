#include <stdio.h>
#include "../include/Buyer.h"

#pragma warning ( disable : 4996 )

int main() {

	int count = 1;
	struct Buyer* buyers[1];

	for (int i = 0; i < count; i++)
	{
		buyers[i] = malloc(sizeof(struct Buyer));
		printf("\nEnter your first name last name and patronymic separated by a space\n");
		if (scanf("%s\n%s\n%s",
			&buyers[i]->firstName,
			&buyers[i]->secondName, &buyers[i]->thirdName) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter your gender\n");
		if (scanf("%s", &buyers[i]->gender) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter your nationality\n");
		if (scanf("%s",	&buyers[i]->nationality) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter height weight date of birth\n");
		if (scanf("%d\n%d\n%d\n%d\n%d",
			&buyers[i]->height, &buyers[i]->weight, &buyers[i]->birthYear,
			&buyers[i]->birthMonth, &buyers[i]->birthDay) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter postal code\n");
		if (scanf("%d", &buyers[i]->postCode) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter phone number\n");
		if (scanf("%s",	&buyers[i]->phoneNumber) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter country, region, district, city, street, house, apartment\n");
		if (scanf("%s\n%s\n%s\n%s\n%s%d\n%d",
			&buyers[i]->country, &buyers[i]->region,
			&buyers[i]->district, &buyers[i]->city, &buyers[i]->street,
			&buyers[i]->homeNumber, &buyers[i]->apartmentNumber) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
		printf("\nEnter credit card number, bank account number\n");
		if (scanf("%s\n%s",	&buyers[i]->creditCard, &buyers[i]->bankAccount) == EOF)
		{
			i--;
			printf("\nIncorrect input, try again...\n");
			continue;
		}
	}


	printf("\n\nPeople from Brest : \n\n");
	printBrest(buyers, count);
}