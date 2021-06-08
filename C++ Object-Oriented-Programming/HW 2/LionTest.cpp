#include <iostream>
#include "lion.h"
using namespace std;

int main()
{
	Lion Scar = Lion(265.14,2.4,'M');
	Lion SheRa = Lion();
	SheRa.setg('F');
	SheRa.setw(230.64);
	SheRa.seth(2);

	cout << "__ Scar __" << endl;
	Scar.toprint();
	cout << "Scar needs ";
	Scar.eat();
	cout << "  pounds of food" << endl;

	cout << "__ SheRA __" << endl;
	SheRa.toprint();
	cout << "Shera needs ";
	SheRa.eat();
	cout << "  pounds of food" << endl;
}
