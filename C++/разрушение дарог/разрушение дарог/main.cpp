#pragma warning(disable : 4996)
#include <iostream>
#include <fstream>
#include <vector>

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
    long cities;
    long road;
    long explosions;

    scanf("%ld", &cities);
    scanf("%ld", &road);
    scanf("%ld", &explosions);

    long first = 0;
    long second = 0;
    vector <pair<long, long>> roads;
    pair<long, long> r;
    r.first = 0;
    r.second = 0;
    roads.push_back(r);
    vector <long> check;
    for (long i = 1; i < road + 1; i++)
    {
        scanf("%ld", &first);
        scanf("%ld", &second);
        r.first = first;
        r.second = second;
        roads.push_back(r);
        check.push_back(1);
    }
    long explosion = 0;
    vector <long> explosionss;
    explosionss.push_back(0);
    init(cities);
    long city = cities;
    
    for (long i = 1; i < explosions + 1; i++)
    {
        scanf("%ld", &explosion);
        explosionss.push_back(explosion);
        check[explosion] = 0;
    }
    for (long i = 1; i < road + 1; i++)
    {
        if (check[i] == 1)
        {
            if (Union(roads[i].first, roads[i].second))
            {
                city--;
            }
        }
    }
    vector <long> answer;
    if (city != 1)
    {
        answer.push_back(0);
    }
    else
    {
        for (int i = 0; i < explosions; i++)
        {
            printf("%ld", 1);
        }
        return 0;
    }    
    long g = 1;
    for (long i = explosions; i > 0; i--)
    {        
        if (Union(roads[explosionss[i]].first, roads[explosionss[i]].second))
        {
            city--;
        }
        if (city != 1)
        {
            if (g < explosions)
            answer.push_back(0);
        }
        else
        {
            if(g < explosions)
            answer.push_back(1);
        }
        g++;
    }
    for (long i = explosions-1; i >= 0; i--)
    {
        printf("%ld", answer[i]);
    }
    return 0;
}