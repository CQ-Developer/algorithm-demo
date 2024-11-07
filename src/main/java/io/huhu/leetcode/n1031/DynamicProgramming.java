package io.huhu.leetcode.n1031;

class DynamicProgramming implements Code {

    @Override
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        return Math.max(f(preSum, firstLen, secondLen), f(preSum, secondLen, firstLen));
    }

    /**
     * 假设b的区间为[i-secondLen,i), 则b区间的和为perSum[i]-preSum[i-secondLen]
     * 由于左侧需要给a预留空间, 所以i>=firstLen+secondLen,
     * 得到a的区间为[i-firstLen-secondLen,i-secondLen),
     * 则a区间的和为 perSum[i-firstLen]-perSum[i-firstLen-secondLen]
     */
    private int f(int[] sum, int len1, int len2) {
        int maxA = 0, ans = 0;
        for (int i = len1 + len2; i < sum.length; i++) {
            maxA = Math.max(maxA, sum[i - len2] - sum[i - len2 - len1]);
            ans = Math.max(ans, maxA + sum[i] - sum[i - len2]);
        }
        return ans;
    }

}
