package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n06;

/**
 * <a href="https://leetcode.cn/problems/convert-integer-lcci/description/">整数转换</a>
 */
class Solution {

    public int convertInteger(int A, int B) {
        int m = A ^ B, c = 0;
        while (m != 0) {
            m &= (m - 1);
            c++;
        }
        return c;
    }

}
