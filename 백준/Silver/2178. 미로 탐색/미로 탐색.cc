#include<bits/stdc++.h>
using namespace std;
#define MAXN 101

struct Data {
	int x,y;
	Data(){};
	Data(int x, int y) : x(x), y(y) {};
};

int N,M;
int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,-1,1};
int arr[MAXN][MAXN],cnt[MAXN][MAXN];
bool visited[MAXN][MAXN];
void bfs(Data d) {
	queue<Data> q;
	q.push(d);
	visited[d.x][d.y] = true;
	cnt[d.x][d.y] = 1;
	Data curr,next;
	int nx,ny;
	while(!q.empty()) {
		curr = q.front();
		q.pop();
		for(int i=0;i<4;i++) {
			nx = curr.x+dx[i];
			ny = curr.y+dy[i];
			if(nx<0||nx>=N||ny<0||ny>=M||arr[nx][ny]==0) continue;
			if(!visited[nx][ny]) {
				visited[nx][ny] = true;
				cnt[nx][ny] += cnt[curr.x][curr.y];
				q.push(Data(nx,ny));
			}
		}
	}
	
	
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin>>N>>M;
	string s;
	for(int i=0;i<N;i++) {
		cin>>s;
		for(int j=0;j<M;j++) {
			arr[i][j] = s[j]-'0';
			cnt[i][j] = 1;
		}
	}
	bfs(Data(0,0));
	cout<<cnt[N-1][M-1];
	return 0;
}