#pragma once

class Lion
{
private:
	double weight;
	double height;
	char gender;

public:

	Lion();
	Lion(double _weight, double _height, char _gender);
	double getw();
	void setw(double val);
	double geth();
	void seth(double val);
	double getg();
	void setg(char val);
	void toprint();
	void eat();

};
