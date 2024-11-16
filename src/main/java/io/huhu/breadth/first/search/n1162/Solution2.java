package io.huhu.breadth.first.search.n1162;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution2 implements Code {

    private static final int[] M = {-1, 0, 1, 0, -1};

    @Override
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[] p = null;
        while (!queue.isEmpty()) {
            var _p = queue.poll();
            int _x = _p[0], _y = _p[1];
            for (int i = 0; i < 4; i++) {
                int x = _x + M[i], y = _y + M[i + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = grid[_x][_y] + 1;
                    queue.offer(new int[]{x, y});
                    p = _p;
                }
            }
        }
        if (p == null) {
            return -1;
        }
        return grid[p[0]][p[1]];
    }

}
