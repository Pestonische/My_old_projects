#pragma once

struct Buyer
{
	char firstName[30];
	char secondName[30];
	char thirdName[30];
	char gender[10];
	char nationality[30];
	int height, weight, birthYear, birthMonth, birthDay, postCode;
	char phoneNumber[30];
	char country[30];
	char region[30];
	char district[30];
	char city[30];
	char street[30];
	int homeNumber, apartmentNumber;
	char creditCard[80];
	char bankAccount[80];
};

void printingBuyer(struct Buyer* buyer);
void printBrest(struct Buyer* people[], int size);
