package io.huhu.leetcode.bit.manipulation.easy.n762;

/**
 * <a href="https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/description/">二进制表示中质数个计算置位</a>
 */
class Solution {

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += (0xa28ac & (1 << Integer.bitCount(i))) != 0 ? 1 : 0;
        }
        return res;
    }

}
