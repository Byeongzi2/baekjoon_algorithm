#include<bits/stdc++.h>
using namespace std;
#define MAXN 501


int M,N;
int mapp[MAXN][MAXN],dp[MAXN][MAXN];
int dxy[4] = {-1,1,0,0};

int dfs(int x, int y) {
	if(x==0&&y==0) {
		return 1;
	}
	if(dp[x][y]!=-1) return dp[x][y];
	dp[x][y] = 0;
	int nx,ny;
	for(int i=0;i<4;i++) {
		nx = x+dxy[i];
		ny = y+dxy[3-i];
		if(nx<0||nx>=M||ny<0||ny>=N) continue;
		if(mapp[nx][ny]<=mapp[x][y]) continue;
		dp[x][y] += dfs(nx,ny);
	}
	return dp[x][y];
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin>>M>>N;
	for(int i=0;i<M;i++) {
		for(int j=0;j<N;j++) {
			cin>>mapp[i][j];
			dp[i][j] = -1;
		}
	}
	cout<<dfs(M-1,N-1);
	
	
	return 0;
}