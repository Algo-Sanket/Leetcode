class Solution {
    public int longestAwesome(String s) 
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        int state=0;
        int ans=0;
        map.put(0,-1);
        int n=s.length();
        for(int i=0;i<n;i++){
             char ch =s.charAt(i);
        
        int mask=(1<<(ch-'0'));
        state=state^mask;
        Integer j=map.get(state);
        if(j!=null)
        {
            ans=Math.max(ans,i-j);
        }
        for(int odd=0;odd<10;odd++)
        {
            mask=1<<odd;
              j=map.get(state^mask);
            if(j!=null)
            {
                ans=Math.max(ans,i-j);
            }
        }
          if(map.containsKey(state)==false)
          {
              map.put(state,i);
          }
        }
           return ans;  
}}