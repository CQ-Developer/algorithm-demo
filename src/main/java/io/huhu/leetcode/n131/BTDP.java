package io.huhu.leetcode.n131;

import java.util.ArrayList;
import java.util.List;

class BTDP implements Code {

    @Override
    public List<List<String>> partition(String s) {
        char[] c = s.toCharArray();
        List<List<String>> ans = new ArrayList<>();
        f(isPalindrmoe(c, c.length), c, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void f(boolean[][] dp, char[] s, int i, List<String> path, List<List<String>> ans) {
        if (i == s.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length; j++) {
            if (dp[i][j]) {
                path.addLast(String.valueOf(s, i, j - i + 1));
                f(dp, s, j + 1, path, ans);
                path.removeLast();
            }
        }
    }

    /**
     * 使用DP算法提前计算0...n-1区间的所有回文串的可能性
     */
    private boolean[][] isPalindrmoe(char[] s, int n) {
        boolean[][] dp = new boolean[n][n];
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                dp[l][r] = s[l] == s[r] && (r - l < 2 || dp[l + 1][r - 1]);
            }
        }
        return dp;
    }

}
