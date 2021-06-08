#include "Snake.h"



	Snake::Snake() {
		color = "green";
		length = 1;
		venamous = false;
	}

	Snake::Snake(string _color, double _length, bool _venamous) {
		color = _color;
		length = _length;
		venamous = _venamous;
	}

	string Snake::getColor() {
		return color;
	}

	void Snake::SetColor(string value) {
	
		color = value;
	}
	double Snake::getLength() {
		return length;
	}

	void Snake::SetLength(double value) {
		length = value;
	}
	
	bool Snake::getVenamous() {
		return venamous;
	}

	void Snake::SetVenamous(bool value) {
		venamous = value;
	}

	void Snake::display() {
		
		cout << "Color :" << color << endl;
		cout << "Length :" << length << " ft" <<endl;
		cout << "Venemous :" << venamous  <<endl;

	}
	void Snake::bite() {
		if (venamous) {
			cout << "Bitten by a venemous snake :("<< endl;
		}
		else {
			cout << "Bitten by a nonvenemous snake :(" << endl;
		}
	}


