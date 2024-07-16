package io.huhu.leetcode.classic.other.n3;

/**
 * 删掉1个数字后长度为k的子数组最大累加和
 */
class Code {

    public int maxSumOfSubarray(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) {
            return 0;
        }
        int[] window = new int[n];
        int l = 0, r = 0;
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (l < r && nums[window[r - 1]] >= nums[i]) {
                r--;
            }
            window[r++] = i;
            sum += nums[i];
            if (i >= k) {
                ans = Integer.max(ans, sum - nums[window[l]]);
                if (window[l] == i - k) {
                    l++;
                }
                sum -= nums[i - k];
            }
        }
        return ans;
    }

}
