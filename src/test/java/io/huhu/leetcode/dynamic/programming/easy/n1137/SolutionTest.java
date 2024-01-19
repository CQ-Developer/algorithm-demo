package io.huhu.leetcode.dynamic.programming.easy.n1137;

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
    void tribonacci_1() {
        Assertions.assertEquals(4, solution.tribonacci(4));
    }

    @Test
    void tribonacci_2() {
        Assertions.assertEquals(1389537, solution.tribonacci(25));
    }

}
