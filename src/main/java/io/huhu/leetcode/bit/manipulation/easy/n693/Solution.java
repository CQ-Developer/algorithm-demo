package io.huhu.leetcode.bit.manipulation.easy.n693;

/**
 * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/description/">交替位二进制数</a>
 */
class Solution {

    public boolean hasAlternatingBits(int n) {
        int m = (n & 1) == 1 ? 0x55555555 : 0xaaaaaaaa;
        return (m & n) == n;
    }

}
