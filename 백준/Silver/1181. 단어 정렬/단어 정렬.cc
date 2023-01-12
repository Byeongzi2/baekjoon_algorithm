#include<bits/stdc++.h>
using namespace std;

int N;
vector<string> v;
string s;

bool cmp(const string &a, const string &b) {
	if(a.size()<b.size()) return true;
	else if (a.size()==b.size()) {
		for(int i=0;i<a.size();i++) {
			if(a[i]-'a' < b[i]-'a') return true;
			else if (a[i]-'a' == b[i]-'a') continue;
			else return false;
		}
		return false;
	}
	else return false;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin>>N;
	while(N--) {
		cin>>s;
		v.push_back(s);
	}

	sort(v.begin(),v.end(),cmp);
	v.erase(unique(v.begin(),v.end()),v.end());
	 
	for(int i=0;i<v.size();i++) {
		cout<<v[i]<<'\n';
	}
	return 0;
}