using namespace std;
#include <string>

class Person {
public :

	string name, address, phonenumber, email;

	Person(string name, string address, string phonenumber, string email)
	{
		this->name = name;
		this->address = address;
		this->phonenumber = phonenumber;
		this->email = email;
	}
	Person()
	{
			
	}

	const virtual string ToString() {
		return "Name : " + name + "\n Address " + address + "\n PhoneNumber: " + phonenumber + "\n Email :" + email;
	}

};

class Student : public Person {
	enum ClassStatus { Freshman,Softmore, Jr, Senior };


public:
	Student(string name)
	{
		this->name = name;
	}

	const virtual string ToString() {
		return "Student : "+ name;
	}
};

class MyDate {
	string month;
	int day, year;

public :
	MyDate()
	{
			
	}
	MyDate(int day,string month,int year)
	{
		this->day = day;
		this->month = month;
		this->year = year;
	}
	
};


class Employee : public Person {

	string office;
	MyDate datehired;
	int salary;

public :

	Employee(string name)
	{
		this->name = name;
	}
	Employee()
	{
			
	}

	const virtual string ToString() {
		return "Employee : " + name;
	}
};

class Staff : public Employee {

	string title;
public:

	Staff(string title,string name)
	{
		this->name = name;
		this->title = title;
	}
	const virtual string ToString() {
		return "Staff : " + name + " Title " + title;
	}
};

class Faculty : public Employee {

	string office, rank;

public:
	Faculty(string rank,string name)
	{
		this->name = name;
		this->rank = rank;
	}

	const virtual string ToString() {
		return "Faculty : " + name + "  Rank " + rank;
	}
};

