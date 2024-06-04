package io.huhu.leetcode.dynamic.programming.core.ugly.number.n1201;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-iii/description/">丑数III</a>
 */
class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n];
        dp[0] = Math.min(Math.min(a, b), c);
        int num = dp[0] + 1;
        for (int i = 1; i < n; ) {
            if (num % a == 0 || num % b == 0 || num % c == 0) {
                dp[i++] = num;
            }
            num++;
        }
        return dp[n - 1];
    }

}
