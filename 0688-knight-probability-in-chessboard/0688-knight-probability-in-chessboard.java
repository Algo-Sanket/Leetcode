class Solution {
    public double knightProbability(int n, int k, int row, int column) {
    // Define the 8 possible moves
    int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    // Initialize the dp array
    double[][][] dp = new double[n][n][k+1];

    // Base case: set dp[i][j][0] = 1 if (i, j) is the starting position
    dp[row][column][0] = 1;

    // Compute the dp
    for (int step = 1; step <= k; step++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        dp[i][j][step] += dp[x][y][step-1] / 8.0;
                    }
                }
            }
        }
    }

    // Return the probability that the knight remains on the board after k moves
    double ans = 0.0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ans += dp[i][j][k];
        }
    }
    return ans;
}
}
