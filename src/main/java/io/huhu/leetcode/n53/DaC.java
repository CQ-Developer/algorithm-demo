package io.huhu.leetcode.n53;

class DaC implements Code {

    @Override
    public int maxSubArray(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }

    private int f(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int m = (l + r) >> 1;
        return max(f(nums, l, m), midMax(nums, l, m, r), f(nums, m + 1, r));
    }

    private int midMax(int[] nums, int l, int m, int r) {
        int sum = 0;
        int maxL = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            maxL = Math.max(maxL, sum);
        }
        sum = 0;
        int maxR = Integer.MIN_VALUE;
        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            maxR = Math.max(maxR, sum);
        }
        return maxL + maxR;
    }

    private int max(int l, int m, int r) {
        return Math.max(l, Math.max(m, r));
    }

}
