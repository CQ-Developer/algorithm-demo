package io.huhu.leetcode.dynamic.programming.medium.n474;

final class DFS implements Solution {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n, new int[strs.length][], new int[strs.length][m + 1][n + 1]);
    }

    private int dfs(String[] strs, int i, int m, int n, int[][] bc, int[][][] mem) {
        if (i == strs.length) {
            return 0;
        }
        if (mem[i][m][n] != 0) {
            return mem[i][m][n];
        }
        int x = dfs(strs, i + 1, m, n, bc, mem);
        int y = 0;
        int[] b = binaryCount(strs, i, bc);
        if (m >= b[0] && n >= b[1]) {
            y = dfs(strs, i + 1, m - b[0], n - b[1], bc, mem) + 1;
        }
        return mem[i][m][n] = Math.max(x, y);
    }

    private int[] binaryCount(String[] strs, int i, int[][] bc) {
        if (bc[i] != null) {
            return bc[i];
        }
        int[] arr = new int[2];
        for (int j = 0; j < strs[i].length(); j++) {
            char c = strs[i].charAt(j);
            if (c == '0') {
                arr[0]++;
            }
            if (c == '1') {
                arr[1]++;
            }
        }
        return bc[i] = arr;
    }

}
