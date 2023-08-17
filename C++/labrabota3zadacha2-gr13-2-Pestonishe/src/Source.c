#include <stdio.h>
#include "../include/students.h"

#pragma warning ( disable : 4996 )

int main() {

	struct Student* students[7];
	unsigned count = 3;

	for (int i = 0; i < count; i++)
	{
		students[i] = malloc(sizeof(struct Student));
		printf("Enter your name and initials without a space\n"); 
		if (scanf("%s %s", &students[i]->name, &students[i]->initials) == EOF)
		{
			i--;
			printf("Incorrect input, try again...\n");
			continue;
		}
		printf("Enter group number\n");
		if (scanf("%d", &students[i]->groupNum) == EOF)
		{
			i--;
			printf("Incorrect input, try again...\n");
			continue;
		}
		printf("Enter marks\n");
		if (scanf("%d %d %d %d", &students[i]->marks[0], &students[i]->marks[1], &students[i]->marks[2],
			&students[i]->marks[3]) == EOF)
		{
			i--;
			printf("Incorrect input, try again...\n");
			continue;
		}
	}

	printf("\n\nStudents\n\n");
	printingData_(students, count);

	printf("\n\nSorted by maximum score\n\n");
	sort(students, count);
	printingData_(students, count);

	printf("\n\nGood students\n\n");
	printingGoodSt(students, count);

	printf("\n\nRemoving the worst student\n\n");
	deleteBadSt(students, count);
	printingData_(students, count);

	for (int i = 0; i < count; i++)
	{
		if (students[i] != NULL)
		{
			free(students[i]);
		}
	}

}