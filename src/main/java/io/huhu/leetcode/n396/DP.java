package io.huhu.leetcode.n396;

class DP implements Code {

    @Override
    public int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        // f(i) = f(i-1) + sum - n * nums[n - i]
        int ans = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }

}
