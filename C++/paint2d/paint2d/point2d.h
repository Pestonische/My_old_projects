#pragma once
#include <iostream>


using namespace std;
class point2d
{ //protected:
public:
	//virtual double Module() const;
	//virtual ~point2d(){}
	double x, y;

	void setX(double);
	double getX() const;
	void setY(double);
	double getY() const;
	double getPhi() const;
	double getRo() const;
	
	//point2d(void);
	point2d(double = 0, double = 0);
	//virtual  ~point2d(void);
	point2d& operator ++();
		point2d operator -() const;
	point2d operator ++(int);
	point2d operator +(const point2d&) const;
	double operator * (const point2d&) const;
	bool operator == (const point2d&)const;
	bool operator != (const point2d&)const;
	point2d operator * (double) const;
	friend point2d operator * (double, const point2d&);
	friend ostream& operator <<(ostream&, const point2d&);
	~point2d() { cout << "point2d done" << endl; }
};

