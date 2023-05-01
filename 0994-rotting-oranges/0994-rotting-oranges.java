class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, fresh = 0, minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        if (fresh == 0) return 0;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean progressMade = false;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : dir) {
                    int r = cur[0] + d[0], c = cur[1] + d[1];
                    if (0 <= r && r < rows && 0 <= c && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r, c});
                        progressMade = true;
                    }
                }
            }

            if (progressMade) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
