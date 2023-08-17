#pragma once
#include "point2d.h"
class point3d :
	public point2d
{
private:
	double z;
	public:
		//virtual ~point3d() {}
		point3d(double = 0, double = 0, double = 0);
		double GetZ() const;
		void SetZ(double az);
		double Module() const;
		friend ostream& operator <<(ostream&, const point3d&);
		~point3d() { cout << "point3d done" << endl; }
};

