
class HWpart2 {

    template <typename T>
    T MaxOfThree(T x, T y, T z)
    {
        if (x > y && x > z) {
            return z;
        }
        else if (y > z && y > x) {
            return y;
        }
        else {
            if (z > y && z > x) {
                return z;
            }
            else {
                cout << "TIE";
                return x;
            }
        }
    }
};
