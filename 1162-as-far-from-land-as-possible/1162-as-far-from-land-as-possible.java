class Solution {
    public int maxDistance(int[][] g) {
        int m = g.length, n = g[0].length, res = -1;
        boolean[][] v = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] == 1) { v[i][j] = true; q.offer(new int[]{i, j}); }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] c = q.poll();
                res = Math.max(res, g[c[0]][c[1]] - 1);
                for (int[] d : dirs) {
                    int x = c[0] + d[0], y = c[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !v[x][y]) {
                        v[x][y] = true;
                        g[x][y] = g[c[0]][c[1]] + 1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        return res == 0 ? -1 : res;
    }
}
