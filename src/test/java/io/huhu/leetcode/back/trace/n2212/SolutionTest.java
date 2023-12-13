package io.huhu.leetcode.back.trace.n2212;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    /**
     * <img src="https://pic.leetcode-cn.com/1647744752-kQKrXw-image.png"/>
     */
    @Test
    void case_1() {
        int numArrows = 9;
        int[] aliceArrows = {1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0};
        int[] actual = solution.maximumBobPoints(numArrows, aliceArrows);
        int[] expected = {0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1};
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * <img src="https://pic.leetcode-cn.com/1647744785-cMHzaC-image.png"/>
     */
    @Test
    void case_2() {
        int numArrows = 3;
        int[] aliceArrows = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2};
        int[] actual = solution.maximumBobPoints(numArrows, aliceArrows);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

}
