package io.huhu.leetcode.dynamic.programming.hard.n902;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        String[] digits = {"1", "3", "5", "7"};
        Assertions.assertEquals(20, solution.atMostNGivenDigitSet(digits, 100));
    }

    @Test
    void test_2() {
        String[] digits = {"1", "4", "9"};
        Assertions.assertEquals(29523, solution.atMostNGivenDigitSet(digits, 1000000000));
    }

    @Test
    void test_3() {
        String[] digits = {"7"};
        Assertions.assertEquals(1, solution.atMostNGivenDigitSet(digits, 8));
    }

}
