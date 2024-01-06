package io.huhu.leetcode.bit.manipulation.easy.n693;

/**
 * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/description/">交替位二进制数</a>
 */
class Solution {

    public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }

}
