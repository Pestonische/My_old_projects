#include <iostream>
#include <vector>
#include <algorithm>
#pragma warning (disable : 4996)

using namespace std;

bool compare(pair<bool, long double> a , pair<bool, long double> b )
{
	if (a.second == b.second)
		return a.first;
	return a.second < b.second;
}

int main()
{
	freopen("rect.in", "r", stdin);
	freopen("rect.out", "w", stdout);
	long long x_max, y_max, N;
	cin >> x_max >> y_max >> N;
	long double* mas1 = new long double[2 * N];
	long double* mas2 = new long double[2 * N];
	for (int i = 0; i < 2*N; i+=2)
	{
		cin >> mas2[i];
		cin >> mas1[i];
		cin >> mas1[(i+1)];
		cin >> mas2[(i+1)];
	}
	
	vector<pair<bool, long double>> tg;
	for (int i = 0; i < 2 * N; i += 2)
	{	
		tg.push_back(make_pair(true, mas1[i] / mas1[i + 1]));	
		tg.push_back(make_pair(false, mas2[i + 1] / mas2[i]));	
	}
	
	long double tga = 0;
	
	for (int i = 0; i < 2 * N; i++)
	{
		tga = tg[i].second * x_max;
		if (tga > y_max)
		{
			tga = y_max / tg[i].second;
			if (tga != (long long)tga)
			{
				if(tg[i].first==true)
				tga = floor(tga); 
				if (tg[i].first == false)
				tga = ceil(tga);
			}
			tg[i].second= y_max / tga;
		}
		else
		{
			if (tga != (long long)tga)
			{
				if (tg[i].first == true)
					tga = ceil(tga);
				if (tg[i].first == false)
					tga = floor(tga);
			}
			tg[i].second = tga / x_max;
		}
	}	
	sort(tg.begin(), tg.end(), compare);
	long long max = 0, a = 0, b = 0, g = 0;
	for (int i = 0; i < tg.size(); i++)
	{
		if (tg[i].first == true)
		{
			a++;
		}
		if (tg[i].first == false)
		{
			a--;
		}
		if (max < a)
		{
			max = a;
			b = (long long)(tg[i].second * x_max);
			g = (long long)x_max;
			if (b > y_max)
			{
				b = (long long)y_max;
				g = (long long)(y_max / tg[i].second);
			}
		}
	}
	cout << (long long)max << " " << (long long)g << " " << (long long)b<<endl;
	return 0;
}