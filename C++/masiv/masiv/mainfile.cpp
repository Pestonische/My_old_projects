#include <iostream>
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");

	int* p;

	int mpt = 1;

	int q = 1;

	int N;

	cout << "������� ���������� ��������� ������� : ";

	cin >> N;

	if (N > 0) {

		p = new int[N];

		cout << "\n������� �������� ������� : ";

		for (int i = 0; i < N; i++) {

			cin >> p[i];

		}
		for (int i = 0; i < N; i++) {

			if (p[i] > 0)
			{
				mpt *= p[i];

				q += p[i];
			}

		}
		if (mpt == 1 && q == 1)
		{
			cout << "\n��� ����� ������������, ��� ����� ����!";
		}
		else
		{
			cout << "\n������������ ������������� ����� �������: ";

			cout << mpt << endl;
		}
		int min = p[0], nomer = 0, sum = 0;

		for (int i = 0; i < N; i++)
		{
			if (p[i] < min)
			{
				min = p[i];

				nomer = i;
			}
		}
		if (p[0] == min)
		{
			cout << "\n\n����������� �������� ������� ��������� �� ������ �����!";
		}
		else
		{
			cout << "\n\n����� ����� �� ������� ����������� �����: ";
			for (int i = 0; i < nomer; i++)
			{
				sum += p[i];
			}
			cout << sum;
		}
		int  t;

		for (int i = 1; i < N - 1; i += 2)
		{
			for (int l = 1; l < N - i - 1; l += 2)
			{
				if (p[l] > p[l + 2])
				{
					t = p[l];

					p[l] = p[l + 2];

					p[l + 2] = t;
				}
			}
		}
		cout << "\n\n����� ������ ������� ������� �� �������: ";

		for (int i = 1; i < N; i += 2)
		{
			cout << p[i] << " ";
		}
		int  s;

		for (int i = 0; i < N - 2; i += 2)
		{
			for (int l = 0; l < N - i - 2; l += 2)
			{
				if (p[l] > p[l + 2])
				{
					s = p[l];

					p[l] = p[l + 2];

					p[l + 2] = s;
				}
			}
		}
		cout << "\n\n����� �������� ������� ������� �� �������: ";

		for (int i = 0; i < N; i += 2)
		{
			cout << p[i] << " ";
		}


	}
	else
	{
		cout << "\n������ ������� ������ ���� �������������" << endl;
	}
}