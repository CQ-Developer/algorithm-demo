package io.huhu.leetcode.back.trace.lcr.n129;

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
    void case_1() {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String target = "ABCCED";
        Assertions.assertTrue(solution.wordPuzzle(grid, target));
    }

    @Test
    void case_2() {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String target = "SEE";
        Assertions.assertTrue(solution.wordPuzzle(grid, target));
    }

    @Test
    void case_3() {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String target = "ABCB";
        Assertions.assertFalse(solution.wordPuzzle(grid, target));
    }

}
