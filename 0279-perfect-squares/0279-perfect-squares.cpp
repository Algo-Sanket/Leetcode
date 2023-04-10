class Solution {

public:
	int find(int n, vector<int>&v){
		if(n==0)return v[n]=0;
		if(n==1)return v[n]=1;
		if(n<4)return v[n]=n;
		if(v[n]!=1e9)return v[n];
		int i=2;
		while(i*i<=n){
			v[n]=min(v[n], 1+find(n-(i*i), v));
			i++;
		}
		return v[n];
	}
	int numSquares(int n) {
		vector<int>v(n+1, 1e9);
		return min(n, find(n, v));
	}
};