package io.huhu.leetcode.bit.manipulation.easy.interview.n16.n07;

/**
 * <a href="https://leetcode.cn/problems/maximum-lcci/description/">最大数值</a>
 */
class Solution {

    public int maximum(int a, int b) {
        long m = (long) a - b;
        int i = (int) (m >> 63);
        return (1 + i) * a - i * b;
    }

}
