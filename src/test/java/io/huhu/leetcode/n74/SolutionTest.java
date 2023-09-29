package io.huhu.leetcode.n74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void searchMatrix_1() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        assertTrue(solution.searchMatrix(matrix, 3));
    }

    @Test
    void searchMatrix_2() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        assertFalse(solution.searchMatrix(matrix, 13));
    }

}
