#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int answer;
bool visit[101];
int n, m;
vector<int> computer[101];

void input()
{
    cin >> n >> m;
    for(int i = 0; i < m; i++)
    {
        int from, to;
        cin >> from >> to;
        computer[from].push_back(to);
        computer[to].push_back(from);
    }
}

void dfs(int x)
{
    answer++;
    visit[x] = true;
    for(int i = 0; i < computer[x].size(); i++)
    {
        if(!visit[computer[x][i]])
        {
            cout << "computer : "<< computer[x][i] << endl;
            dfs(computer[x][i]);
        }
    }
    return;
}

int main()
{
    input();
    dfs(1);
    cout << answer << endl;
    return 0;
}