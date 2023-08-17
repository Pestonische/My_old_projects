#include <iostream>
#include <vector>
#include <fstream>
using namespace std;


int main()
{

    ifstream in;
    ofstream out;
    in.open("input.txt");
    out.open("output.txt");
    int a = 0;
    in >> a;
    vector <int> mas;
    int i = 0;
    while (!in.eof())
    {
        int f;
        in >> f;
        mas.push_back(f);
        
    };
    in.close();
    vector <int> mas1 (a);
    
    for (int i = 0; i < a; i++)
    {
        mas1[i] = (-1);
    }
    mas1[0] = mas[0];
    for (int i = 0; i < a; i++)
    {
        if (mas1[i] == (-1))
            continue;
        if (i + 2 < a)
        {
            mas1[i + 2] = max(mas1[i + 2], mas1[i] + mas[i + 2]);
            
        }
        if (i + 3 < a)
        {
            mas1[i + 3] = max(mas1[i + 3], mas1[i] + mas[i + 3]);

        }
        

       
    } 
    out << mas1[a-1];
    out.close();

}