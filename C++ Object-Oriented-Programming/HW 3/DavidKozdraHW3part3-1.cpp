

class HW3 {


    template <typename T>
    T OddOfArray(T x[], int length)
    {
        T sum = x[1];
        for (size_t i = 2; i < length; i++)
        {
            if (i % 2 != 0) {
                sum += x[i];
            }
        }
        return sum;
    }

    template <typename T>
    void PrintArray(T x[], int length)
    {
        for (size_t i = 1; i < length; i++)
        {
            cout << x[i] << endl;
        }
    }


};
