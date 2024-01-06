package io.huhu.leetcode.bit.manipulation.easy.n693;

/**
 * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/description/">交替位二进制数</a>
 */
class Solution {

    /**
     * 如果 {@code n} 是交替二进制数, 比如 {@code 101},
     * 那么 {@code n ^ (n >> 1) = 111}.
     * {@code 0101 >> 1 = 10}, {@code 101 ^ 010 = 111}.
     * {@code 111 + 1 = 1000}, {@code 0111 & 1000 = 0}.
     */
    public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }

}
