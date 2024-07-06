package io.huhu.leetcode.dynamic.programming.medium.n474;

final class DP implements Solution {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (String s : strs) {
            int z = 0, o = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    z++;
                }
                if (c == '1') {
                    o++;
                }
            }
            for (int i = m; i >= z; i--) {
                for (int j = n; j >= o; j--) {
                    f[i][j] = Math.max(f[i][j], f[i - z][j - o] + 1);
                }
            }
        }
        return f[m][n];
    }

}
