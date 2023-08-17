int check(int n)
{
	int number = n, number1, number2, number3, number4, number5, number6;

	number1 = number / 100000;
	number -= number1 * 100000;
	number2 = number / 10000;
	number -= number2 * 10000;
	number3 = number / 1000;
	number -= number3 * 1000;
	number4 = number / 100;
	number -= number4 * 100;
	number5 = number / 10;
	number -= number5 * 10;
	number6 = number;

	if (number1 + number2 + number3 - number4 - number5 - number6 == 0)
	{
		return 1;
	}
	return 0;
}