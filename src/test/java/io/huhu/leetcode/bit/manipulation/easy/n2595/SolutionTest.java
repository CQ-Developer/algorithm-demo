package io.huhu.leetcode.bit.manipulation.easy.n2595;

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
    void evenOddBit_1() {
        int[] expected = {2, 0};
        Assertions.assertArrayEquals(expected, solution.evenOddBit(17));
    }

    @Test
    void evenOddBit_2() {
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution.evenOddBit(2));
    }

}
