package io.huhu.leetcode.bit.manipulation.easy.n2206;

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
        int[] table = new int[501];
        for (int num : nums) {
            table[num]++;
        }
        for (int num : table) {
            if (num != 0 && (num & 1) == 1) {
                return false;
            }
        }
        return true;
    }

}
