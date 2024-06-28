package io.huhu.leetcode.dynamic.programming.medium.n264;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/description/">Ugly Number II</a>
 */
abstract sealed class Solution permits DFSSolution, DPSolution {

    protected abstract int nthUglyNumber(int n);

}
