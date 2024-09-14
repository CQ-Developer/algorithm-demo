package io.huhu.leetcode.dynamic.programming.hard.n1012;

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
        Assertions.assertEquals(1, solution.numDupDigitsAtMostN(20));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(10, solution.numDupDigitsAtMostN(100));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(262, solution.numDupDigitsAtMostN(1000));
    }

}
