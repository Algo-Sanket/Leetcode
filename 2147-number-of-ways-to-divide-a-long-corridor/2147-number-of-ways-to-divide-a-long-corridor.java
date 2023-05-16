class Solution 
{
    public int numberOfWays(String s) 
    {
    long res = 1;
    int j = 0;
    int k = 0;
    long mod = (long)1e9 + 7;
    for (int i = 0; i < s.length(); i++) 
    {
        if (s.charAt(i) == 'S')
        {
            k++;
            if (k > 2 && k % 2 == 1) 
            {
                res = (res * (i - j)) % mod;
            }
            j = i;
        }
    }
    if (k % 2 == 0 && k > 0)
    {
        return (int) res;
    } else 
    {
        return 0;
    }
}
}
