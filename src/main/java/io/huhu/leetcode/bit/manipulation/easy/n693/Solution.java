package io.huhu.leetcode.bit.manipulation.easy.n693;

/**
 * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/description/">交替位二进制数</a>
 */
class Solution {

    public boolean hasAlternatingBits(int n) {
        if ((n & 1) == 1) {
            return (0x55555555 & n) == n && (n & 1) == 1;
        }
        return (0xaaaaaaaa & n) == n && (n & 2) == 2;
    }

}
