package io.huhu.leetcode.dynamic.programming.easy.lcr127;

/**
 * <a href="https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/description/">跳跃训练</a>
 */
class Solution {

    public int trainWays(int num) {
        int a = 1, b = 1;
        for (int i = 2; i < num + 1; i++) {
            b = a + b;
            a = b - a;
            b %= 1000000007;
        }
        return b;
    }

}
