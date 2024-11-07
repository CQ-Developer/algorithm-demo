package io.huhu.leetcode.n1031;

class DynamicProgramming implements Code {

    @Override
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int maxA = 0, maxB = 0, ans = 0;
        for (int i = firstLen + secondLen; i <= n; i++) {
            maxA = Math.max(maxA, preSum[i - secondLen] - preSum[i - secondLen - firstLen]);
            maxB = Math.max(maxB, preSum[i - firstLen] - preSum[i - secondLen - firstLen]);
            ans = Math.max(ans, Math.max(maxA + preSum[i] - preSum[i - secondLen], maxB + preSum[i] - preSum[i - firstLen]));
        }
        return ans;
    }

}
