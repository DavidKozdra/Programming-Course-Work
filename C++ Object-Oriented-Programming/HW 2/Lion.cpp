#include "Lion.h"
#include <iostream>
using namespace std;

	double weight;
	double height;
	char gender;

	Lion::Lion() {
		weight = 0;
		height = 0;
		gender = 'M';
	}
	Lion::Lion(double _weight, double _height, char _gender) {
		weight = _weight;
		height = _height;
		gender = _gender;
	}

	double Lion::getw() {
		return weight;
	}
	void Lion::setw(double val) {
		weight = val;
	}

	double Lion::geth() {
		return height;
	}

	void Lion::seth(double val) {
		height = val;
	}

	double Lion::getg() {
		return gender;
	}

	void Lion::setg(char val) {
		gender = val;
	}

	void Lion::toprint() {
		cout << " Weight : "<< weight << "lbs" << endl;
		cout << " Height : " << height << "ft"<< endl;
		cout << "Gender : " << gender << endl;
	}

	void Lion::eat() {
		if (gender =='M') {
			cout << 8 << endl;
		}
		else {
			cout << 6 << endl;
		}
	}
