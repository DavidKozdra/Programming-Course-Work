// DavidKozdraHW4.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include "DavidKozdraHW4part2.cpp"
#include "DavidKozdraHW4part3.cpp"
using namespace std;


class Animal {

public :

	void grow(){
	
		cout << "grow method  of  Animal  class" << endl;
	}

	void eat() {
		
		cout << "eat method  of  Animal  class" << endl;
	}
	Animal()
	{
		cout << "constructor  of  Animal  class" << endl;
	}

};

class Mammal :public Animal{


public :
	
	void grow() {

		cout << "grow method  of  Mammal  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Mammal  class" << endl;
	}

	Mammal()
	{
		cout << "constructor  of  Mammal  class" << endl;
	}

};

class Cat :public  Mammal {


public:

	void grow() {

		cout << "grow method  of  Cat  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Cat  class" << endl;
	}

	Cat()
	{
		cout << "constructor  of  Cat  class" << endl;
	}

};


class Tiger :public Cat {


public:

	void grow() {

		cout << "grow method  of  Tiger  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Tiger  class" << endl;
	}

	Tiger()
	{
		cout << "constructor  of  Tiger  class" << endl;
	}

};


class Lion : public Cat {


public:

	void grow() {

		cout << "grow method  of  Lion  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Lion  class" << endl;
	}

	Lion()
	{
		cout << "constructor  of  Lion  class" << endl;
	}

};

class Fish : public Animal {


public:

	void grow() {

		cout << "grow method  of  Fish  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Fish  class" << endl;
	}

	Fish()
	{
		cout << "constructor  of  Fish  class" << endl;
	}

};


class Sardine :public Fish {


public:

	void grow() {

		cout << "grow method  of  Sardine  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Sardine  class" << endl;
	}

	Sardine()
	{
		cout << "constructor  of  Sardine  class" << endl;
	}

};


class Bass :public Fish {


public:

	void grow() {

		cout << "grow method  of  Bass  class" << endl;
	}

	void eat() {

		cout << "eat method  of  Bass  class"<<endl;
	}

	Bass()
	{
		cout << "constructor  of  Bass  class" << endl;
	}

};


void display(Animal& a1) {
	a1.eat(); 
	a1.grow(); 
}



int main()
{
	Lion Simba = Lion();
	Tiger Tigger = Tiger();
	Bass BigMouth = Bass();
	Sardine S = Sardine();

	display(Simba);
	display(Tigger);
	display(BigMouth);
	display(S);


	Rectangle one = Rectangle(10,5);
	Rectangle two = Rectangle(7, 3);

	if (one < two) {
		cout << "Smaller" << endl;
	}
	 if(one >= two){
		cout << "Bigger "<<endl;
	}
	if(one != two){
		cout << "Not equal " << endl;
	}
	else {
		cout << " Equal " << endl;
	}
	
	Time current = Time(2,30);
	current.showTime();
	Time past = Time(2,15);
	past.showTime();
	current = current + past;
	current.showTime();
	Time future = Time(10,50);
	future.showTime();
	past = past -  future;
	past.showTime();
}
