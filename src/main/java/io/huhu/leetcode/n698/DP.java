package io.huhu.leetcode.n698;

import java.util.Arrays;

class DP implements Code {

    @Override
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int m = 0;
        for (int num : nums) {
            m += num;
        }
        if (m % k != 0) {
            return false;
        }
        m /= k;
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[n - 1] > m) {
            return false;
        }
        int[] f = new int[1 << n];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int s = 1; s < f.length; s++) {
            for (int i = n - 1; i >= 0; i--) {
                if (((1 << i) & s) != 0) {
                    int _s = s ^ (1 << i);
                    if (f[_s] >= 0 && f[_s] + nums[i] <= m) {
                        f[s] = (f[_s] + nums[i]) % m;
                        break;
                    }
                }
            }
        }
        return f[f.length - 1] == 0;
    }

}
