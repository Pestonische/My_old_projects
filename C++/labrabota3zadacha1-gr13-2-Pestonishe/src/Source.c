#include <stdio.h>

#pragma warning ( disable : 4996 )

int main() {

	printf("Magic numbers : \n\n");

	int sum = 0;

	for (int i = 100000; i < 1000000; i++)
	{
		if (check(i))
		{
			printf("%d\n", i);
			sum++;
		}
	}

	printf("quantity: %d\n", sum);

}