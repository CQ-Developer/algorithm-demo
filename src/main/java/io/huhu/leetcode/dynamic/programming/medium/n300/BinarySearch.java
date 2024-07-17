package io.huhu.leetcode.dynamic.programming.medium.n300;

class BinarySearch implements Solution {

    @Override
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        // f[i]: 长度为i+1的递增子序列中最后一位数字(即最大值)
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = binarySearch(f, len, nums[i]);
            if (j == -1) {
                f[len++] = nums[i];
            } else {
                f[j] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] f, int len, int num) {
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (num <= f[m]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
