package io.huhu.leetcode.bit.manipulation.easy.interview.n16.n07;

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
    void maximum_1() {
        Assertions.assertEquals(2, solution.maximum(1, 2));
    }

    @Test
    void maximum_2() {
        Assertions.assertEquals(2147483647, solution.maximum(2147483647, -2147483648));
    }

}
