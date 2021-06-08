using namespace std;
#include <string>
#include <cmath>

class GeometricObject {
    //File Name: GeometricObject.cpp
public:
    string color;
    bool filled;

    GeometricObject()
    {
        color = "White";
        filled = false;
    }

    GeometricObject(const string& color, bool filled)
    {
        this->color = color;
        this->filled = filled;
    }

    string getColor() const
    {
        return color; //return this->color
    }

    bool getFilled() const
    {
        return filled;
    }

    void setColor(const string& color)
    {
        this->color = color;
    }

    void setFilled(bool filled)
    {
        this->filled = filled;
    }

    string toString() const
    {
        return "Geometric Object";
    }

};

class Triangle : public GeometricObject {

    double side1, side2, side3;
public :

    const double getArea() {
        double s = getParameter() / 2.0;
        return sqrt(abs(s * (s - side1) * (s - side2) * (s - side3)));
            // abs(s * (s - side1) * (s - side2) * (s - side3));
    }
    const double getParameter() {
        return side1 + side2 + side3;
    }

    const double getside1() {
        return side1;
    }
    const double getside2() {
        return side2;
    }
    const double getside3() {
        return side3;
    }
    Triangle()
    {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }
    Triangle(double one,double two,double three)
    {
        side1 = one;
        side2 = two;
        side3 = three;
    }

};
