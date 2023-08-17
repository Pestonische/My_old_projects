#pragma once

struct Student
{
	char name[50];
	char initials[10];
	unsigned groupNum;
	int marks[4];
};

void printingData(struct Student* st);

void printingData_(struct Student* students[], int size);

void printingGoodSt(struct Student* students[], int size);

void deleteBadSt(struct Student* students[], int size);

void sort(struct Student* students[], int size);

double average_score(struct Student* st);
