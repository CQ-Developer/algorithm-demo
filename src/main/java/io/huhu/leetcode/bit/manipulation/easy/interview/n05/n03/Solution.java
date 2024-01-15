package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n03;

/**
 * <a href="https://leetcode.cn/problems/reverse-bits-lcci/description/">翻转数位</a>
 */
class Solution {

    public int reverseBits(int num) {
        int res = 0, cur = 0, max = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                cur++;
                max++;
            } else {
                max = cur + 1;
                cur = 0;
            }
            if (max > res) {
                res = max;
            }
            num >>>= 1;
        }
        return res;
    }

}
