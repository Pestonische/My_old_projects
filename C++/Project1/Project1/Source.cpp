#include<iostream>
using namespace std;

void main()
{
	int a, b;
	cin >> a>> b;
	int c = a / 100;
	int d = a % 10;
	int h = (a % 100)/10;

	if (c == b) {
		a = a * 10;
		if (h == b) {
			h = h * 10;
		}
		if (d == b) {
			a = a * 10;
			
		}
	}

	else if (d == b) {
		b = d * 10;
	}
	cout << a << endl;
	cout << h << endl;
	cout << d << endl;
	
}