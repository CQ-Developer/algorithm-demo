package io.huhu.leetcode.dynamic.programming.hard.n664;

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
        Assertions.assertEquals(2, solution.strangePrinter("aaabbb"));

    }

    @Test
    void test_2() {
        Assertions.assertEquals(2, solution.strangePrinter("aba"));
    }

}
