#include "drobi.h"
#include <iostream>
#include <exception>

using namespace std;



long long drobi::vch(long a, long b)
{
	a = abs(a);
	b = abs(b);
	if (a == 0)
		return b;
	if (a == b)
		return a;
	else {
		while (a != b)
			if (a < b)
				b -= a;
			else
				a -= b;
		return a;
	}
}
void drobi::setP(long a, bool l)
{
	p = a;
	if (l)
		correct();
}
void drobi::setP(long aX)
{
	setP(aX, true);
}
void drobi::setQ(long bX)
{
	if (bX == 0)
		throw my_exception("Знаменатель не может ровнятся нулю\n");
	q = bX;
	correct();
}
long long drobi::getP() const
{
	return p;
}
long long drobi::getQ() const
{
	return q;
}
double drobi::getdrobi() const
{
	return (double)p / q;
}
void drobi::correct()
{
	if (q < 0)
	{
		q = -q;
		p = -p;
	}
	long long v = vch(p, q);
	p /= v;
	q /= v;
}
drobi::drobi(long aX, long bX)
{
	setP(aX, false);
	setQ(bX);
}
drobi::drobi(const drobi& d)
{
	p = d.p;
	q = d.q;
}
drobi drobi::operator - () const
{
	return drobi(-p, q);
}
drobi drobi::operator +(const  drobi& d) const
{
	return drobi(p * d.q + d.p * q, q * d.q);
}
drobi drobi::operator - (const drobi& d1) const
{
	return (this->operator + (-d1));
}
drobi drobi::operator * (const drobi& d4) const 
{
	return drobi(p * d4.p, q * d4.q);
}
drobi drobi::operator / (const drobi& d5) const {
	if (d5.p == 0)
		throw my_exception("Знаменатель не может быть равен 0\n");
	else {
		return drobi(p * d5.q, q * d5.p);
	}
}
drobi& drobi::operator = (const drobi& d2)
{
	p = d2.p;
	q = d2.q;
	return *this;
}
bool drobi::operator == (const drobi& d2)const
{
	return ((this->p == d2.p) && (this->q == d2.q));
}
bool drobi::operator != (const drobi& d) const
{
	return !(this-> operator == (d));
}
bool drobi::operator < (const drobi& d) const
{
	return (this->operator - (d).p < 0);
}
bool drobi::operator > (const drobi& d) const
{
	return !(this-> operator - (d) < 0) && !this-> operator == (d);
}
bool drobi::operator <= (const drobi& d) const
{
	return !(this->operator > (d));
}
bool drobi::operator >= (const drobi& d) const
{
	return !(this->operator < (d));
}
std::ostream& operator<< (std::ostream& out, const drobi& point)
{

	out << point.p << "/" << point.q;

	return out;

}
drobi::~drobi() {}

