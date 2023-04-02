class Solution {
      public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();
    boolean[][] dp = new boolean[n+1][m+1];
    dp[0][0] = true;
    
    for (int j = 2; j <= m; j++) {
        if (p.charAt(j-1) == '*' && dp[0][j-2]) {
            dp[0][j] = true;
        }
    }
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            char c = s.charAt(i-1);
            char pChar = p.charAt(j-1);
            if (pChar != '*') {
                dp[i][j] = (c == pChar || pChar == '.') && dp[i-1][j-1];
            } else {
                dp[i][j] = dp[i][j-2] || (c == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j];
            }
        }
    }
    
    return dp[n][m];
}
  
    }