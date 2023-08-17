#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <queue> 
using namespace std;


void main()
{
	int n;
	long long el;
	vector<long long> sums;
	priority_queue<long long, vector<long long>, greater<long long> > myQueue;
	long long sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> el;
		myQueue.push(el);
	}
	while (myQueue.size() != 1)
	{
		long long one = myQueue.top();
		myQueue.pop();
		long long two = myQueue.top();
		myQueue.pop();
		sums.push_back(one + two);
		myQueue.push(one + two);
	}
	for (int i = 0; i < sums.size(); i++)
		sum += sums[i];
	cout << sum;
}