from typing import List
import collections

class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        n = len(grid)
        direct = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def invalid(r, c):
            return r < 0 or c < 0 or r == n or c == n

        visit = set()

        def dfs(r, c):
            if invalid(r, c) or not grid[r][c] or (r, c) in visit:
                return
            visit.add((r, c))
            for dr, dc in direct:
                dfs(r + dr, c + dc)

        def bfs():
            res = 0
            q = collections.deque(visit)
            while q:
                length = len(q)
                for i in range(length):
                    r, c = q.popleft()
                    for dr, dc in direct:
                        curR, curC = r + dr, c + dc
                        if invalid(curR, curC) or (curR, curC) in visit:
                            continue
                        if grid[curR][curC]:
                            return res
                        q.append((curR, curC))
                        visit.add((curR, curC))
                res += 1
            return res

        for i in range(n):
            for j in range(n):
                if grid[i][j]:
                    dfs(i, j)
                    return bfs()
