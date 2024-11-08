package io.huhu.leetcode.n1035;

class DynamicProgramming implements Code {

    @Override
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0];
            for (int j = 1; j <= n; j++) {
                int _leftUp = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftUp + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                leftUp = _leftUp;
            }
        }
        return dp[n];
    }

}
