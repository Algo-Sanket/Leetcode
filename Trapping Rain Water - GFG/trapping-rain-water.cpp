//{ Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


// } Driver Code Ends

class Solution{
    public:
    long long trappingWater(int arr[], int n){
        long long ans = 0;
        int left = 0, right = n-1, leftMax = arr[0], rightMax = arr[n-1];
        while(left < right){
            if(leftMax <= rightMax){
                left++;
                leftMax = max(leftMax, arr[left]);
                ans += leftMax - arr[left];
            }
            else{
                right--;
                rightMax = max(rightMax, arr[right]);
                ans += rightMax - arr[right];
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        Solution obj;
        //calling trappingWater() function
        cout << obj.trappingWater(a, n) << endl;
        
    }
    
    return 0;
}
// } Driver Code Ends