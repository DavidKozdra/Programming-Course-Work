// Lab13.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Source.cpp"
#include "Source1.cpp"
using namespace std;

template <typename T1>
T1 Find(T1 a[], T1 key,int len) {
	for (size_t i = 0; i < len; i++)
	{	
		if (a[i] == key) {
			std::cout << "found " << key <<" at index :  ";
			return i;
		}
	}
	std::cout << "Key not found";
	return -1;
}


int main()
{
	int numbers[] = { 1,2,3,4,5};
	double decimals[] = { .5,231.5,2412.23,50.5,5.0 };
	char c[] = { '5','/','g','t','1' };

	cout << "Search " << endl;
	std::cout << Find(numbers,4,5) <<endl;
	std::cout << Find(decimals,.50, 5);
	std::cout << Find(c, 'b', 5) << endl;


	cout << "Triangle " << endl;

	double side1, side2, side3;
	cout << "enter value for side 1 ";
	cin >> side1;
	cout << "enter value for side 2 ";
	cin >> side2;
	cout << "enter value for side 3 ";
	cin >> side3;

	Triangle T = Triangle(side1, side2, side3);
	cout << "Parameter :"<< T.getParameter() << endl;
	cout << "Area :"<< T.getArea() << endl;

	cout << "Set color" << endl;
	cin >> T.color;
	cout << "is it filled 0 not filled 1 filled" << endl;
	cin >> T.filled;

	cout << "Color : "<<T.color;
	cout << "The triangle is ";
	if (T.filled) {
		cout << "filled" << endl;
	}
	else {
		cout << "Not Filled" << endl;
	}

	cout << "Persons" << endl;

	Person p = Person("Andrew", "6357 Drewerlane","888-121-1241","andrewiscool@mailme.com");
	cout << p.ToString() <<endl;
	Student s = Student("Rachel");
	cout << s.ToString() << endl;
	Employee E = Employee("Matt");
	cout << E.ToString() << endl;
	Faculty f = Faculty("Janitor","Cat");
	cout << f.ToString() << endl;
	Staff S = Staff("Princible","Shapard");
	cout << S.ToString() << endl;

}