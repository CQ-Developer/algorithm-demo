package io.huhu.leetcode.dynamic.programming.easy.n1025;

/**
 * <a href="https://leetcode.cn/problems/divisor-game/description/">除数博弈</a>
 */
class Solution {

    public boolean divisorGame(int n) {
        boolean[] f = new boolean[n + 1];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

}
