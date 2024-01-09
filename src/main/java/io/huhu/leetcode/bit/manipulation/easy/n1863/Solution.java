package io.huhu.leetcode.bit.manipulation.easy.n1863;

/**
 * <a href="https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/">找出所有子集的异或总和再求和</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 12</li>
     * <li>1 <= nums[i] <= 20</li>
     * </ul>
     */
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int i, int xor) {
        if (i == nums.length) {
            return xor;
        }
        return dfs(nums, i + 1, xor ^ nums[i]) + dfs(nums, i + 1, xor);
    }

}
