#include <set>
#include <vector>
#include <algorithm>
#include <functional>
#include <fstream>
#include <iostream>

using namespace std;
using namespace std::placeholders;

typedef pair<int, int>         point_t;
typedef set<point_t>           points_t;
typedef pair<point_t, point_t> line_t;
typedef vector<line_t>         lines_t;
typedef vector<points_t>       groups_t;

bool point_on_line(const point_t& p, const line_t& l)
{
    int dx = l.second.first - l.first.first;
    int dy = l.second.second - l.first.second;
    int x0 = l.first.first;
    int y0 = l.first.second;
    return -dy * (p.first - x0) + dx * (p.second - y0) == 0;
}

bool same_line(const line_t& l0, const line_t& l1)
{
    // compute line directions
    int dx0 = l0.second.first - l0.first.first;
    int dx1 = l1.second.first - l1.first.first;
    int dy0 = l0.second.second - l0.first.second;
    int dy1 = l1.second.second - l1.first.second;
    // compare directions
    if (dx0 * dy1 - dy0 * dx1 != 0)
        return false;
    // check if first point of l0 is on l1
    return point_on_line(l0.first, l1);
}

int main()
{
    // read points from file
    ifstream inp("input.txt");
    int n;
    inp >> n;
    points_t pts;
    while (n--) {
        int x, y;
        inp >> x >> y;
        pts.insert(point_t(x, y));
    }

    // unique lines
    lines_t ls;

    // groups of points on the same line
    groups_t gs;

    // consider all pairs of points
    for (auto p0 = pts.begin(); p0 != pts.end(); ++p0) {
        for (auto p1 = p0; ++p1 != pts.end();) {
            // check if line for pair of points was already considered
            line_t l(*p0, *p1);
            auto it = find_if(ls.begin(), ls.end(), bind(same_line, l, _1));
            if (it != ls.end())
                continue;
            ls.push_back(l);
            // compute all points on the line
            points_t g = { *p0, *p1 };
            for (auto p2 = p1; ++p2 != pts.end();) {
                if (point_on_line(*p2, l))
                    g.insert(*p2);
            }
            if (g.size() > 2)
                gs.push_back(g);
        }
    }

    // print groups of points
    for (size_t i = 0; i < gs.size(); ++i) {
        cout << i << ":";
        for (auto p : gs[i]) {
            cout << " (" << p.first << "," << p.second << ")";
        }
        cout << endl;
    }
}