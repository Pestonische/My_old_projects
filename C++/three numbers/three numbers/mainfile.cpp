#include <iostream>

using namespace std;

int main()
{
	int d;

	cin >> d;
	
	if (d >= 100 && d <= 999) {

		int a = d / 100;

		int b = d % 10;

		int c = (d % 100) / 10;
	
		cout << a + c + b;

	}
	
}
