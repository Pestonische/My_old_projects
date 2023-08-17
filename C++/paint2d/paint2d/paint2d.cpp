#include "point2d.h"
//#include <math.h>
const double PI = acos(-1.0);

//#define PI = acos(-1.0) не верно
point2d::point2d(double aX, double aY) {

	//std::cout << "constructor is working\n" << endl;
	setX(aX);
	setY(aY);

}
void point2d::setX(double aX) {
	x = aX;
}
double point2d::getX() const
{

	return x;
}

void point2d::setY(double aY) {
	y = aY;
}
double point2d::getY() const
{

	return y;
}
double point2d::getRo() const
{

	return std::sqrt(x * x + y * y);
}
double point2d::getPhi() const
{

	if (x == 0.0 && y == 0.0)
	    throw exception("giiuiuviuviv");
	if (x == 0.0 && y > 0.0)
			return PI / 2;
	if (x < 0.0 && y == 0.0)
		return (-PI);
	if (x < 0.0 && y < 0.0)
		return (-3*PI / 2);
	if (x > 0.0 && y > 0.0)
				return PI / 3;
	if (x < 0.0 && y > 0.0)
		return PI / 2;
	if (x > 0.0 && y < 0.0)
				return 3*PI / 2;
	if (x > 0.0 && y == 0.0)
		return 0;
	if (x == 0.0 && y < 0.0)
		return (-PI / 2);
}
point2d point2d::operator -() const {
	return point2d(-x, -y);
}
point2d& point2d::operator ++()  {
	x++;
	y++;
	return *this;
}
point2d point2d::operator ++(int a)  {
	point2d p(*this);
	x++;
	y++;
	return p;
}
point2d point2d::operator +(const  point2d& p) const {
	return point2d(x+p.x, y+p.y);
}

double point2d::operator * (const point2d& p) const
{
	return(p.x + p.y);
}
bool point2d::operator == (const point2d& p)const
{
	return (x == p.x && y == p.y);
}
bool point2d::operator != (const point2d& p) const
{
	return (! this->operator==(p));
}
point2d operator* (double d, const point2d& p)
{
	return point2d(d*p.x, d*p.y);
}
point2d point2d::operator *(double d) const 
{
	return point2d(x * d, y * d);
}

ostream& operator <<(ostream& s, const point2d& p)
{
	s << "(" << p.x << "," << p.y << ")";
	return s;
}

//point2d::~point2d(void) {
//	std::cout << "disstructor is working\n" << endl;
//}