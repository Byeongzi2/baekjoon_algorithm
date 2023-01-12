#include <iostream>
#include <math.h>
#include <cstdio>
#include <cmath>
#include <string>
#include <vector>
#include <algorithm>
#include <string.h>
#include<stdio.h>
#include <cstring>
#include <set>
#include <map>
#include <queue>
#include <stack>
using namespace std;


int main() {
	ios::sync_with_stdio(0); cin.tie(0);
	string s;
	getline(cin, s);
	sort(s.begin(), s.end(),greater<>());
	for (int i = 0; i < s.length(); i++) {
		cout << s[i];
	}
	return 0;
}

