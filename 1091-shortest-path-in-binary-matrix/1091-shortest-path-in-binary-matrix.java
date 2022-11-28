class Solution {
    
    public int[] ROWS = {0, -1, -1, -1, 0, 1, 1, 1};
    public int[] COLUMNS = {-1, -1, 0, 1, 1, 1, 0, -1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] visited = new int[grid.length][grid.length];
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1) return -1;
		if (grid[m-1][n-1] == 1) return -1;
        if (m - 1 == 0 && n - 1 == 0) return 1;
        int pathLength = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int row = curr[0] + ROWS[i];
                    int col = curr[1] + COLUMNS[i];
                    if (
                            row >= 0 && row < grid.length &&
                                    col >= 0 && col < grid[0].length &&
                                    grid[row][col] == 0 && visited[row][col] == 0) {
                        if (row == m - 1 && col == n - 1) {
                            pathLength++;
                            return pathLength;
                        }
                        queue.offer(new int[]{row, col});
                        visited[row][col] = 1;
                    }
                }
            }
            pathLength++;
        }

        return -1;
    }
}