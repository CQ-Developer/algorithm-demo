package io.huhu.leetcode.n79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void exist_1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "ABCCED";
        assertTrue(solution.exist(board, word));
    }

    @Test
    void exist_2() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "SEE";
        assertTrue(solution.exist(board, word));
    }

    @Test
    void exist_3() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "ABCB";
        assertFalse(solution.exist(board, word));
    }

}
