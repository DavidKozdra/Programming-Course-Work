

class Rectangle {
private:
	double width,height;

public:
	Rectangle()
	{
			
	}

	Rectangle(double width, double height)
	{
		this->width = width;
		this->height = height;
	}

	double area() {
		return width * height;
	}

	bool operator >= (Rectangle first) {
		Rectangle second = Rectangle(width, height);
		return (second.area() >= first.area());
	}
	  bool operator < (Rectangle first) {
		  Rectangle second = Rectangle(width,height);
		 return (second.area() < first.area());
	 }
	  bool operator != (Rectangle first) {
		  Rectangle second = Rectangle(width, height);
		 return (second.area() != first.area());
	 }
};