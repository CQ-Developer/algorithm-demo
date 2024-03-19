package io.huhu.leetcode.dynamic.programming.easy.interview.n08.n01;

/**
 * <a href="https://leetcode.cn/problems/three-steps-problem-lcci/description/">三步问题</a>
 */
class Solution {

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        long a = 1, b = 2, c = 4;
        for (int i = 4; i < n + 1; i++) {
            long d = a + b + c;
            a = b;
            b = c;
            c = d % 1000000007;
        }
        return (int) c;
    }

}
