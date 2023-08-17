#pragma warning(disable : 4996)
#include <iostream>
#include <fstream>

using namespace std;

struct DisjointSetUnion
{
    long long* size;
    long long* parent;
}dd;

void init(long n)
{
    dd.size = new long long[n + 1];
    dd.parent = new long long[n + 1];

    for (long i = 1; i <= n; i++)
    {
        dd.size[i] = 1;
        dd.parent[i] = i;
    }
}

long FindSet(long x)
{
    if (x == dd.parent[x])
    {
        return x;
    }
    dd.parent[x] = FindSet(dd.parent[x]);
    return dd.parent[x];
}

bool Union(long x, long y)
{
    x = FindSet(x);
    y = FindSet(y);
    if (x != y)
    {
        if (dd.size[x] < dd.size[y])
        {
            long q = x;
            x = y;
            y = q;
        }
        dd.parent[y] = x;
        dd.size[x] += dd.size[y];
        return true;
    }
    return false;
}
        
int main()
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    long size;
    long s;
    scanf("%ld", &size);
    scanf("%ld", &s);
    
    init(size);
    long a = 0;
    long b = 0;
    for (long i = 0; i < s; i++)
    {        
        scanf("%ld", &a);
        scanf("%ld", &b);
        
        if (Union(a, b))
        {
            size--;
        }     
        
        printf("%ld\n", size);
        
    }
}