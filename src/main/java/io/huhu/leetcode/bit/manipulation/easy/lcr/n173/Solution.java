package io.huhu.leetcode.bit.manipulation.easy.lcr.n173;

/**
 * <a href="https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/">点名</a>
 */
class Solution {

    public int takeAttendance(int[] records) {
        int xor = 0;
        for (int i = 0; i < records.length; i++) {
            xor ^= records[i] ^ (i + 1);
        }
        return xor;
    }

}
