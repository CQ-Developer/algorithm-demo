package io.huhu.leetcode.dynamic.programming.medium.n1049;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    protected abstract Solution getSolution();

    @Test
    void test_1() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        Assertions.assertEquals(1, solution.lastStoneWeightII(stones));
    }

    @Test
    void test_2() {
        int[] stones = {31, 26, 33, 21, 40};
        Assertions.assertEquals(5, solution.lastStoneWeightII(stones));
    }

}
