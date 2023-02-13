//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int minimumDays(int s, int n, int m){
      int sund=s/7;
      
      int byd=s-sund;
      int food=s*m;
      
      int c=0;
      if(food%n==0){
          c=food/n;
      }else{
          c=food/n +1;
      }
      
      
      return (c<=byd)?c:-1;
    }
};
//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int S, N, M;
        cin>> S >> N >> M;
        
        Solution ob;
        cout<<ob.minimumDays(S, N, M)<<endl;
    }
    return 0;
}
// } Driver Code Ends