#pragma once
#include <iostream>
#include <exception>
using namespace std;
class drobi
{
	private:
		long long p, q;
		void correct();
		static long long vch(long, long);
		void setP(long, bool);
	public:
		virtual ~drobi();
		
		void setP(long);
		void setQ(long);
		long long getP() const;
		long long getQ() const;
		double getdrobi() const;

		
		
		
		

		drobi operator +(const drobi&) const;

		drobi operator -(const drobi&) const;

		drobi operator * (const drobi&) const;

		drobi operator / (const drobi&) const;

		

		drobi operator -() const;

		bool operator == (const drobi&)const;
		

		drobi& operator = (const drobi&);
		bool operator != (const drobi&)const;

		bool operator <= (const drobi&)const;
		bool operator < (const drobi&)const;
		bool operator > (const drobi&)const;
		bool operator >= (const drobi&)const;
		friend ostream& operator<< (ostream& , const drobi& );
		drobi(long = 0, long = 1);
		drobi(const drobi&);
	};



	class my_exception : public exception
	{
	public:
		my_exception(const char* const message)
			: exception(message) {}
		my_exception(const my_exception& right)
			: exception(right) {}
	};