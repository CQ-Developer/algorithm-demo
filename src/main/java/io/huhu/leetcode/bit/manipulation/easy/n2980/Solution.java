package io.huhu.leetcode.bit.manipulation.easy.n2980;

/**
 * <a href="https://leetcode.cn/problems/check-if-bitwise-or-has-trailing-zeros/description/">检查按位或是否存在尾随零</a>
 */
class Solution {

    /**
     * <ul>
     * <li>2 <= nums.length <= 100</li>
     * <li>1 <= nums[i] <= 100</li>
     * </ul>
     */
    public boolean hasTrailingZeros(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if ((num & 1) == 0 && ++cnt > 1) {
                return true;
            }
        }
        return false;
    }

}
