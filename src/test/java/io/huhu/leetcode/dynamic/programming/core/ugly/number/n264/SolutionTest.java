package io.huhu.leetcode.dynamic.programming.core.ugly.number.n264;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        Assertions.assertEquals(12, solution.nthUglyNumber(10));
    }

    @Test
    void test2() {
        Assertions.assertEquals(1, solution.nthUglyNumber(1));
    }

}