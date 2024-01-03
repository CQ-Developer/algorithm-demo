package io.huhu.leetcode.bit.manipulation.easy.n268;

/**
 * <a href="https://leetcode.cn/problems/missing-number/description/">丢失的数字</a>
 */
class Solution {

    /**
     * 使用位运算的方式:
     * 假设 nums = [3, 0, 1]
     * n = nums.length = 3, 需要判断 0 ~ 3 种缺少那个数字
     *    0 = 00
     *    1 = 01
     * -> 2 = 10
     *    3 = 11
     * 异或运算: 相同为0, 不同为1
     * a ^ a = 0
     * a ^ b == b ^ a (交换法则)
     * 0 ^ a = a
     * 在原数组后面加上0~3
     *     3 ^ 0 ^ 1 ^ 0 ^ 1 ^ 2 ^ 3 = 2
     * 根据交换法则相当于
     *     3 ^ 3 ^ 0 ^ 0 ^ 1 ^ 1 ^ 2
     *   =   0   ^   0   ^   0   ^   2
     *   = 0 ^ 2
     *   = 2
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        return res;
    }

}
