package io.huhu.leetcode.n698;

import java.util.Arrays;

public class DFS implements Code {

    @Override
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int edge = 0;
        for (int num : nums) {
            edge += num;
        }
        if (edge % k != 0) {
            return false;
        }
        edge /= k;
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[n - 1] > edge) {
            return false;
        }
        return f(nums, edge, (1 << n) - 1, 0, k, new int[1 << n]);
    }

    private boolean f(int[] nums, int edge, int sta, int cur, int res, int[] m) {
        if (res == 0) {
            return sta == 0;
        }
        if (m[sta] != 0) {
            return m[sta] == 1;
        }
        boolean ans = false;
        for (int i = nums.length - 1; i >= 0 && !ans; i--) {
            if (((1 << i) & sta) != 0) {
                int len = cur + nums[i];
                if (len == edge) {
                    ans = f(nums, edge, sta ^ (1 << i), 0, res - 1, m);
                } else if (len < edge) {
                    ans = f(nums, edge, sta ^ (1 << i), len, res, m);
                }
            }
        }
        m[sta] = ans ? 1 : -1;
        return ans;
    }

}
