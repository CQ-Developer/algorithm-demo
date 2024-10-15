package io.huhu.leetcode.n542;

import java.util.ArrayList;
import java.util.List;

class BFS implements Code {

    private final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    @Override
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<int[]> queue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.addLast(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        // 从0向外扩散
        // 0 -> 1 -> 2 -> ... 直到所有点都被到达
        while (!queue.isEmpty()) {
            int[] coordinate = queue.removeFirst();
            int x = coordinate[0], y = coordinate[1];
            for (int[] dir : DIRECTION) {
                int i = x + dir[0], j = y + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && mat[i][j] == -1) {
                    mat[i][j] = mat[x][y] + 1;
                    queue.addLast(new int[]{i, j});
                }
            }
        }
        return mat;
    }

}
