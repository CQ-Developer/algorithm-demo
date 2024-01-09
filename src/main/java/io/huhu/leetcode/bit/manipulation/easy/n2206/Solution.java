package io.huhu.leetcode.bit.manipulation.easy.n2206;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/divide-array-into-equal-pairs/description/">将数组划分成相等数对</a>
 */
class Solution {

    /**
     * <ul>
     * <li>nums.length == 2 * n</li>
     * <li>1 <= n <= 500</li>
     * <li>1 <= nums[i] <= 500</li>
     * </ul>
     */
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
