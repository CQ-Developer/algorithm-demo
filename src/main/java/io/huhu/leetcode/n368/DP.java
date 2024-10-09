package io.huhu.leetcode.n368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DP implements Code {

    @Override
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int idx = 0, len = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; nums[j] <= nums[i] >> 1; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            if (++dp[i] > len) {
                idx = i;
                len = dp[i];
            }
        }
        List<Integer> ans = new ArrayList<>(len);
        for (int i = idx; i >= 0 && len > 0; i--) {
            if (len == dp[i] && nums[idx] % nums[i] == 0) {
                ans.add(nums[i]);
                len--;
                idx = i;
            }
        }
        return ans;
    }

}
