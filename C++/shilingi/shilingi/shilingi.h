#pragma once
#include <iostream>
#include <exception>

class shilingi
{

private:
	long long p;
	shilingi(long long);

public:
	virtual ~shilingi();
	shilingi(long long, int, double);
	shilingi();
	

	

	shilingi operator +(const shilingi&) const;

	shilingi operator -(const shilingi&) const;

	shilingi& operator +=(const shilingi&);

	shilingi& operator -=(const shilingi&);

	shilingi& operator -() ;

	bool operator == (const shilingi&)const;
	bool operator != (int)const;
	
	
	bool operator != (const shilingi&)const;

	bool operator <= (const shilingi&)const;
	bool operator < (const shilingi&)const;
	bool operator > (const shilingi&)const;
	bool operator >= (const shilingi&)const;
	friend std::ostream& operator<< (std::ostream& out, const shilingi& point);
};
class my_exception : public std::exception
{
public:  
my_exception(const char* const message)
	: exception(message) {}
my_exception(const my_exception& right)
	: exception(right) {} 
};

