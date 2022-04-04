#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;

struct Time
{
	int start;
	int end;
	Time(int start, int end) : start(start), end(end) {};
};

bool operator<(Time t1, Time t2)
{
	if (t1.end != t2.end)
		return t1.end > t2.end;
	else
		return t1.start > t2.start;
}

int main()
{
	int n;
	cin >> n;
	int start, end;
	int answer = 0;
	priority_queue<Time> pq;
	for (int i = 0; i < n; i++)
	{
		cin >> start >> end;
		pq.push({ start, end });
	}
	end = -1;
	while (!pq.empty())
	{
		Time t = pq.top();
		pq.pop();
		if (t.start >= end)
		{
			answer++;
			end = t.end;
		}
	}
	cout << answer << endl;
	return 0;
}
