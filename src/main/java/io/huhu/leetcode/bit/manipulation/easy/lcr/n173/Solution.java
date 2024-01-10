package io.huhu.leetcode.bit.manipulation.easy.lcr.n173;

/**
 * <a href="https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/">点名</a>
 */
class Solution {

    public int takeAttendance(int[] records) {
        if (records.length == 1) {
            return records[0] ^ 1;
        }
        for (int i = 0; i < records.length; i++) {
            if (i != records[i]) {
                return i;
            }
        }
        return records.length;
    }

}
