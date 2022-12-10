//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
string buildLowestNumber(string num, int k);
// Driver program to test above function
int main()
{
    int t,n;
    string str;
    cin>>t;
    while(t--)
    {
    cin>>n;
    cin>>str;
    cout << buildLowestNumber(str, n)<<endl;
    }
    return 0;
}

// } Driver Code Ends


string buildLowestNumber(string num, int k)
{

    stack<int> st;

    int n=num.size();

    for(int i=0;i<n;i++){

        while(!st.empty() and st.top()>(num[i]-'0') and k){

            st.pop();

            k--;

        }

        st.push(num[i]-'0');

    }

    while(!st.empty() and k--){

        st.pop();

    }

    string ans="";

    while(!st.empty()){

        ans+=char(st.top()+'0');

        st.pop();

    }

    reverse(ans.begin(),ans.end());

    string r="";

    int i=0;

    while(i<ans.size() and ans[i]=='0') i++;

    if(i==ans.size()) return "0";

    return ans.substr(i);

}