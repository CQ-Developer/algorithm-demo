package io.huhu.leetcode.bit.manipulation.easy.n1342;

/**
 * <a href="https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/description/">将数字变成0的操作次数</a>
 */
class Solution {

    /**
     * 0 <= num <= 10<sup>6</sup>
     */
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            num = (num & 1) == 1 ? num - 1 : num >> 1;
            res++;
        }
        return res;
    }

}
