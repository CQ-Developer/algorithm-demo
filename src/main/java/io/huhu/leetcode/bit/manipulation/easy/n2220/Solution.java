package io.huhu.leetcode.bit.manipulation.easy.n2220;

/**
 * <a href="https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/description/">转换数字的最少位反转次数</a>
 */
class Solution {

    /**
     * <ul>
     * <li>0 <= start, goal <= 10<sup>9</sup></li>
     * </ul>
     */
    public int minBitFlips(int start, int goal) {
        int i = 0, cnt = 0;
        while (start != goal && i < 32) {
            int mask = 1 << i++;
            if ((goal & mask) != (start & mask)) {
                start ^= mask;
                cnt++;
            }
        }
        return cnt;
    }

}
