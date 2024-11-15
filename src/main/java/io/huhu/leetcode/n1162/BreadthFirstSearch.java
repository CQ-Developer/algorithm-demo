package io.huhu.leetcode.n1162;

import io.huhu.AC;

import java.util.LinkedList;
import java.util.Queue;

@AC
class BreadthFirstSearch implements Code {

    private static final int[][] D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private record Coordinate(int x, int y) {}

    @Override
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 从陆地出发
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        // 记录是否有海洋以及它与陆地间的距离
        Coordinate point = null;
        // BFS
        while (!queue.isEmpty()) {
            var _point = queue.poll();
            int _x = _point.x(), _y = _point.y();
            for (int[] d : D) {
                int x = _x + d[0], y = _y + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    // 到达了海洋并继续向外搜索
                    point = _point;
                    grid[x][y] = grid[_x][_y] + 1;
                    queue.offer(new Coordinate(x, y));
                }
            }
        }
        if (point == null) {
            // 没有陆地或没有海洋
            return -1;
        }
        return grid[point.x()][point.y()];
    }

}
