#include <iostream>

using namespace std;

int  main()
{
	
	int a, b, d, sum;
	
	cin >> b;
	
	for (a = 1; a < b; a++)
	{
		sum = 0;

		for (d = 1; d < b; d++)

			if ((a % d == 0) && (d != a))

				sum = sum + d;

		if (a == sum)
			cout << a <<  endl;
	}
	
}
