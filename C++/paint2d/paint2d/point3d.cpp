#include "point3d.h"


point3d::point3d(double ax, double ay, double az) :
	point2d(ax, ay), z(az) {}
double point3d::GetZ() const { return z; }
void point3d::SetZ(double az) {z = az;}

double point3d::Module() const 
{
	double x = getX(), y = getY();  
	return sqrt(x * x + y * y + z * z);
}
ostream& operator <<(ostream& s, const point3d& p)
{
	s << "(" << p.x << "," << p.y << "," << p.z << ")";
	return s;
}
//double point3d::Module() const
//{ 
//	return point2d::getRo();
//}