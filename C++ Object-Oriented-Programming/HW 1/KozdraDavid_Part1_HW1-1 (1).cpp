#include <iostream>
using namespace std;

//David Kozdra last sucessful compile 9/16/2020

//recusive GCD
int GCD(int a, int b) {
	if (b != 0) {
		return (b, a % b);
	}
	else {
		return a;
	}
}

int main()
{
	int a, b = 0;
	cout << "First Number:" << endl;
	cin >> a;
	cout << "Second Number" << endl;
	cin >> b;

	cout << "Greatest Common Divisor : " << GCD(a, b);
	return 0;
}
