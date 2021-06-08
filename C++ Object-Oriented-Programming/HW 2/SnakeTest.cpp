#include <iostream>
#include "Snake.h"
using namespace std;

int main()
{
    Snake Drake = Snake();
    Snake Blake = Snake("Red", 4.51, true);
    Drake.SetColor("Neon Green");
    cout << "__ Values for Drake the Snake ___" << endl;
    Drake.display();
    cout << "__ Values for Blake The Snake ___" << endl;
    Blake.display();
    Drake.bite();
}
