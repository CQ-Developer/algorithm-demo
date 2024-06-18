package io.huhu.leetcode.dynamic.programming.medium.n375;

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
        Assertions.assertEquals(16, solution.getMoneyAmount(10));
    }

    @Test
    void test2() {
        Assertions.assertEquals(0, solution.getMoneyAmount(1));
    }

    @Test
    void test3() {
        Assertions.assertEquals(1, solution.getMoneyAmount(2));
    }

}
