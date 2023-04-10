//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String secFrequent(String arr[], int N) {
        Map<String, Integer> freq = new HashMap<>();
        for (String string : arr) {
            freq.put(string, freq.getOrDefault(string, 0) + 1);
        }
        List<Map.Entry<String, Integer>> sortedFreq = new ArrayList<>(freq.entrySet());
        Collections.sort(sortedFreq, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        return sortedFreq.get(1).getKey();
    }
}