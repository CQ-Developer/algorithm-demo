package io.huhu.leetcode.bit.manipulation.medium.n29;

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
    void divide_1() {
        Assertions.assertEquals(3, solution.divide(10, 3));
    }

    @Test
    void divide_2() {
        Assertions.assertEquals(-2, solution.divide(7, -3));
    }

}
