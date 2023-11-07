package io.huhu.leetcode.back.trace.n79;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void exist_1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "ABCCED";
        Assertions.assertTrue(solution.exist(board, word));
    }

    @Test
    void exist_2() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "SEE";
        Assertions.assertTrue(solution.exist(board, word));
    }

    @Test
    void exist_3() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "ABCB";
        Assertions.assertFalse(solution.exist(board, word));
    }

}