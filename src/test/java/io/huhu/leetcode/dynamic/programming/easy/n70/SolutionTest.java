package io.huhu.leetcode.dynamic.programming.easy.n70;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void climbStairs_1() {
        Assertions.assertEquals(2, solution.climbStairs(2));
    }

    @Test
    void climbStairs_2() {
        Assertions.assertEquals(3, solution.climbStairs(3));
    }

    @Test
    void climbStairs_3() {
        Assertions.assertEquals(1836311903, solution.climbStairs(45));
    }

    @Test
    void climbStairs_4() {
        Assertions.assertEquals(1, solution.climbStairs(1));
    }

}
