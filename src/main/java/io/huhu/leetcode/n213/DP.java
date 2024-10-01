package io.huhu.leetcode.n213;

class DP implements Code {

    @Override
    public int rob(int[] nums) {
        int n = nums.length;
        int a = f(nums, 0, n - 2);
        int b = f(nums, 1, n - 1);
        return Math.max(a, b);
    }

    private int f(int[] nums, int l, int r) {
        int a = 0, b = nums[l];
        for (int i = l + 1; i <= r; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

}
