#pragma once
#include <string>
#include <Mutex>
#include <thread>
#include <iostream>

using namespace std;

mutex mtx;

class dad_mom
{
 private: 
	   int times;
	   int repeats;
	   string message;
	   

 public:
	 static int total_number_of_repeats;
	 dad_mom()
	 {
		 message = ' ';
		 repeats = 0;
		 times = 0;
	 }
	dad_mom(string amessage, int atimes, int arepeats) 
	{
		message = amessage;
		repeats = arepeats;
		times = atimes;
	}
	

	void Set()
	{
		while (repeats != 0 && total_number_of_repeats != 0)
		{
			if (total_number_of_repeats > 0)
			{
				mtx.lock();
				cout << message << endl;
				total_number_of_repeats--;
				mtx.unlock();
				repeats--;
				this_thread::sleep_for(chrono::milliseconds(times));

			}
			else
			{
				break;
			}
		}
	}
};