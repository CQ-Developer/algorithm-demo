package io.huhu.leetcode.dynamic.programming.hard.n600;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setUp() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(5, solution.findIntegers(5));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(2, solution.findIntegers(1));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(3, solution.findIntegers(2));
    }

}
