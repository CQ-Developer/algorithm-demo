package io.huhu.leetcode.dynamic.programming.easy.lcr126;

/**
 * <a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/">斐波那契数</a>
 */
class Solution {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre = 0, cur = 1;
        for (int i = 1; i < n; i++) {
            cur = pre + cur;
            pre = cur - pre;
            cur %= 1000000007;
        }
        return cur;
    }

}
