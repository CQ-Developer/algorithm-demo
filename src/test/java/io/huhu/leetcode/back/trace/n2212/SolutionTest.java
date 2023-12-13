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

    @Test
    void case_3() {
        int numArrows = 89;
        int[] aliceArrows = {3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5};
        int[] actual = solution.maximumBobPoints(numArrows, aliceArrows);
        int[] expected = {21, 3, 0, 2, 8, 2, 17, 8, 4, 14, 4, 6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case_4() {
        int numArrows = 729;
        int[] aliceArrows = {56, 81, 32, 233, 85, 39, 15, 7, 11, 106, 59, 5};
        int[] actual = solution.maximumBobPoints(numArrows, aliceArrows);
        int[] expected = {45, 82, 33, 234, 86, 40, 16, 8, 12, 107, 60, 6};
        Assertions.assertArrayEquals(expected, actual);
    }

}
