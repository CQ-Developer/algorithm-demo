package io.huhu.leetcode.dynamic.programming.easy.interview.n17.n16;

/**
 * <a href="https://leetcode.cn/problems/the-masseuse-lcci/description/">按摩师</a>
 */
class Solution {

    public int massage(int[] nums) {
        // a表示上一个活没接的情况下的最大连续时间
        // b表示接了上一个活的情况下的最大连续时间
        int a = 0, b = 0;
        for (int n : nums) {
            // a + n 表示上一个活没接，所以这一次能接
            int c = Math.max(b, a + n);
            a = b;
            b = c;
        }
        return b;
    }

}
