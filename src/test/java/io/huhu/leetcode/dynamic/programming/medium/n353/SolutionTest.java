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

}
