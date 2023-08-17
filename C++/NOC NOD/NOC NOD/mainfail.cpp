#include <iostream>

using namespace std;

int main() 
{
    int a, b;

	cin >> a >> b;

	for (int c = a; c > 0; c--) 
	{
		if (a % c == 0 && b % c == 0) 
		{
			cout << "NOD=" << c << endl;

			int q = a * b;

			cout << "NOK=" <<q / c ;

			break;
			
		}
	}
}