package io.huhu.leetcode.classic.other.n12;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P3205">合唱队</a>
 */
class Main {

    static final int MOD = 19650827;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = dp(nums, n);
        System.out.println(ans);
    }

    private static int dp(int[] nums, int n) {
        if (n == 1) {
            return 1;
        }
        int[][][] dp = new int[n + 1][n + 1][2];
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i + 1]) {
                dp[i][i + 1][0] = dp[i][i + 1][1] = 1;
            }
        }
        for (int l = n - 2; l >= 1; l--) {
            for (int r = l + 2; r <= n; r++) {
                // l -> [l+1...r)
                if (nums[l] < nums[l + 1]) {
                    dp[l][r][0] = (dp[l][r][0] + dp[l + 1][r][0]) % MOD;
                }
                // l -> (l+1...r]
                if (nums[l] < nums[r]) {
                    dp[l][r][0] = (dp[l][r][0] + dp[l + 1][r][1]) % MOD;
                }
                // r -> [l...r-1)
                if (nums[r] > nums[l]) {
                    dp[l][r][1] = (dp[l][r][1] + dp[l][r - 1][0]) % MOD;
                }
                // r -> (l...r-1]
                if (nums[r] > nums[r - 1]) {
                    dp[l][r][1] = (dp[l][r][1] + dp[l][r - 1][1]) % MOD;
                }
            }
        }
        return (dp[1][n][0] + dp[1][n][1]) % MOD;
    }

    static int test(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 1];
        System.arraycopy(nums, 0, a, 1, n);
        return dp(a, n);
    }

}
