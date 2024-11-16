package io.huhu.breadth.first.search.n1162;

class Solution1 implements Code {

    private static final int N = 100 + 1;
    private static final int[][] QUEUE = new int[N * N][2];
    private static final boolean[][] VISITED = new boolean[N][N];
    private static final int[] MOVE = {-1, 0, 1, 0, -1};

    @Override
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int l = 0, r = 0, ocean = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    VISITED[i][j] = true;
                    QUEUE[r][0] = i;
                    QUEUE[r][1] = j;
                    r++;
                } else {
                    VISITED[i][j] = false;
                    ocean++;
                }
            }
        }
        if (ocean == 0 || ocean == n * m) {
            return -1;
        }
        int ans = 0;
        while (l < r) {
            ans++;
            int size = r - l;
            for (int k = 0; k < size; k++) {
                int _x = QUEUE[l][0], _y = QUEUE[l][1];
                l++;
                for (int i = 0; i < 4; i++) {
                    int x = _x + MOVE[i], y = _y + MOVE[i + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !VISITED[x][y]) {
                        VISITED[x][y] = true;
                        QUEUE[r][0] = x;
                        QUEUE[r][1] = y;
                        r++;
                    }
                }
            }
        }
        return ans - 1;
    }

}
