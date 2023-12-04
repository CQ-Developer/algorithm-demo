package io.huhu.leetcode.back.trace.n1718;

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
    void case1() {
        int[] expected = {3, 1, 2, 3, 2};
        int[] actual = solution.constructDistancedSequence(3);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int[] expected = {5, 3, 1, 4, 3, 5, 2, 4, 2};
        int[] actual = solution.constructDistancedSequence(5);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        int[] expected = {13, 11, 12, 8, 6, 4, 9, 10, 1, 4, 6, 8, 11, 13, 12, 9, 7, 10, 3, 5, 2, 3, 2, 7, 5};
        int[] actual = solution.constructDistancedSequence(13);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case4() {
        int[] expected = {20, 18, 19, 15, 13, 17, 10, 16, 7, 5, 3, 14, 12, 3, 5, 7, 10, 13, 15, 18, 20, 19, 17, 16, 12, 14, 11, 9, 4, 6, 8, 2, 4, 2, 1, 6, 9, 11, 8};
        int[] actual = solution.constructDistancedSequence(20);
        Assertions.assertArrayEquals(expected, actual);
    }

}
