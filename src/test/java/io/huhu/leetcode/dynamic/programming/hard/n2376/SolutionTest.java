package io.huhu.leetcode.dynamic.programming.hard.n2376;

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
        Assertions.assertEquals(19, solution.countSpecialNumbers(20));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(5, solution.countSpecialNumbers(5));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(110, solution.countSpecialNumbers(135));
    }

}
