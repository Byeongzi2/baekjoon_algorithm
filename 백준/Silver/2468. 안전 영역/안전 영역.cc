#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;
#define MAXN 101

struct Data {
	int x, y;
	Data() {};
	Data(int x, int y): x(x), y(y) {};
};
int N, cnt, MAX;
int arr[MAXN][MAXN];
bool exist[MAXN], visited[MAXN][MAXN];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };
priority_queue<int, vector<int>, greater<int> >pq;
vector<Data> v[MAXN];
void dfs(int x, int y, int h) {
	visited[x][y] = true;
	int nx, ny;
	for (int i = 0; i < 4; i++) {
		nx = x + dx[i];
		ny = y + dy[i];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
		if (visited[nx][ny] || arr[nx][ny] <= h) continue;
		dfs(nx, ny, h);
	}
}
void init() {
	cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = false;
		}
	}
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
			v[arr[i][j]].push_back(Data(i, j));
			if (!exist[arr[i][j]]) {
				exist[arr[i][j]] = true;
				pq.push(arr[i][j]);
			}
		}
	}
	int rain;
	Data curr;
	MAX = 1;
	while (!pq.empty()) {
		rain = pq.top();
		pq.pop();
		for (int i = rain + 1; i < MAXN; i++) {
			if (!exist[i]) continue;
			for (int j = 0; j < v[i].size(); j++) {
				curr = v[i].at(j);
				if (!visited[curr.x][curr.y]) {
					dfs(curr.x, curr.y, rain);
					cnt++;
				}
			}
		}
		MAX = max(MAX, cnt);
		init();

	}
	cout << MAX<<'\n';
	return 0;

}