package io.huhu.leetcode.bit.manipulation.easy.n136;

/**
 * <a href="https://leetcode.cn/problems/single-number/description/">只出现一次的数字</a>
 */
public class Solution {

    /**
     * <p>异或运算: 相同为0, 不同为1
     * <p>a ^ a = 0
     * <p>0 ^ a = a
     * <p>a ^ b ^ b = a
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
