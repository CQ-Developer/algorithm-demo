package io.huhu.leetcode.dynamic.programming.medium.n516;

final class DFSSolution extends Solution {

    @Override
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int[][] mem = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                mem[i][j] = -1;
            }
        }
        return dfs(arr, 0, arr.length - 1, mem);
    }

    private int dfs(char[] s, int l, int r,  int[][] mem) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 2 : 1;
        }
        if (mem[l][r] != -1) {
            return mem[l][r];
        }
        if (s[l] == s[r]) {
            return mem[l][r] = dfs(s, l + 1, r - 1, mem) + 2;
        }
        return mem[l][r] = Math.max(dfs(s, l + 1, r, mem), dfs(s, l, r - 1, mem));
    }

}
