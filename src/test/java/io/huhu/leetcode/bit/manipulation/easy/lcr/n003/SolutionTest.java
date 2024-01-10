package io.huhu.leetcode.bit.manipulation.easy.lcr.n003;

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
    void countBits_1() {
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, solution.countBits(2));
    }

    @Test
    void countBits_2() {
        int[] expected = {0, 1, 1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution.countBits(5));
    }

}
