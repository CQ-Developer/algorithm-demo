package io.huhu.leetcode.dynamic.programming.medium.n688;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int n = 3, k = 2, row = 0, column = 0;
        Assertions.assertEquals(0.06250, solution.knightProbability(n, k, row, column));
    }

    @Test
    void test2() {
        int n = 1, k = 0, row = 0, column = 0;
        Assertions.assertEquals(1.00000, solution.knightProbability(n, k, row, column));
    }

}
