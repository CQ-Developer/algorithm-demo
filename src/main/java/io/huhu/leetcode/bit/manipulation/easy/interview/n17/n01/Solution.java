package io.huhu.leetcode.bit.manipulation.easy.interview.n17.n01;

/**
 * <a href="https://leetcode.cn/problems/add-without-plus-lcci/description/">不用加号的加法</a>
 */
class Solution {

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

}
