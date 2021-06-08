#include <iostream>
using namespace std;

class Time { 

	private:
		unsigned int hours;
		unsigned int minutes;

	public:
		Time(unsigned int h, unsigned int m ){
			hours = h;
			minutes = m;
		}

		void showTime() {
			cout << hours << " : " << minutes<<endl;
		}

		Time operator + (const Time& time) const {
			Time newtime = Time(hours,minutes);
			newtime.hours + time.hours;
			newtime.minutes + time.minutes;
			return newtime;
		}

		bool operator > (const Time& time) const {
			Time newtime = Time(hours, minutes);
			if (newtime.hours == time.hours) {
				return newtime.minutes > newtime.minutes;
			}
			else {
				return newtime.hours > newtime.hours;
			}
		}

		Time operator - (const Time& time) const {
			Time newtime = Time(hours, minutes);
			newtime.hours - time.hours;
			newtime.minutes - time.minutes;
			return newtime;
		}
};