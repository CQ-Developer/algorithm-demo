package io.huhu.leetcode.bit.manipulation.easy.n2595;

/**
 * <a href="https://leetcode.cn/problems/number-of-even-and-odd-bits/description/">奇偶位数</a>
 */
class Solution {

    /**
     * 1 <= n <= 1000
     */
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        for (int i = 0; n != 0; i ^= 1, n >>>= 1) {
            res[i] += n & 1;
        }
        return res;
    }

}
