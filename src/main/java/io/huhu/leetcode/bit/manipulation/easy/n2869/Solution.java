package io.huhu.leetcode.bit.manipulation.easy.n2869;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-collect-elements/description/">收集元素的最少操作次数</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 50</li>
     * <li>1 <= nums[i] <= nums.length</li>
     * <li>1 <= k <= nums.length</li>
     * <li>输入保证你可以收集到元素1, 2, ..., k</li>
     * </ul>
     */
    public int minOperations(List<Integer> nums, int k) {
        long mask = 0;
        int cnt = 0, ops = 0;
        for (int i = nums.size() - 1; i >= 0 && cnt < k; i--) {
            int num = nums.get(i);
            long bit = 1L << num;
            if (num <= k && ((mask & bit) == 0)) {
                mask |= bit;
                cnt++;
            }
            ops++;
        }
        return ops;
    }

}
