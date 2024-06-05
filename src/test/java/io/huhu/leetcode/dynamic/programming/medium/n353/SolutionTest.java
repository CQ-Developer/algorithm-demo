package io.huhu.leetcode.dynamic.programming.medium.n353;

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
        Assertions.assertEquals(1, solution.integerBreak(2));
    }

    @Test
    void test2() {
        Assertions.assertEquals(36, solution.integerBreak(10));
    }

    @Test
    void test3() {
        Assertions.assertEquals(2, solution.integerBreak(3));
    }

    @Test
    void test4() {
        Assertions.assertEquals(1549681956, solution.integerBreak(58));
    }

}
