#define _USE_MATH_DEFINES
#include <omp.h> 
#include <iostream> 
#include <time.h>
#include <cmath>
#include <algorithm>
const double real_in = 6.450515242956587;

using namespace std;

double f_1(double x) {
    return 1 - cos(x);
}
double f_2(double x) {
    return x - M_PI / 2;
}

int main(int argc, char* argv[])
{
    unsigned int numThreads = atoi(argv[1]);
    omp_set_num_threads(numThreads);

    const double a = 0;
    const double b = 5;
    const int N = atoi(argv[2]) + 1;


    double size = (b - a) / N;
    double summ = 0;

    clock_t start = clock();

#pragma omp parallel for reduction(+:summ)
    for (int i = 1; i < N; i++)
    {
        double a_i = a + i * size;
        double b_i = a_i + size;
        double a_b_i = (a_i + b_i) / 2;

#pragma omp critical
        {
            if (0 <= b_i && b_i <= M_PI / 2)
                summ += (b_i - a_i) * (f_1(a_i) + 4 * f_1(a_b_i) + f_1(b_i)) / 6;
            else
                summ += (b_i - a_i) * (f_2(a_i) + 4 * f_2(a_b_i) + f_2(b_i)) / 6;
        }
    }

    cout << "for " << N << " points \n Integrate is " << summ;
    cout << "\nReal integrate is " << real_in;
    cout << "\nError of calculus is " << real_in - summ << endl;

    clock_t end = clock();
    double seconds = (double)(end - start) / CLOCKS_PER_SEC;
    printf("The time: %f seconds\n", seconds);
}