#include<bits/stdc++.h>
using namespace std;
#define MAXN 101

struct Data {
	int x,y;
	Data(){};
	Data(int x, int y) : x(x), y(y) {};
};

int N,area1,area2;
char normal[MAXN][MAXN],weakness[MAXN][MAXN];
bool visited1[MAXN][MAXN],visited2[MAXN][MAXN];
int dx[4] ={-1,1,0,0,};
int dy[4] = {0,0,-1,1};

void bfs(int x, int y,char color,char paint[MAXN][MAXN],bool visited[MAXN][MAXN]) {
	queue<Data> q;
	q.push(Data(x,y));
	Data curr,next;
	int nx,ny;
	while(!q.empty()) {
		curr = q.front();
		q.pop();
		visited[curr.x][curr.y] = true;
		for(int i=0;i<4;i++) {
			nx = curr.x+dx[i];
			ny = curr.y+dy[i];
			if(nx<0||nx>=N||ny<0||ny>=N) continue;
			if(visited[nx][ny]||paint[nx][ny]!=color) continue;
			visited[nx][ny] = true;
			q.push(Data(nx,ny));
		}
	}
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string s;
	cin>>N;
	for(int i=0;i<N;i++) {
		cin>>s;
		for(int j=0;j<N;j++) {
			normal[i][j] = s[j];
			if(s[j]=='G') weakness[i][j] = 'R';
			else weakness[i][j] = s[j];
		}
	}
	
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(!visited1[i][j]) {
				bfs(i,j,normal[i][j],normal,visited1);
				area1++;
			}
			if(!visited2[i][j]) {
				bfs(i,j,weakness[i][j],weakness,visited2);
				area2++;
			} 
		}
	}
	cout<<area1<<" "<<area2;
	return 0;
}