package io.huhu.leetcode.n1567;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n], negative = new int[n];
        int ans = positive[0] = nums[0] > 0 ? 1 : 0;
        negative[0] = nums[0] < 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] == 0 ? 0 : negative[i - 1] + 1;
            } else if (nums[i] < 0) {
                negative[i] = positive[i - 1] + 1;
                positive[i] = negative[i - 1] == 0 ? 0 : negative[i - 1] + 1;
            }
            ans = Math.max(ans, positive[i]);
        }
        return ans;
    }

}
