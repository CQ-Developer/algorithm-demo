package io.huhu.leetcode.n64;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void minPathSum_1() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        assertEquals(7, solution.minPathSum(grid));
    }

    @Test
    void minPathSum_2() {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}};
        assertEquals(12, solution.minPathSum(grid));
    }

}
