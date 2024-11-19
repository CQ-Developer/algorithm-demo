package io.huhu.leetcode.n1218;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1, n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n && (n - i) >= ans; i++) {
            ans = Math.max(ans, f(arr, difference, dp, i));
        }
        return ans;
    }

    private int f(int[] a, int d, int[] dp, int i) {
        if (dp[i] != 0) {
            return dp[i];
        }
        int ans = 1;
        for (int j = i + 1; j < a.length; j++) {
            if (a[i] + d == a[j]) {
                ans += f(a, d, dp, j);
                break;
            }
        }
        return dp[i] = ans;
    }

}
