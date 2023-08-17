#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int a, b, c, k = 0, sum = 0;
	cin >> a >> b;
	for (; a != 0 ;)
	{
		c = a % 10;
		a /= 10;
		if (c == b)
		{
			sum += c * pow(10, k + 1);
			sum += c * pow(10, k);
			k += 2;
		}
		else
		{
			sum += c * pow(10, k);
			k++;
		}
	}
	cout << sum << endl;
	
}