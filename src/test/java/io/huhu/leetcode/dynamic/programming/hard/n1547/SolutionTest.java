package io.huhu.leetcode.dynamic.programming.hard.n1547;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    protected abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        int[] cuts = {1, 3, 4, 5};
        Assertions.assertEquals(16, solution.minCost(7, cuts));
    }

    @Test
    void test_2() {
        int[] cuts = {5, 6, 1, 4, 2};
        Assertions.assertEquals(22, solution.minCost(9, cuts));
    }

}
