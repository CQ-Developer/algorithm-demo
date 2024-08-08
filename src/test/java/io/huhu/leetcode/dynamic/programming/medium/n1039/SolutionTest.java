package io.huhu.leetcode.dynamic.programming.medium.n1039;

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
        int[] values = {1, 2, 3};
        Assertions.assertEquals(6, solution.minScoreTriangulation(values));
    }

    @Test
    void test_2() {
        int[] values = {3, 7, 4, 5};
        Assertions.assertEquals(144, solution.minScoreTriangulation(values));
    }

    @Test
    void test_3() {
        int[] values = {1, 3, 1, 4, 1, 5};
        Assertions.assertEquals(13, solution.minScoreTriangulation(values));
    }

}
