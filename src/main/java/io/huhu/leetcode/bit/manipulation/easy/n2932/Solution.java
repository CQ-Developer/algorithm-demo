package io.huhu.leetcode.bit.manipulation.easy.n2932;

/**
 * <a href="https://leetcode.cn/problems/maximum-strong-pair-xor-i/description/">找出强数对的最大异或值I</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 50</li>
     * <li>1 <= nums[i] <= 100</li>
     * </ul>
     */
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int a : nums) {
            for (int b : nums) {
                int xor = a ^ b;
                if (xor > max && Math.abs(a - b) <= Math.min(a, b)) {
                    max = xor;
                }
            }
        }
        return max;
    }

}
