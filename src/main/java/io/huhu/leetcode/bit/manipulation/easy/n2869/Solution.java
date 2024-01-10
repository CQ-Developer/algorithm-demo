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
        while (k != 0) {
            mask |= 1;
            mask <<= 1;
            k--;
        }
        int cnt = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            long bit = 1L << nums.get(i);
            if ((mask & bit) == bit) {
                mask ^= bit;
            }
            cnt++;
            if (mask == 0) {
                break;
            }
        }
        return cnt;
    }

}
