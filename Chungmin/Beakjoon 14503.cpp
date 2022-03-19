#include<iostream>
#include<queue>
#include<algorithm>
#define MAX_SIZE 51
using namespace std;

int N, M;
int rx, ry, direction;
int board[MAX_SIZE][MAX_SIZE];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,-1,0,1 };

int answer;
void DFS(int x, int y, int direction)
{
	if (!board[x][y])
	{
		answer++;
		board[x][y] = 2;
	}
	int i;
	for (i = direction + 1; i < direction + 5; i++)
	{
		int next_x = x + dx[i % 4];
		int next_y = y + dy[i % 4];
		if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M)
		{
			if (!board[next_x][next_y])
				DFS(next_x, next_y, i % 4);
		}
	}
	int xx = x + dx[(direction + 2) % 4];
	int yy = y + dy[(direction + 2) % 4];
	if (board[xx][yy] == 2)
		DFS(xx, yy, direction % 4);
	else if (board[xx][yy] == 1)
	{
		cout << answer << endl;
		exit(0);
	}
}

int main()
{
	cin >> N >> M;
	cin >> rx >> ry >> direction;
	if (direction == 3)
		direction = 1;
	else if (direction == 1)
		direction = 3;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> board[i][j];
		}
	}
	DFS(rx, ry, direction);
	cout << answer << endl;
	return 0;
}