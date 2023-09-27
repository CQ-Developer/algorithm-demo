package io.huhu.leetcode.n59;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void generateMatrix_1() {
        int n = 3;
        int[][] expected = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};
        assertArrayEquals(expected, solution.generateMatrix(n));
    }

    @Test
    void generateMatrix_2() {
        int n = 1;
        int[][] expected = {{1}};
        assertArrayEquals(expected, solution.generateMatrix(n));
    }

}
