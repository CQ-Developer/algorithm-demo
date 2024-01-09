package io.huhu.leetcode.bit.manipulation.easy.n2595;

/**
 * <a href="https://leetcode.cn/problems/number-of-even-and-odd-bits/description/">奇偶位数</a>
 */
class Solution {

    /**
     * 1 <= n <= 1000
     */
    public int[] evenOddBit(int n) {
        return new int[]{Integer.bitCount(n & 0x155), Integer.bitCount(n & 0x2aa)};
    }

}
