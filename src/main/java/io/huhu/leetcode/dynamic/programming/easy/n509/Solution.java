package io.huhu.leetcode.dynamic.programming.easy.n509;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/description/">斐波那契数</a>
 */
class Solution {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
