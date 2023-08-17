#include <iostream>
#include "shilingi.h"
#include <exception>


shilingi::shilingi(long long a, int b, double c)
{
	if (a < 0 || b < 0 || c < 0)
		throw my_exception("Ошибка ввода!\n");
	if (b >= 20 || c >= 12)
		throw my_exception("Ошибка ввода!\n");
	if (double((c * 2 - 2 * (long)c)) != 1 && double((c * 2 - 2 * (long)c)) != 0)
		throw my_exception("Ошибка ввода\n");

	long long static const max_size = 1000000000;
	long long size = a * 20 * 12 * 2 + (long long)b * 12 * 2 + (long long)c * 2;
	if (size/480 > max_size)
		throw my_exception("Ошибка, превышение максимального размера\n");
	p = size;
};

shilingi::shilingi()
{
	p = 0;
};

shilingi::shilingi(long long a)
{
	long long static const max_size = 480000000000;

	if (a > max_size || a < -max_size)
		throw my_exception("Ошибка, превышение максимального размера\n");
	p = a;
};

shilingi& shilingi::operator -() 
{
	p = -p;
	return *this;
}
shilingi shilingi::operator +(const  shilingi& d) const
{
	return shilingi(p+ d.p);
}
shilingi shilingi::operator -(const  shilingi& d3) const
{
	return shilingi(p - d3.p);
}
bool shilingi::operator != (const shilingi& d1) const
{
	return (!this->operator==(d1));
};
bool shilingi::operator != (int aX) const
{
	return (!this->operator==(aX));
};
bool shilingi::operator == (const shilingi& d2)const
{
	return (p == d2.p);
};

bool shilingi::operator <= (const shilingi& d2)const
{
	return (p <= d2.p);
};
bool shilingi::operator >= (const shilingi& d2)const
{
	return (p >= d2.p);
};
bool shilingi::operator > (const shilingi& a) const
{
	if (p > a.p)
		return 1;
	else
		return 0;
};
bool shilingi::operator < (const shilingi& a) const
{
	if (p < a.p)
		return 1;
	else
		return 0;
};
shilingi& shilingi::operator +=(const  shilingi& d)
{
	p += d.p;
	return *this;
}
shilingi& shilingi::operator -=(const  shilingi& d3)
{
	p -= d3.p;
	return *this;
}
std::ostream& operator<< (std::ostream& out, const shilingi& point)
{
	long long a = (point.p / 2/12/20);
	int b = (point.p / 12/2) % 20;
	double c = double((point.p % 24)) / 2;
	if (point.p == 0)
		out << "0p.";
	else if (point.p >= 0)
	{
		if (a != 0)
			out << a << "pd.";
		if (b != 0)
			out << b << "sh.";
		if (c != 0)
			out << c << "p.";

	}
	else if (point.p <= 0)
	{
		out << "-";
		if (a != 0)
			out << abs(a) << "pd.";
		if (b != 0)
			out << abs(b) << "sh.";
		if (c != 0)
			out << abs(c) << "p.";

	}

	return out;

}
shilingi::~shilingi() {}




