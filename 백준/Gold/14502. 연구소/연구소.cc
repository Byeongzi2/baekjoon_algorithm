#include<iostream>
#include<vector>
#include<queue>

using namespace std;
#define MAXN 9

struct Data {
	int x, y;
	Data() {};
	Data(int x, int y) : x(x), y(y) {};
};

int N, M, cnt, MAX;
int lab[MAXN][MAXN], copylab[MAXN][MAXN], check[65];
vector<Data> virus, blank;
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };

void init() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			copylab[i][j] = lab[i][j];
		}
	}
}

void bfs() {
	queue<Data> q;
	for (int i = 0; i < virus.size(); i++) q.push(virus[i]);
	int nx, ny;
	Data curr;
	while (!q.empty()) {
		curr = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			nx = curr.x + dx[i];
			ny = curr.y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (copylab[nx][ny] != 0) continue;
			copylab[nx][ny] = 2;
			q.push(Data(nx, ny));
		}
	}
}

int checkBlank() {
	int tmp=0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (copylab[i][j] == 0) tmp++;
		}
	}
	return tmp;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> lab[i][j];
			if (lab[i][j] == 2) virus.push_back(Data(i, j));
			if (lab[i][j] == 0) blank.push_back(Data(i, j));
		}
	}
	cnt = blank.size();

	for (int i = 0; i < cnt - 2; i++) {
		for (int j = i + 1; j < cnt - 1; j++) {
			for (int h = j + 1; h < cnt; h++) {
				init();
				copylab[blank[i].x][blank[i].y] = 1;
				copylab[blank[j].x][blank[j].y] = 1;
				copylab[blank[h].x][blank[h].y] = 1;

				bfs();
				MAX = max(MAX, checkBlank());
			}
		}
	}
	cout << MAX;
	return 0;
}