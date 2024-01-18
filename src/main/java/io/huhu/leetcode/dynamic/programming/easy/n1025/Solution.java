package io.huhu.leetcode.dynamic.programming.easy.n1025;

/**
 * <a href="https://leetcode.cn/problems/divisor-game/description/">除数博弈</a>
 */
class Solution {

    public boolean divisorGame(int n) {
        return (n & 1) == 0;
    }

}
