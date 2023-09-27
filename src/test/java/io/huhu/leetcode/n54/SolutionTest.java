package io.huhu.leetcode.n54;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void spiralOrder_1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        var expected = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertIterableEquals(expected, solution.spiralOrder(matrix));
    }

    @Test
    void spiralOrder_2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        var expected = List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertIterableEquals(expected, solution.spiralOrder(matrix));
    }

}
