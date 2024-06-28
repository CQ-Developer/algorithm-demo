package io.huhu.leetcode.dynamic.programming.medium.n264;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract sealed class SolutionTest permits DFSSolutionTest, DPSolutionTest {

    protected Solution solution;

    abstract void setup();

    @Test
    void test_1() {
        Assertions.assertEquals(12, solution.nthUglyNumber(10));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(1, solution.nthUglyNumber(1));
    }

}
