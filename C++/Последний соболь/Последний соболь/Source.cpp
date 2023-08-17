#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#include <fstream>
using namespace std;


//vector<long long> routes;
deque<long long> routes;
long long route_last = 0;
bool checker = false;
bool checker_route[10001][10001] = { false };
int n = 0, m = 0;

bool DFS(long long route1, long long route2, vector<pair<long long, long long>> crossroads)
{    
    if (route2 == route_last)
    {
        routes.push_back(route_last);
        checker = true;
        return checker;
    }
    for (int i = 1; i <= n; i++) {
        if (i != route2 && (crossroads[route1].first != crossroads[i].first || crossroads[route1].second != crossroads[i].second)) {
            if (checker_route[route2][i]) {

                long long  D = crossroads[route1].first * crossroads[route2].second + crossroads[i].first * crossroads[route1].second + crossroads[route2].first * crossroads[i].second
                    - crossroads[i].first * crossroads[route2].second - crossroads[route1].first * crossroads[i].second - crossroads[route2].first * crossroads[route1].second;
                if (D > 0)
                {
                    continue;
                }
                if (!checker)
                {
                    routes.push_back(route2);
                    checker_route[route2][i] = false;
                    DFS(route2, i, crossroads);
                    if (!checker)
                    {
                        routes.pop_back();
                    }
                }
            }
        }
    }
    
}


int main() {
    ifstream in;
    ofstream out;

    in.open("input.txt");
    out.open("output.txt");

    in >> n;
    in >> m;

    vector<pair<long long, long long>> crossroads(m+5);

    long long x1, y1, x2, y2, route1, route2;
    for (int i = 0; i < m; i++)
    {
        in >> x1;
        in >> y1;
        in >> x2;
        in >> y2;
        in >> route1;
        in >> route2;
        crossroads[route1].first = x1;
        crossroads[route1].second = y1;
        crossroads[route2].first = x2;
        crossroads[route2].second = y2;
        checker_route[route2][route1] = true;
        checker_route[route1][route2] = true;
    }

    in >> route1;
    in >> route2;
    crossroads[0].first = crossroads[route1].first;
    crossroads[0].second = crossroads[route1].second - 1;
    route_last = route2;
    checker_route[0][route1] = false;
    in.close();
    DFS(0, route1, crossroads);
    if (checker)
    {
        out << "Yes\n";
        for (long long i = 0; i < routes.size(); i++)
        {
            out << routes[i] << " ";
        }
    }
    else
    {
        out << "No";
    }
    out.close();
}