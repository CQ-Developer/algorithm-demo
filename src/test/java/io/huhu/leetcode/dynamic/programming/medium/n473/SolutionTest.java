package io.huhu.leetcode.dynamic.programming.medium.n473;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    abstract Solution getSolution();

    @Test
    void test1() {
        int[] matchsticks = {1, 1, 2, 2, 2};
        Assertions.assertTrue(solution.makesquare(matchsticks));
    }

    @Test
    void test2() {
        int[] matchsticks = {3, 3, 3, 3, 4};
        Assertions.assertFalse(solution.makesquare(matchsticks));
    }

}
