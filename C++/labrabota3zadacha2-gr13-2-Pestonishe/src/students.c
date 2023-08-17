#include "../include/students.h"
#include <stdlib.h>

void printingData(struct Student* st)
{
	if (st == NULL)
	{ 
		return; 
	}
	double averagescore = average_score(st);
	printf("Name : %s %s\nGroup : %d\nMarks : %d, %d, %d, %d\nAverage score : %f\n\n",
		&st->name, &st->initials, st->groupNum, st->marks[0], st->marks[1],
		st->marks[2], st->marks[3], averagescore);
}

void printingData_(struct Student* students[], int count)
{
	for (int i = 0; i < count; i++)
	{
		printingData(students[i]);
	}
}

void printingGoodSt(struct Student* students[], int count)
{
	for (int i = 0; i < count; i++)
	{
		if (students[i] != NULL && average_score(students[i]) >= 4)
		{
			printingData(students[i]);
		}
	}
}

double average_score(struct Student* st) {
	return ((st->marks[0] + st->marks[1] + st->marks[2] + st->marks[3]) / 4);
}

void sort(struct Student* students[], int count)
{
	struct Student* copy = NULL;
	for (int i = 0; i < count; i++)
	{
		for (int j = i + 1; j < count; j++)
		{
			if (students[i] != NULL && students[j] != NULL &&
				average_score(students[j]) > average_score(students[i]))
			{
				copy = students[i];
				students[i] = students[j];
				students[j] = copy;
			}
		}
	}
}

void deleteBadSt(struct Student* students[], int count)
{
	int min_averagescore = 5, badStudent = 0;
	for (int i = 0; i < count; i++)
	{
		if (students[i] != NULL && average_score(students[i]) < min_averagescore)
		{
			min_averagescore = average_score(students[i]);
			badStudent = i;
		}
	}
	free(students[badStudent]);
	students[badStudent] = NULL;
}