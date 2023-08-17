#include <iostream>

using namespace std;

 int main()
{
	 long long n;
	 long long i;
	 long long fact;
	cin >> n;
	fact = 1;
	for (i = 1; i <= n; i++) {
		fact = fact * i;
	}
	cout << fact;
}