#include <iostream>
using namespace std;

//David Kozdra last sucessful compile 9/16/2020

void shiftR(int* n1, int* n2, int* n3, int* n4, double* average, int* max) {

	// swaping
	int temp1, temp2;
	// n1 = n2 n2 = n3 n3 = n4 n4 = n1
	temp1 = *n3;
	temp2 = *n1;
	*n1 = *n2;
	*n2 = temp1;
	*n3 = *n4;
	*n4 = temp2;

	//array to do math
	int nums[4] = { *n1,*n2,*n3,*n4 };
	// order
	int sum = 0;
	*max = 0;
	for (size_t i = 0; i < 4; i++)
	{
		if (nums[i] > * max) {
			*max = nums[i];
		}
		sum += nums[i];
	}
	*average = double(sum / 4);
}

int main()
{
	int a1 = 1, a2 = 2, a3 = 3, a4 = 4, max = 0;
	double average = 0;
	cout << "number 1 : " << endl;
	cin >> a1;
	cout << "number 2 : " << endl;
	cin >> a2;
	cout << "number 3 : " << endl;
	cin >> a3;
	cout << "number 4 : " << endl;
	cin >> a4;
	shiftR(&a1, &a2, &a3, &a4, &average, &max);
	cout << " first number : " << a1 << " second number : " << a2 << " third number : " << a3 << " fourth number : " << a4 << endl;
	cout << " Average : " << average << " Max : " << max << endl;
	return 0;
}
