//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        Map<Long, Integer> map= new HashMap<Long, Integer>();
        //Your code here
        int count=0;
        for(int i=0;i<N;i++)
        {
            if(map.get(A[i])==null)
            map.put(A[i],1);
            else
            {
                count=map.get(A[i]);
                count++;
                map.put(A[i],count);
            }
        }
        for(int i=0;i<N;i++)
        {
            if(!map.containsKey(B[i]))
            return false;
            if(map.get(B[i])==0)
            return false;
            count = map.get(B[i]);
            --count;
            map.put(B[i], count);
            
        }
        return true;
    }
}