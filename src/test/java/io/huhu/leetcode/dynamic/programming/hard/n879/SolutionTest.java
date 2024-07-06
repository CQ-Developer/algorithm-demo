package io.huhu.leetcode.dynamic.programming.hard.n879;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int n = 5, minProfit = 3;
        int[] group = {2, 2}, profit = {2, 3};
        Assertions.assertEquals(2, solution.profitableSchemes(n, minProfit, group, profit));
    }

    @Test
    void test2() {
        int n = 10, minProfit = 5;
        int[] group = {2, 3, 5}, profit = {6, 7, 8};
        Assertions.assertEquals(7, solution.profitableSchemes(n, minProfit, group, profit));
    }

}
