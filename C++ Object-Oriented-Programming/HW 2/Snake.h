#include <string.h>
#include <iostream>
using namespace std;

class Snake
{
private:
	string color;
	double length;
	bool venamous;

public:
	Snake();
	Snake(string _color , double _length, bool venamous);

	string getColor();
	void SetColor(string value);
	double getLength();
	void SetLength(double value);
	bool getVenamous();
	void SetVenamous(bool value);
	void display();
	void bite();
};

