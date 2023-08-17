#include <iostream>

using namespace std;

void Answer(int* mas, int masq, int min, int max, int k)
{
    int one = 0, two = -1, thee = -1;
    int n = max, _max = max, _min = min, _k = k, _masq = masq;
    int m = 0, l = 0;
    for(;;)
    {
        if (!(_min < _max))
        {
            break;
        }
        _k = (_max + _min) / 2;
        if (_masq <= mas[_k] )
        {
            if (_masq == mas[_k])
            {
                one = 1;
            }

            _max = _k;           
        }
        if (_masq > mas[_k])
        {
            _min = _k + 1;
        }
    }
    two = _min;
    _max = max, _min = min, _k = k, _masq = masq;
    for(;;)
    {
        if (!(_min < _max))
        {
            break;
        }
        _k = (_max + _min) / 2;
        if (_masq < mas[_k] )
        {
            _max = _k;
            
        }
        if (_masq >= mas[_k])
        {
             _min = _k + 1;            
        }        
    }
    thee = _min;
    
    cout << one << " " << two << " " << thee << endl;

}

int main()
{
    int index = 0;

    cin >> index;

    int* mas = new int[index];

    for (int i = 0; i < index; i++)
    {
        cin >> mas[i];
    }

    int indexq = 0;

    cin >> indexq;

    int min = 0;

    int max = index;

    int k = max / 2;

    int masq = 0;

    for (int i = 0; i < indexq; i++)
    {
        cin >> masq;
        Answer(mas, masq, min, max, k);
    }
}
