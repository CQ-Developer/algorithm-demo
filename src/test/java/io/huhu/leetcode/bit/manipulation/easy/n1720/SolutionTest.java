package io.huhu.leetcode.bit.manipulation.easy.n1720;

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
    void decode_1() {
        int[] encoded = {1, 2, 3};
        int[] expected = {1, 0, 2, 1};
        Assertions.assertArrayEquals(expected, solution.decode(encoded, 1));
    }

    @Test
    void decode_2() {
        int[] encoded = {6, 2, 7, 3};
        int[] expected = {4, 2, 0, 7, 4};
        Assertions.assertArrayEquals(expected, solution.decode(encoded, 4));
    }

}
