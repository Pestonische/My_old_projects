#include <iostream>
#include <cmath>
using namespace std;
#include "point3d.h"
#include "point2d.h"
#include "mainfile.h"
int main()
{
	point2d p(1.0, 1.0);

	cout << p.getX()<<" " << p.getY()<< " "<<p.getRo()<< endl;
	try {
		cout << p.getPhi() << endl;
	}
	catch (exception ex) {
		cout << "10x";
	}
	//point2d p(3, 7); 
	point3d q(2, 9, 4); 

	p = q; // можно 
	//q = p; // нельзя 
	

	
	point3d q2(3, 4, 5);
	cout << p << endl;
	return 0;
}
//<< " " << p.getPhi()